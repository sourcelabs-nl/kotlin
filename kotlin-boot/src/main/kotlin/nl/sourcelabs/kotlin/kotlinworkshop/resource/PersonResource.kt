package nl.sourcelabs.kotlin.kotlinworkshop.resource

import nl.sourcelabs.kotlin.kotlinworkshop.domain.Person
import nl.sourcelabs.kotlin.kotlinworkshop.repository.PersonRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/persons")
class PersonResource(private val personRepository: PersonRepository) {

    @GetMapping
    fun findAll(): List<Person> {
        return personRepository.findPersons()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int): Person {
        return personRepository.findPerson(id)
    }
    
    @PostMapping
    fun create(@RequestBody person: Person): Person {
        return personRepository.save(person)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        personRepository.delete(id)
    }
}