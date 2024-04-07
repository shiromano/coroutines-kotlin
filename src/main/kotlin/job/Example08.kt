package job

import kotlinx.coroutines.*
import util.log

suspend fun main() = coroutineScope {
    val job = launch {
        try {
            repeat(1_000) {
                delay(200)
                log(it)
            }
        } catch (e: CancellationException) {
            log(e) // kotlinx.coroutines.JobCancellationException: StandaloneCoroutine was cancelled;
            throw e
        }
    }

    delay(1100)
    job.cancelAndJoin()
    log("cancelled successfully")
}