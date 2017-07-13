package nl.sourcelabs.kotlin.kotlinworkshop.domain

import java.time.LocalDate

data class Person(
    var id: Int,
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDate,
    val email: String
)