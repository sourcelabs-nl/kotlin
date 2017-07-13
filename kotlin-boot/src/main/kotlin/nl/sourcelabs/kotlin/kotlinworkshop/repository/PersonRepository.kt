package nl.sourcelabs.kotlin.kotlinworkshop.repository

import nl.sourcelabs.kotlin.kotlinworkshop.domain.Person
import nl.sourcelabs.kotlin.kotlinworkshop.util.toLocalDate
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import javax.sql.DataSource

@Repository
class PersonRepository(dataSource: DataSource) {

    private val jdbcTemplate = JdbcTemplate(dataSource)

    fun findPerson(id: Int): Person {
        return jdbcTemplate.query("SELECT * FROM Person", { rs, i ->
            Person( id = rs.getInt("id"), 
                    firstName = rs.getString("firstname"),
                    lastName = rs.getString("lastname"),
                    birthDate = rs.getLong("birthdate").toLocalDate(), 
                    email = "mail"
            )
        }).first()
    }
}