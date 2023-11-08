package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.enumeration.Bonus
import lotto.enumeration.Buy
import lotto.enumeration.Winning

class LottoUI {
    fun printBuyPrice() {
        println(Buy.PRICE_INPUT.value)
    }

    fun inputBuyPrice(): String {
        val buyPrice = Console.readLine()
        try {
            LottoService().checkInvalidBuyPrice(buyPrice)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            printBuyPrice()
            return inputBuyPrice()
        }
        return buyPrice
    }

    fun printBuyLottoCount(buyPrice: String) {
        println()
        print(buyPrice.toInt() / 1000)
        println(Buy.HOW_MANY.value)
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach {
            println("${it.getNumbers()}")
        }
        println()
    }

    fun printWinningNumbers() {
        println(Winning.NUMBER_INPUT.value)
    }

    fun inputWinningNumbers(): Lotto {
        val winningNumbers = Console.readLine().split(",")
        try {
            LottoService().checkInvalidWinningNumbers(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            printWinningNumbers()
            return inputWinningNumbers()
        }
        return Lotto(winningNumbersToInt(winningNumbers))
    }

    private fun winningNumbersToInt(winningNumbers: List<String>): List<Int> {
        return winningNumbers.map { it.toInt() }
    }

}
