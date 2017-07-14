package nl.sourcelabs.kotlin.kotlinworkshop.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

/**
 * Create a localdate from a given long value, if we can't, use a default value.
 */
fun Long?.toLocalDate() {
    if(this != null) {
        Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault()).toLocalDate()
    }
    0L
}

/**
 * Get the long representation for a localdate instance - if it is null (it is coming from the database, so who knows)
 * use a default value.
 */
fun LocalDate?.toMillis() {
    if(this != null) {
        this.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }
    LocalDate.ofEpochDay(0)
}