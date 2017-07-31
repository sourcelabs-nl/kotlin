package nl.sourcelabs.solutions.kotlinworkshop.repository

import nl.sourcelabs.solutions.kotlinworkshop.domain.Person
import nl.sourcelabs.solutions.kotlinworkshop.repository.mapper.PersonMapper
import nl.sourcelabs.solutions.kotlinworkshop.util.*
import org.springframework.stereotype.Repository

@Repository
class PersonRepository {

    fun findPersonById(id: Int) = findOne <Person> {
        usingStatement { "SELECT * FROM person WHERE id=:id" }
        usingParameters { map("id" to id) }
        usingMapper { PersonMapper }
    }

    fun findPersons() = findAll <Person> {
        usingStatement { "SELECT * FROM person" }
        usingMapper { PersonMapper }
    }

    fun deletePerson(id: Int) = delete {
        usingStatement { "DELETE FROM person WHERE id=:id" }
        usingParameters { map("id" to id) }
    }

    fun insertPerson(person: Person) = insert {
        usingStatement {
            "INSERT INTO person (firstname, lastname, birthdate, email) " +
                    "VALUES (:firstname, :lastname, :birthdate, :email)"
        }
        usingParameters {
            map("firstname" to person.firstName)
            map("lastname" to person.lastName)
            map("birthdate" to person.birthDate.toMillis())
            map("email" to person.email)
        }
    }
    
    fun updatePerson(id: Int, person: Person) = update {
        usingStatement { 
            "UPDATE person SET firstname=:firstname, lastname=:lastname, birthdate=:birthdate, email=:email " +
                    "WHERE id=:id" 
        }
        usingParameters {
            map("id" to id)
            map("firstname" to person.firstName)
            map("lastname" to person.lastName)
            map("birthdate" to person.birthDate.toMillis())
            map("email" to person.email)
        }
    }
}