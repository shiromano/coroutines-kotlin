package flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import util.log

suspend fun CoroutineScope.makeChannel() = produce {
    log("started producing")
    for (i in 1..3) {
        delay(1000)
        send(i)
    }
}

suspend fun main() = coroutineScope {
    val channel = makeChannel()

    log("consuming from channel")
    for (elem in channel) {
        log(elem)
    }

    log("consuming again") // no consumption
    for (elem in channel) {
        log(elem)
    }
}