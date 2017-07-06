package nl.sourcelabs.dataclasses

/**
 * Kotlin equivalent for the Java class in the same package
 */
data class Person(
        val firstname: String,
        val lastname: String,
        var email: String = "",
        val age: Int
)

fun main(args: Array<String>) {
    val person = Person("Some", "Guy", "someguy@someplace.com", 21)
    val copy = person.copy()
    if (person == copy && person !== copy) {
        println("Equal but not the same instance")
    }
    println(person.toString())
}