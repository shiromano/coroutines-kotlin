package exception

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import util.log

suspend fun main() {
    try {
        coroutineScope {
            launch {
                delay(100)
                throw Error("self defined error")
            }

            launch {
                delay(200)
                log("won't print")
            }

            launch {
                delay(50)
                log("will be printed")
            }
        }
    } catch (e: Error) {
        log("will catch error: ${e.message}")
    }
}