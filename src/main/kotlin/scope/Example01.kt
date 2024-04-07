package scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import util.log

suspend fun main(): Unit = coroutineScope {
    log("starting")

    val a = coroutineScope {
        delay(1000)
        1
    }

    val b = coroutineScope {
        delay(2000)
        2
    }

    log(a) // 3s after starting
    log(b) // 3s after starting
}