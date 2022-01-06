import kotlinx.coroutines.*

fun main() {
    runBlocking {
//        launch(Dispatchers.Main) {
//            println("Main Dispatcher. Thread ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined Dispatcher. Thread ${Thread.currentThread().name}")
            delay(100)
            println("Unconfined Dispatcher. Thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default Dispatcher. Thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO Dispatcher. Thread ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("Mine")) {
            println("newSingleThreadContext() Dispatcher. Thread ${Thread.currentThread().name}")
        }

    }
}