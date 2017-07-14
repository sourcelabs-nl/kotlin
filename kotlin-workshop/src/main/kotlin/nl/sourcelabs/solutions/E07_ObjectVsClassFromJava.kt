package nl.sourcelabs.solutions

/**
 * Define an object called HelloworldO.
 *
 * Write a member function sayHello(name) that prints a hello name
 *
 * Invoke the function static from Java
 */
object HelloworldOE07 {
    @JvmStatic // allows for static invocation from Java
    @JvmOverloads // generates function for Java with the default value provided
    fun sayHello(name: String = "world") {
        println("Hello: $name from $this")
    }
}

/**
 * Define a class called HelloworldC.
 *
 * Write a member function sayHello(name) that prints a hello name
 */
class HelloworldCE07 {
    @JvmOverloads // generates function for Java with the default value provided
    fun sayHello(name: String = "world") {
        println("Hello $name for $this")
    }
}
