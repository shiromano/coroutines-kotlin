package exception

import kotlinx.coroutines.*
import util.log

suspend fun main(): Unit = supervisorScope {
    launch {
        delay(100)
        throw Error("ERROR ONE")
    }

    launch {
        delay(200)
        log("will be printed")
    }
}
