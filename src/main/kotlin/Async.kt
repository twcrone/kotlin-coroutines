import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val firstDeferred = async { getFirstValue() }
        val secondDeferred = async { get2ndValue() }

        println("Doing some processing")
        delay(500)
        println("Waiting for the values")

        val firstVal = firstDeferred.await()
        val secondVal = secondDeferred.await()
        val total = firstVal + secondVal

        println("The total is $total")
    }
}

suspend fun getFirstValue(): Int {
    delay(1000)
    val value = Random(100).nextInt()
    println("Returning first value $value")
    return value
}

suspend fun get2ndValue(): Int {
    delay(2000)
    val value = Random(100).nextInt()
    println("Returning second value $value")
    return value
}