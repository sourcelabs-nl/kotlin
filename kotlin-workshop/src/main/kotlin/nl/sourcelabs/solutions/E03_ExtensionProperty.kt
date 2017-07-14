package nl.sourcelabs.solutions

import java.math.BigDecimal

/**
 * Write an extension property that easily converts an Int to a BigDecimal
 */

val Int.bigdecimal 
    get() = BigDecimal(this)

fun main(args: Array<String>) {
    val converted = 5.bigdecimal

    println(converted::class)
}