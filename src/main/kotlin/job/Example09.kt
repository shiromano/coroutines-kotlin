package job

import kotlinx.coroutines.*
import util.log

suspend fun main() = coroutineScope {
    log("starting")
    val job = launch {
        launch {
            try {
                delay(1000)
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> {
                        log("job is cancelled")
                        throw e
                    }
                    else ->
                        log("error")
                }
            }
        }
    }
    delay(200)
    log(job)
    delay(200)
    job.cancelAndJoin()
    log("ended")
}