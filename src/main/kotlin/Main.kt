
import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2

fun main() {
    println(calcComission("Mastercard", 10000, 75000))
}

fun calcComission(typeCard: String = "Мир", transfer: Int, mounthlyTransfer: Int = 0 ): Any {

    if (transfer > 150_000 || transfer + mounthlyTransfer > 600_000) return ERROR_LIMIT

    return when(typeCard) {
        "Visa" -> max(35,(transfer * 0.0075).toInt())
        "Mastercard", "Maestro" ->
            if(mounthlyTransfer > 75_000) {
                ((transfer * 0.006) + 20).toInt()
            }  else if (transfer + mounthlyTransfer > 75_000) {
                (((transfer + mounthlyTransfer) - 75_000) * 0.006 + 20).toInt()
            } else {
                0
            }
        "Мир" -> 0
        else -> ERROR_TYPE
    }
}


