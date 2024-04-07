package channel


import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import util.log

suspend fun main(): Unit = coroutineScope {
    val channel = produce {
         repeat(10) {
            log("sending $it")
            send(it)
        }
    }


    launch {
        for (elem in channel) {
            log("received: $elem")
        }
    }
}