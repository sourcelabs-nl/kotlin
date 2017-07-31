package nl.sourcelabs.solutions.kotlinworkshop.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

/**
 * Create a localdate from a given long value.
 */
fun Long.toLocalDate() = Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault()).toLocalDate()!!

/**
 * Get the long representation for a localdate instance.
 */
fun LocalDate.toMillis() = this.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()