package nl.sourcelabs.kotlin.kotlinworkshop.domain

import java.time.LocalDate

data class Person(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val birthDate: LocalDate,
        val email: String
)