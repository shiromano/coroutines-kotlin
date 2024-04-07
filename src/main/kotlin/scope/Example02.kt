package scope

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import util.log

suspend fun main(): Unit = runBlocking(CoroutineName("self-defined-coroutine")) {
    log("starting")

    val a = coroutineScope {
        delay(1000)
        log(coroutineContext[CoroutineName]) // 1s after starting
        1
    }

    val b = coroutineScope {
        delay(2000)
        log(coroutineContext[CoroutineName]) // 3s after staring
        2
    }

    log(a) // 3s after starting
    log(b) // 3s after starting
}