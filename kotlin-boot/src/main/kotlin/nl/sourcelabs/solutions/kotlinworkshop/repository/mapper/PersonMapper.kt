package nl.sourcelabs.solutions.kotlinworkshop.repository.mapper

import nl.sourcelabs.solutions.kotlinworkshop.domain.Person
import nl.sourcelabs.solutions.kotlinworkshop.util.toLocalDate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

/**
 * Singleton mapper implementation for Person entities coming from the database.
 */
object PersonMapper : RowMapper<Person> {
    override fun mapRow(resultSet: ResultSet, rowNumber: Int): Person {
        return Person(
                id = resultSet.getInt("id"),
                firstName = resultSet.getString("firstname"),
                lastName = resultSet.getString("lastname"),
                birthDate = resultSet.getLong("birthdate").toLocalDate(),
                email = resultSet.getString("email")
        )
    }
}