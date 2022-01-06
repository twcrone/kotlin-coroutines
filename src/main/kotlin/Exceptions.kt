import kotlinx.coroutines.*
import java.lang.RuntimeException

fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler { ctx, t ->
            println("Exception handled ${t.localizedMessage}")
        }
        val job = GlobalScope.launch(handler) {
            println("Throwing exception from job")
            throw RuntimeException("Hello")
        }
        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from deferred")
            throw RuntimeException("Hello async")
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            println("Catching exception ${e.localizedMessage}")
        }
    }
}