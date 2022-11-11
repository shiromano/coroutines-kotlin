import java.util.concurrent.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private val executor = Executors.newSingleThreadScheduledExecutor {
    Thread(it, "custom-scheduler").apply { isDaemon = true }
}

suspend fun delay(timeMillis: Long): Unit = suspendCoroutine { cont ->
    executor.schedule({
        println("delaying suspended ${Thread.currentThread()}")
        cont.resume(Unit)
    }, timeMillis, TimeUnit.MILLISECONDS)
}
suspend fun main(args: Array<String>) {
    println("Hello World! ${Thread.currentThread()}")
    delay(1000)
    println("after")
}