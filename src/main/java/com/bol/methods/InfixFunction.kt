package com.bol.methods

import java.time.Duration
import java.time.LocalTime

/**
 * Example of an infix function, an extension function or a member function of a class taking exactly one
 * parameter, which can be called with infix notation on the call site.
 *
 * There's no Java equivalent for this.
 */
infix fun LocalTime.until(time: LocalTime): Duration {
    return Duration.between(this, time)
}

fun main(args: Array<String>) {
    // Regular notation as a method invocation
    LocalTime.of(10, 55, 0).until(LocalTime.of(12, 21, 0))

    // Infix notation
    val timeSpent = LocalTime.of(10, 55, 0) until LocalTime.of(12, 21, 0)
    //                                      ^^^^^

    println("We've spent ${timeSpent.toMinutes()} minutes waiting for the bus.")
}
