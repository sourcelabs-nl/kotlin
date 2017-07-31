package nl.sourcelabs.solutions.kotlinworkshop.resource

import nl.sourcelabs.solutions.kotlinworkshop.domain.Person
import nl.sourcelabs.solutions.kotlinworkshop.repository.PersonRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/persons")
class PersonResource(private val personRepository: PersonRepository) {

    @GetMapping
    fun findAll(): List<Person> = personRepository.findPersons()

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int) = personRepository.findPersonById(id)

    @PostMapping
    fun create(@RequestBody person: Person, uriBuilder: UriComponentsBuilder): ResponseEntity<Unit> {
        val id = personRepository.insertPerson(person)
        val uri = uriBuilder.path("/api/persons/{id}").buildAndExpand(id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody person: Person) = personRepository.updatePerson(id, person)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = personRepository.deletePerson(id)

}