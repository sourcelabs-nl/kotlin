package nl.sourcelabs.exercises

/**
 * Given the phone class below, create a minimal instance of this class leveraging the named parameters
 */

data class Phone(
        val manufacturer: String,
        val type: String,
        var stock: Int = 0,
        var supplier: String = ""
)

fun main(args: Array<String>) {
    
}