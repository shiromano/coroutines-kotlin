package job

import kotlinx.coroutines.*
import util.log

/**
 *
 */
suspend fun main() {
    coroutineScope {
        val parent = coroutineContext.job

        launch {
            log(coroutineContext.job == parent) // false
            log(coroutineContext.job == parent.children.first()) // true
            delay(1000)
        }
    }
    // we delay a little so that we can get the whole output from child coroutine
    delay(500)
}