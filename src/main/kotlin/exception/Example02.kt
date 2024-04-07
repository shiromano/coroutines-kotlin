package exception

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import util.log

suspend fun main(): Unit = coroutineScope {
    launch {
        launch {
            launch {
                delay(200)
                throw Error("self defined error")
            }

            launch {
                delay(300)
                log("won't print")
            }
        }

        launch {
            delay(300)
            log("won't print")
        }

        launch {
            delay(100)
            log("will be printed")
        }
    }

    launch {
        delay(300)
        log("won't print")
    }

    launch {
        launch {
            delay(300)
            log("wont print")
        }
    }
}