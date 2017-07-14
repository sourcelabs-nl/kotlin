package nl.sourcelabs.solutions.kotlinworkshop.domain

import java.time.LocalDate

data class Person(
    var id: Int,
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDate,
    val email: String
)