package nl.sourcelabs.solutions

enum class Choice {
    YES, NO, UNKNOWN
}

class MakeUpYourMindException : RuntimeException()

fun isKotlinCool(value: Choice) = when (value) {
    Choice.YES -> true
    Choice.NO -> false
    else -> throw MakeUpYourMindException()
}

fun main(args: Array<String>) {
    print(isKotlinCool(Choice.YES))
}