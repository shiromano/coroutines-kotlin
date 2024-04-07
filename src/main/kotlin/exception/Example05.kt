package exception

import kotlinx.coroutines.*
import util.log

suspend fun main(): Unit = coroutineScope {

    val job = SupervisorJob()

    launch(job) {
        delay(100)
        throw Error("ERROR ONE")
    }

    launch(job) {
        delay(200)
        log("will be printed")
    }

//    delay(300) // need to delay to get result printed, we break the structured concurrency here as launch is not directly from the enclosing coroutineScope
    job.children.forEach {  it.join() } // alternatively we can use job.join()
}
