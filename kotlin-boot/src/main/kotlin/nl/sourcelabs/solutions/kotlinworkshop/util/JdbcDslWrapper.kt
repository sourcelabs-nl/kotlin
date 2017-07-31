package nl.sourcelabs.solutions.kotlinworkshop.util

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Component
import java.util.*

/**
 * In this project, we get a jdbcTemplate that's added to the context automatically
 * when adding the H2 database. We create a Spring component that tries to expose this template
 * to the wrapper functionality provided below. This allows us to use a default parameter for the jdbctemplate, if it is 
 * already provided we can use that to prevent having to pass one as a parameter from the repository classes using this.
 */
@Component
private class JdbcProvider : ApplicationContextAware {

    companion object {
        val logger = LoggerFactory.getLogger(JdbcProvider::class.java)!!
        lateinit var template: NamedParameterJdbcTemplate
            private set
    }

    override fun setApplicationContext(ctx: ApplicationContext) {
        try {
            template = NamedParameterJdbcTemplate(ctx.getBean(JdbcTemplate::class.java))
        } catch(exc: Exception) {
            logger.warn("No jdbctemplate component found - unable to default to this jdbctemplate for operations.")
        }
    }
}

/**
 * FindOne function, tailor made for findAll operations that return one entity of type T
 */
fun <T> findOne(jdbcTemplate: NamedParameterJdbcTemplate = JdbcProvider.template, init: JdbcDslWrapper<T>.() -> Any): T? {
    val wrapper = JdbcDslWrapper<T>()
    wrapper.init()
    return jdbcTemplate.queryForObject(wrapper.usingStatement(), wrapper.params(), wrapper.usingMapper())
}

/**
 * Equivalent for findOne - but map the key difference being that this generally returns a list of results of type T
 */
fun <T> findAll(jdbcTemplate: NamedParameterJdbcTemplate = JdbcProvider.template, init: JdbcDslWrapper<T>.() -> Any): List<T> {
    val wrapper = JdbcDslWrapper<T>()
    wrapper.init()
    return Collections.unmodifiableList(jdbcTemplate.query<T>(wrapper.usingStatement(), wrapper.params(), wrapper.usingMapper()))
}

/**
 * Function useful when doing inserts. Automatically employs a keyholder to return the generated key for the inserted record
 */
fun insert(jdbcTemplate: NamedParameterJdbcTemplate = JdbcProvider.template, init: JdbcDslWrapper<*>.() -> Any): Int {
    val wrapper = JdbcDslWrapper<Any>()
    wrapper.init()
    val keyHolder = GeneratedKeyHolder()
    jdbcTemplate.update(wrapper.usingStatement(), wrapper.params(), keyHolder)
    return keyHolder.key as Int
}

/**
 * Update function, useful for update statements (also facilitates delete) - will throw an exception
 * when no rows are updated.
 */
fun update(jdbcTemplate: NamedParameterJdbcTemplate = JdbcProvider.template, init: JdbcDslWrapper<*>.() -> Any) {
    val wrapper = JdbcDslWrapper<Any>()
    wrapper.init()
    if (jdbcTemplate.update(wrapper.usingStatement(), wrapper.params()) == 0) {
        throw EmptyResultDataAccessException(1)
    }
}

/**
 * Same as update but using a more descriptive name to show the operation type on the call-site
 */
fun delete(jdbcTemplate: NamedParameterJdbcTemplate = JdbcProvider.template, init: JdbcDslWrapper<*>.() -> Any) {
    update(jdbcTemplate, init)
}

fun <T> MutableList<T>.map(t: T) {
    this.add(t)
}

fun MutableList<Pair<String, Any>>.toSqlParams(): MapSqlParameterSource {
    val map = MapSqlParameterSource()
    this.forEach { map.addValue(it.first, it.second) }
    return map
}

/**
 * Builder type structure, to allow DSL-like control over database operations, contains body
 * functions to control where which types are allowed to appear.
 */
class JdbcDslWrapper<T> {

    private var params = MapSqlParameterSource()
    private lateinit var statement: String
    private lateinit var mapper: RowMapper<T>

    fun usingStatement() = statement
    fun params() = params
    fun usingMapper() = mapper

    fun usingStatement(init: JdbcDslWrapper<T>.() -> String) = apply { statement = init() }
    fun usingMapper(init: JdbcDslWrapper<T>.() -> RowMapper<T>) = apply { mapper = init() }
    fun usingParameters(init: MutableList<Pair<String, Any>>.() -> Unit) {
        val list: MutableList<Pair<String, Any>> = mutableListOf()
        list.init()
        params = list.toSqlParams()
    }
}