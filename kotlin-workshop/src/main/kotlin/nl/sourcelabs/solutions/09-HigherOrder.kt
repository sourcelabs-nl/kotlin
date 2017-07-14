package nl.sourcelabs.solutions

/**
 * Modify the modulo function, so that returns a function that filters a list of integers based on a configurable modulo value.
 *
 * The function takes an int as a parameter defining the operand.
 * The returned function takes an Int parameter and returns a boolean (signature of a filter). Inside the
 * function return true if: 'input mod divisor equals zero'.
 */
fun modulo(divisor: Int): (Int) -> Boolean = {
    it % divisor == 0
}

fun main(args: Array<String>) {
    println((1..25).filter(modulo(5))) // Should print [5, 10, 15, 20, 25]
}