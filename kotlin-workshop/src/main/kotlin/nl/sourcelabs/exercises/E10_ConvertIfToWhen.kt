package nl.sourcelabs.exercises

enum class Choice {
    YES, NO, UNKNOWN
}

class MakeUpYourMindException : RuntimeException()

fun isKotlinCool(value: Choice) : Boolean {
    if(value == Choice.YES) {
        return true
    } else if(value == Choice.NO) {
        return false
    } else {
        throw MakeUpYourMindException()
    }
    // TODO convert this if/else-if/else to when
}

fun main(args: Array<String>) {
    print(isKotlinCool(Choice.YES)) // prints true
}