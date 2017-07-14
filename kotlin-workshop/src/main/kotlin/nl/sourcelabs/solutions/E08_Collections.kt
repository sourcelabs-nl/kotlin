package nl.sourcelabs.solutions

fun collections() {
    // initialize an immutable list containing String with values "kotlin", "is", "cool"
    val listOf = listOf("kotlin", "is", "cool")
    // print the first and last item in the list
    print(listOf.first())
    print(listOf.last())

    // initialize an mutable list containing String with values "kotlin", "is", "cool"
    mutableListOf("kotlin", "is", "cool")

    // initialize a immutable map with the following key/values 1="a", 2="b", 3="c"
    mapOf(1 to "a", 2 to "b", 3 to "c")

    // initialize a immutable map with the following key/values 1="a", 2="b", 3="c"
    mutableMapOf(1 to "a", 2 to "b", 3 to "c")

}