package job

import kotlinx.coroutines.*
import util.log

/**
 * coroutineScope will exit only when all it's children coroutines are finished
 */
suspend fun main() {
    coroutineScope {

        launch {
            log("delaying")
            delay(1000)
        }

    }
    // after 1s
    log("coroutineScope exits")
}