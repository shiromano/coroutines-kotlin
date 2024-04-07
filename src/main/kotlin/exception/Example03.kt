package exception


import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import util.log

suspend fun main(): Unit = coroutineScope {
    launch {
        try {
            launch {
                delay(200)
                throw Error("self defined error")
            }
        } catch (e: Error) {
            log("no error will be caught")
        }
    }
}