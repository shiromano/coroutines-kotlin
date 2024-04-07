package flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import util.log

fun makeFlow() = flow {
    log("starting flow...")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}

suspend fun main() = coroutineScope {
    val flow = makeFlow()

    delay(1000)
    log("consuming from flow...")
    flow.collect {
        log(it)
    }

    log("consuming again...") // unlike channel, Flow is cold, we can re-consume it
    flow.collect {
        log(it)
    }
}