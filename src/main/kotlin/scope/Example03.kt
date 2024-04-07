package scope
import kotlinx.coroutines.*
import util.log

data class Coin(val name: String, val price: Int)

suspend fun getAssets(): List<String> {
    delay(1000)
    throw Error("network timeout")
//    return listOf("bitcoin", "eth")
}

suspend fun getPrices(): List<Int> {
    delay(2000)
    return listOf(1, 2)
}

suspend fun getUsers(): List<String> {
    delay(3000)
    return listOf("Alex", "Brad")
}
suspend fun getCoins(): List<Coin> = coroutineScope {
    val assets = async { getAssets() }
    val prices = async { getPrices() }

    assets.await().zip(prices.await()).map { Coin(it.first, it.second) }
}

suspend fun main() = coroutineScope {
    val coins = try {
        getCoins()
    } catch (e: Error) {
        log("error: ${e.message}")
        emptyList()
    }
    log("coins: $coins")
    val users = async { getUsers() }
    log(users.await())
}
