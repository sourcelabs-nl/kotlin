package nl.sourcelabs.controlflow

object WhenTypeMatching {

    fun matchType(value: Any) {
        when (value) {
            is String -> print("String")
            is Int -> print("Int")
            else -> print("not supported")
        }
    }
}

fun main(args: Array<String>) {
    WhenTypeMatching.matchType(true) // not supported
    WhenTypeMatching.matchType(1) // Int
    WhenTypeMatching.matchType(1L) // not supported
}