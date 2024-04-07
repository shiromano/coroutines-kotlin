package exception

import kotlinx.coroutines.*
import util.log

suspend fun main(): Unit = coroutineScope {

    val job = SupervisorJob()

    launch(job) {
        launch {
            delay(1000)
            throw Error("ERROR ONE")
        }

        launch {
            delay(2000)
            log("won't printed")
        }
    }

    delay(3000) // need to delay to get result printed, we break the structured concurrency here as launch is not directly from the enclosing coroutineScope
}
