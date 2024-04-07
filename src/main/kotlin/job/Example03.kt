package job

import kotlinx.coroutines.*
import util.log

/**
 * coroutineScope will exit only when all it's children coroutines are finished,
 * But this no longer holds in caes we use a custom job as parent job for spawned children jobs
 * this is because the `Structured Concurrency` structure is damaged by our custom job.
 *
 *
 */
suspend fun main() {
    coroutineScope {
        val parent = coroutineContext.job
        val custom = Job()

        launch(custom) {
            log(coroutineContext.job == custom) // false
            log(coroutineContext.job == custom.children.first()) // true
            delay(1000)
        }
    }
    // we delay a little so that we can get the whole output from child coroutine
    delay(500)
}