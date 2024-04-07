package exception

import kotlinx.coroutines.*
import util.log

class CustomCancellationException(override val message: String): CancellationException(message)
suspend fun main(): Unit = coroutineScope {

    launch {
        delay(1000)
        throw CustomCancellationException("ERROR ONE")
    }

    launch {
        delay(2000)
        log("will be printed")
    }

}
