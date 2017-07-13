package nl.sourcelabs.kotlin.kotlinworkshop.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

fun Long.toLocalDate() = Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault()).toLocalDate()!!

fun LocalDate.toMillis() = this.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()