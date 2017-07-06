package nl.sourcelabs.functions

import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * Top-level function, no class required
 */
fun toTimeString(time: LocalTime = LocalTime.now()): String {
    return DateTimeFormatter.ofPattern("hh:mm:ss").format(time)
}

/**
 * Extension function, extending LocalTime with an additional method
 */
fun LocalTime.asString(): String {
    return DateTimeFormatter.ofPattern("hh:mm:ss").format(this)
}

/**
 * All functions can be written as expressions too, allowing you to omit the return type and return keyword.
 */
fun LocalTime.asStringExpression() = DateTimeFormatter.ofPattern("hh:mm:ss").format(this)

fun main(args: Array<String>) {
    // Use a top-level (utility) function
    println(toTimeString(LocalTime.of(10, 0, 0)))

    // Use a top-level (utility) function and utilize the default value
    println(toTimeString())

    // Call the function with named parameters
    println(toTimeString(time = LocalTime.now()))

    // Call the extension function directly on the type that was extended
    println(LocalTime.now().asString())

    // The extension function is expression format can be called similarly and will yield the same result
    println(LocalTime.now().asStringExpression())
}