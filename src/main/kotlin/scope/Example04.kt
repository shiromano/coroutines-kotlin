package scope
import kotlinx.coroutines.*
import util.log

/**
 * runBlocking is similar to coroutineScope,
 * the difference is that runBlocking is not a suspend function
 */
suspend fun main(): Unit {
    log("starting")
    runBlocking {
        launch {
            delay(1000)
            log("first child")
            throw Error("runtime error")
        }

        launch {
            delay(2000)
            log("second child wont print")
        }
    }

    log("finished won't print")
}