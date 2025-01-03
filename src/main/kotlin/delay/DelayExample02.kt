package delay

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import util.log

suspend fun main() {
    // confined dispatcher
    coroutineScope {
        launch(Dispatchers.Default) {
            log(" << defaultDispatcher-worker-* expected")
            delay(100)
            // --> from here the code is wrapped in Continuation and pushed to the queue of DefaultExecutor
            log(" << defaultDispatcher-worker-* expected")
            //
        }
    }
    // https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html#unconfined-vs-confined-dispatcher
}