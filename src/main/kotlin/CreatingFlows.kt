import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val numbersFlow = sendNumbers()
        println("Flow hasn't started yet")
        println("Starting flow...")
        withTimeoutOrNull(1000) {
            numbersFlow.collect {
                println("Received $it")
            }
        }
    }
}

fun sendNumbers() = flow {
    listOf(1, 2, 3, 4).forEach {
        delay(400)
        emit(it)
    }
}