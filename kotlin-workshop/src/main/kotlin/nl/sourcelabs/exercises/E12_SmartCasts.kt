package nl.sourcelabs.exercises

/**
 * Implement the function below, using the when statement.
 *
 * In case of the go to work event, return "Going to work because " and concatenate the 'why' property;
 * In case of the go home event, return "Going home to " and concatenate the 'where' property
 * In case of an unknown event, return "Unknown event"
 */

open class Event

class GoToWorkEvent(val why: String) : Event()

class GoHomeEvent(val where: String) : Event()

class DriveAroundAimlessley : Event()

// Implement
fun logEvent(event: Event): String {
    return ""
}

fun main(args: Array<String>) {
    println(logEvent(GoToWorkEvent("I need money to live")))
    println(logEvent(GoHomeEvent("Utrecht")))
    println(logEvent(DriveAroundAimlessley()))
}