import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Coroutines are very lightweight so start lots of them is no problem
// Starting lots of threads IS a problem
fun main() {
    runBlocking {
        repeat(1_000_000) {
            launch {
                print(".")
            }
        }
    }
}