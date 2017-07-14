package nl.sourcelabs.solutions.kotlinworkshop.repository

import nl.sourcelabs.solutions.kotlinworkshop.domain.Person
import nl.sourcelabs.solutions.kotlinworkshop.util.params
import nl.sourcelabs.solutions.kotlinworkshop.util.toLocalDate
import nl.sourcelabs.solutions.kotlinworkshop.util.toMillis
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import javax.sql.DataSource

val mapper = { rs: ResultSet, _: Int ->
    Person(
            id = rs.getInt("id"),
            firstName = rs.getString("firstname"),
            lastName = rs.getString("lastname"),
            birthDate = rs.getLong("birthdate").toLocalDate(),
            email = rs.getString("email")
    )
}

@Repository
class PersonRepository(dataSource: DataSource) {

    private val jdbcTemplate = NamedParameterJdbcTemplate(dataSource)

    fun findPerson(id: Int): Person {
        return jdbcTemplate.queryForObject("select * from person where id=:id", params { it.addValue("id", id) }, mapper)
    }

    fun findPersons(): List<Person> {
        return jdbcTemplate.query("select * from person", mapper)
    }

    fun delete(id: Int) {
        if (jdbcTemplate.update("delete from person where id=:id", params { it.addValue("id", id) }) == 0) {
            throw EmptyResultDataAccessException(1)
        }
    }

    fun save(person: Person): Person {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update("insert into person (firstname, lastname, birthdate, email) values (:firstname, :lastname, :birthdate, :email)", params { 
            it.addValue("firstname", person.firstName)
            it.addValue("lastname", person.lastName)
            it.addValue("birthdate", person.birthDate.toMillis())
            it.addValue("email", person.email)
        }, keyHolder)
        
        if(keyHolder.key != null) {
            return findPerson(keyHolder.key as Int)
        }
        throw RuntimeException("Can't create person")
    }
}