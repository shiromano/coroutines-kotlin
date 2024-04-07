import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    try {
        suspendCoroutine<Unit> { cont ->
            cont.resumeWithException(RuntimeException("HOLA"))
        }
    } catch (e: Exception) {
        println("caught ${e.message}")
    }
}