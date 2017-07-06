package com.bol.higherorder

import java.io.File
import java.io.FileInputStream

/**
 * Function taking a function as a parameter
 */
fun doBestEffort(function: () -> Unit) {
    try {
        function()
        print("Success")
    } catch (exception: Exception) {
        println(exception.message)
    }
}

/**
 * Function returning a function
 */
fun writeStuff(): (String) -> Unit = {
    println(it)
}

/**
 * Function that returns a function that tries to open a file
 */
fun openFile(file: String): () -> Unit = {
    FileInputStream(File(file))
}

/**
 * Higher order function for calculating modulo
 */
fun modulo(input: Int): (Int) -> Boolean = {
    it % input == 0
}

fun main(args: Array<String>) {
    // Call function passing a lambda
    doBestEffort {
        val openFile = openFile("saddasdasdasdasdasdasdasdasdasdasd") // Function reference
        openFile() // invoke it
        openFile.invoke() // Also possible
    }

    // Call function passing a function reference
    doBestEffort((::openFile)("asdsdasdasdasdasdadasdadasdas")) // function reference

    // or pass it after declaring it
    val openFile = openFile("saddasdasdasdasdasdasdasdasdasdasd")
    doBestEffort(openFile)

    // Invoke a function that is returned by a function
    writeStuff().invoke("WithThis") // Writestuff returns a function, invoke it using 'invoke'

    // Filter a list of ints between 0 and 25 and filter those items where modulo 5 == 0
    val values = (0..25).filter (modulo(5))
    println(values) // 0, 5, 10, 15, 20, 25

    // This is the exact equivalent but less reusable
    val valuesToo = (0..25).filter { it % 5 == 0 }
    println(valuesToo)
}