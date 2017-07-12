package nl.sourcelabs.coroutines

import kotlinx.coroutines.experimental.*

suspend fun slowFunction() {
    delay(500)
    print(" ...this is slow?")
}

fun sequentialExample() {
    launch(CommonPool) {
        slowFunction()
        slowFunction()
    }
    print("This was fast!")
}

fun asyncExample() {
    async(CommonPool) { slowFunction() }
    async(CommonPool) { slowFunction() }
    print("This was fast!")
}

fun main(args: Array<String>) = runBlocking {
    sequentialExample()
    //asyncExample()
    delay(750L)

}