package nl.sourcelabs.solutions

/**
 * Define an object called HelloworldO.
 *
 * Write a member function sayHello(name) that prints a hello name
 *
 * Invoke the function static from Java
 */
object HelloworldO {
    fun sayHello(name: String = "world") {
        println("Hello: $name from $this")
    }
}

/**
 * Define a class called HelloworldC.
 *
 * Write a member function sayHello(name) that prints a hello name
 */
class HelloworldC {
    fun sayHello(name: String = "world") {
        println("Hello $name for $this")
    }
}

/**
 * Invoke HelloworldO sayHello
 * Invoke HelloworldO sayHello("yourname")
 *
 * Invoke HelloworldC sayHello
 * Invoke HelloworldC sayHello("yourname")
 */
fun main(args: Array<String>) {
    HelloworldO.sayHello()
    HelloworldO.sayHello("Stephan")

    HelloworldC().sayHello()
    HelloworldC().sayHello("Stephan")
}