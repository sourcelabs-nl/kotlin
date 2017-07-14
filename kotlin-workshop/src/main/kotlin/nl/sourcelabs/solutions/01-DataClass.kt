package nl.sourcelabs.solutions

import java.time.LocalDate
import java.time.Period

/**
 * Assignment:
 *
 *  - Write a simple data class, for a Person.
 *      Properties: firstName (String), lastName (String), birthDate(LocalDate), emailAddress (String)
 *      All properties are immutable, except for email which can be modified.
 *
 * - Add a way to get the full name for the person, which is firstName and lastName together
 *
 * - Add a function to get the persons age at a given date
 *      -> ageAt(date)
 *
 * - Write a main function that creates a new person and prints the toString, hashcode, fullname and age on 2000/1/1 for the person
 *
 * - Also in the main function, create a copy of the original person with a different birthdate and print the tostring
 */

data class Person(
        val firstName: String,
        val lastName: String,
        val birthDate: LocalDate,
        var emailAddress: String) {

    val fullname = "$firstName $lastName"

    fun ageAt(date: LocalDate): Int {
        return Period.between(birthDate, date).years
    }
}

fun main(args: Array<String>) {
    val person = Person("Person", "One", LocalDate.of(1980, 6, 6), "my@email.com")

    println(person.toString())
    println(person.hashCode())
    println(person.fullname)
    println(person.ageAt(LocalDate.of(2000, 1, 1)))
    
    val copy = person.copy(birthDate = LocalDate.of(1980, 4, 4))
    println(person)
    println(copy)
}