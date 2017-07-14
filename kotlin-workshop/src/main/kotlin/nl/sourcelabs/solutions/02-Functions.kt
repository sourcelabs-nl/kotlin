package nl.sourcelabs.solutions

/**
 * Define a toplevel function "sum" that adds two integers together
 * So you can do sum(1, 1)
 */

fun sum(left: Int, right: Int): Int {
    return left + right
}

/**
 * Write the same function as an extension function on class Int,
 * so you can do 1.add(1)
 */

fun Int.add(what: Int): Int {
    return this + what
}

/**
 * Rewrite the function so you can call it as follows
 * 1 plus 1
 */
infix fun Int.plus(what: Int): Int {
    return this + what
}

/**
 * Write a main function to call the functions
 */

fun main(args: Array<String>) {
    val sum = sum(1,1)
    val add = 1.add(1)
    val plus = 1 plus 1

    println("Sum: $sum, Add: $add, Plus: $plus")
}