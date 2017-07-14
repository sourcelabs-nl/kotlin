package nl.sourcelabs.solutions.kotlinworkshop.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

/**
 * Create a localdate from a given long value, if we can't, use a default value.
 */
fun Long.toLocalDate() = Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault()).toLocalDate()!!

/**
 * Get the long representation for a localdate instance - if it is null (it is coming from the database, so who knows)
 * use a default value.
 */
fun LocalDate.toMillis() = this.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()