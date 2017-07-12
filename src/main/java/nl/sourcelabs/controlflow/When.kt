package nl.sourcelabs.controlflow

object When {

    fun yesNoTrueFalseJavaStyle(value: String) {
        if ("YES".equals(value)) {
            print("true")
        } else if ("NO".equals(value)) {
            print("false")
        } else {
            print("unknown")
        }
    }

    fun yesNoTrueFalseKotlinStyle(value: String) {
        when (value) {
            "YES" -> print("true")
            "NO" -> print("false")
            else -> print("unknown")
        }
    }
}
