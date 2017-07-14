package nl.sourcelabs.solutions

/**
 * filter out all pizza's that do not have a name starting with 'p' or 'P', and return the
 * resulting pizza names, capitalized
 */
val pizzas = listOf("pepperoni", "margharita", "quattro stagioni", "tonno", "prosciutto")

fun main(args: Array<String>) {
    println(nl.sourcelabs.exercises.pizzas.filter { it.startsWith('p') }.map { it.capitalize() })
}