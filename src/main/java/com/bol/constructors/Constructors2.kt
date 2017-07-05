package com.bol.constructors

import java.time.LocalDate
import java.time.Period

/**
 * Example showing an init block to initialize derived values from the constructor. Here it uses the
 * supplied dateOfBirth to calculate the age.
 *
 * Please note that this could also have been written as:
 *
 * val age: Int = Period.between(dateOfBirth, LocalDate.now()).years
 *
 * without supplying the init block.
 *
 */
class Person(val name: String, val dateOfBirth: LocalDate) {

    val age: Int // = Period.between(dateOfBirth, LocalDate.now()).years

    init {
        val period = Period.between(dateOfBirth, LocalDate.now())
        age = period.years
    }
}

/**
 * The init block is executed when constructing the object, so the age now is properly initialzed
 */
fun main(args: Array<String>) {
    val person = Person("Jay", LocalDate.of(1980,6,6))
    println(person.age)
}