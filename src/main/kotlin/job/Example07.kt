package job

import kotlinx.coroutines.*
import util.log

suspend fun main() = coroutineScope {
    val job = launch {
        repeat(1_000) {
            delay(200)
            log(it)
        }
    }

    delay(1100)
    job.cancelAndJoin()
    log("cancelled successfully")
}