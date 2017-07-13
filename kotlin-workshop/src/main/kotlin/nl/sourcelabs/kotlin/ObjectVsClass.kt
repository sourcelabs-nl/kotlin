package nl.sourcelabs.kotlin

/**
 * Define an object called HelloworldO.
 *
 * Write a member function sayHello(name) that prints a hello name
 *
 * Invoke the function static from Java
 */
object HelloworldO {
    //@JvmStatic
    fun sayHello(name: String) {
        println("Hello: $name from $this")
    }
}

/**
 * Define a class called HelloworldC.
 *
 * Write a member function sayHello(name) that prints a hello name
 */
open class HelloworldC {
    fun sayHello(name: String) {
        println("Hello $name for $this")
    }

    //@JvmOverloads
    fun calculateTheMeaningOfLife(int: Int = 42) = println(int)
}

fun main(args: Array<String>) {
    HelloworldO.sayHello("Stephan")
    HelloworldO.sayHello("Stephan")

    HelloworldC().sayHello("Stephan")
    HelloworldC().sayHello("Stephan")

    HelloworldC().calculateTheMeaningOfLife()
    HelloworldC().calculateTheMeaningOfLife(21)
}