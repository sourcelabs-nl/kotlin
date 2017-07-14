package nl.sourcelabs.solutions

/**
 * Given the three classes below and the main method, retrieve the value from type
 * 'C' or return "Unknown" if you can't determine the value.
 */

class A(val b: B?)

class B(val c: C?)

class C(val value: String)

fun extractCValue(a: A): String {
    return a.b?.c?.value ?: "unknown" // Good, provide default and nullchecks
}

fun extractCValueNaive(a: A): String {
    return a.b!!.c!!.value // Naive, this will throw nullpointers. Can be used if you are absolutely no nulls can occur
}

fun main(args: Array<String>) {
    val ok = A(B(C("Value")))
    val nok = (A(B(null)))

    extractCValue(ok)
    extractCValue(nok)
}