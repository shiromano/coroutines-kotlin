package delay

import kotlinx.coroutines.delay
import util.log

suspend fun main() {
    log(" << thread main expected")
    delay(100)
    // --> from here the code is wrapped in Continuation and pushed to the queue of DefaultExecutor
    log(" << default executor expected")
    // unconfined dispatcher
    // https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html#unconfined-vs-confined-dispatcher
}