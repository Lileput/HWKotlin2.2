package ru.netology

import kotlin.math.tan

fun main() {
    println("Комиссия для Mastercard (первый перевод, сумма 100_000): ${calculateCommission("Mastercard", 0, 100_000)}")
    println("Комиссия для Mastercard (предыдущий перевод 70_000, сумма 10_000): ${calculateCommission("Mastercard", 70_000, 10_000)}")
    println("Комиссия для Mastercard (предыдущий перевод 75_000, сумма 10_000): ${calculateCommission("Mastercard", 75_000, 10_000)}")
    println("Комиссия для Mastercard (предыдущий перевод 100_000, сумма 10_000): ${calculateCommission("Mastercard", 100_000, 10_000)}")
    println("Комиссия для Visa (сумма 10_000): ${calculateCommission("Visa", 0, 10_000)}")
    println("Комиссия для Visa (сумма 1_000): ${calculateCommission("Visa", 0, 1_000)}")
    println("Комиссия для Мир (сумма 10_000): ${calculateCommission("Мир", 0, 10_000)}")
    println("Комиссия для Мир (сумма 10_000, месячный лимит 595_000): ${calculateCommission("Мир", 595_000, 10_000)}")
    println("Комиссия для Mastercard (предыдущий перевод 595_000, сумма 10_000): ${calculateCommission("Mastercard", 595_000, 10_000)}")
    println("Комиссия для Visa (предыдущий перевод 595_000, сумма 10_000): ${calculateCommission("Visa", 595_000, 10_000)}")
    println("Комиссия для Мир (предыдущий перевод 595_000, сумма 10_000): ${calculateCommission("Мир", 595_000, 10_000)}")
    println("Комиссия для Visa (превышен суточный лимит, сумма 200_000): ${calculateCommission("Visa", 0, 200_000)}")
    println("Комиссия для Mastercard (превышен месячный лимит, предыдущий перевод 550_000, сумма 100_000): ${calculateCommission("Mastercard", 550_000, 100_000)}")
    println("Комиссия для несуществующей карты (сумма 100_000): ${calculateCommission("NonExistentCard", 0, 100_000)}")
}


fun calculateCommission(
    cardType: String = "Мир",
    monthlyTransferAmount: Int = 0,
    transferAmount: Int
): Int {

    val dailyLimit = 150_000
    val monthlyLimit = 600_000

    if (transferAmount > dailyLimit) {
        println("Превышен суточный лимит!")
        return -1 // Обозначает ошибку
    }

    if (monthlyTransferAmount + transferAmount > monthlyLimit) {
        println("Превышен месячный лимит!")
        return -1 // Обозначает ошибку
    }


    return when (cardType) {
        "Mastercard", "Maestro" -> {
            val freeLimit = 75_000
            if (monthlyTransferAmount >= freeLimit) {
                ((transferAmount * 0.006).toInt() + 20)
            } else {
                val amountWithCommission = monthlyTransferAmount + transferAmount
                if (amountWithCommission <= freeLimit) {
                    0
                } else {
                    (((amountWithCommission - freeLimit) * 0.006).toInt() + 20)
                }

            }
        }
        "Visa", "Мир" -> {
            val commission = (transferAmount * 0.0075).toInt()
            if (cardType == "Visa") {
                if (commission < 35) 35 else commission
            } else 0

        }
        else -> {
            println("Неподдерживаемый тип карты.")
            -1 // Обозначает ошибку
        }
    }
}
