package flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        val flow = MutableSharedFlow<Int>(replay = 0) // replay will replay previous elements in the flow before an listener joins
        launch {
            (1..10).map {
                delay(10)
                flow.emit(it)
            }
        }

        val job2 = launch {
            delay(15)
            flow.collect { // each time collect is called, it registers a new listener
                println("first subscriber: $it")
            }
        }

        val job3 = launch {
            delay(25)
            flow.collect {
                println("second subscriber: $it")
            }
        }

        delay(1000)
        job2.cancel()
        job3.cancel()

    }
}