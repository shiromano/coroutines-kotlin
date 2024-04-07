package channel


import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import util.log

suspend fun main(): Unit = coroutineScope {
    val channel = Channel<Int>()

    launch {
        repeat(10) {
            delay(1000)
            channel.send(it)
        }
        channel.close()
    }

    launch {
        for (elem in channel) {
            log("received: $elem")
        }
    }
}