package nl.sourcelabs.exercises

enum class IsKotlinCool {
    YES, NO, UNKNOWN
}

class MakeUpYourMindException : RuntimeException()

fun isKotlinCool(value: IsKotlinCool) : Boolean {
    if(value == IsKotlinCool.YES) {
        return true
    } else if(value == IsKotlinCool.NO) {
        return false
    } else {
        throw MakeUpYourMindException()
    }
    // TODO convert this if/else-if/else to when
}

fun main(args: Array<String>) {
    print(isKotlinCool(IsKotlinCool.YES)) // prints true
}