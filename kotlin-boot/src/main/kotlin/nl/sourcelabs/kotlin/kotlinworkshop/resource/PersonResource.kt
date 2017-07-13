package nl.sourcelabs.kotlin.kotlinworkshop.resource

import nl.sourcelabs.kotlin.kotlinworkshop.domain.Person
import nl.sourcelabs.kotlin.kotlinworkshop.repository.PersonRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController("/api/persons")
class PersonResource (private val personRepository: PersonRepository) {
    
    @GetMapping
    fun findAll(): List<Person> {
        return listOf(find(1))
    }
    
    @GetMapping("/{id}")
    fun find(@PathVariable id: Int): Person {
        return personRepository.findPerson(id)   
    }
}