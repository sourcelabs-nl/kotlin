package nl.sourcelabs.solutions

enum class IsKotlinCool {
    YES, NO, UNKNOWN
}

class MakeUpYourMindException : RuntimeException()

fun isKotlinCool(value: IsKotlinCool) = when (value) {
    IsKotlinCool.YES -> true
    IsKotlinCool.NO -> false
    else -> throw MakeUpYourMindException()
}

fun main(args: Array<String>) {
    print(isKotlinCool(IsKotlinCool.YES))
}