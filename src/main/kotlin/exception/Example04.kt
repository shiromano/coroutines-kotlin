package exception

import kotlinx.coroutines.*
import util.log

suspend fun main(): Unit = coroutineScope {

    val scope = CoroutineScope(SupervisorJob())

    scope.launch {
        delay(100)
        throw Error("ERROR ONE")
    }

    scope.launch {
        delay(200)
        log("will be printed")
    }

    delay(300) // need to delay to get result printed, we break the structured concurrency here as launch is not directly from the enclosing coroutineScope
}
