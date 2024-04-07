package job
import kotlinx.coroutines.*
import util.log

/**
 * a launched job is a child of the job passed to launch()
 */
suspend fun main() {
    coroutineScope {
        val parent = coroutineContext.job
        val custom = Job()

        val launched = launch(custom) {
            delay(1000)
        }

        log(launched == custom.children.first())
    }
    // we delay a little so that we can get the whole output from child coroutine
    delay(500)
}