package water.racingcar

import water.racingcar.domain.Car
import water.racingcar.dto.InputDto
import water.racingcar.ui.GameConsoleInput
import water.racingcar.util.RandomGenerator

class GameApplication(input: InputDto) {
    private val cars = input.carNames.map { Car(it) }
    private val randomGenerator: RandomGenerator = RandomGenerator();
    var times = input.times
        private set

    fun playGame() {
        while (times > 0) {
            times--
            playEachRound()
        }
        printTotalResult()
    }

    private fun playEachRound() {
        for (car in cars) {
            car.move(randomGenerator.generateRandomNumber())
        }
        printEachRound()
    }

    private fun printTotalResult() {
        val maxMovedValue = cars.maxBy { it.movedValue }?.movedValue
        val winnerNameList = cars.filter { it.movedValue == maxMovedValue }.map { it.name }
        val winnerNamesOutput = winnerNameList.joinToString(separator = ", ")
        println("${winnerNamesOutput}가 최종 우승했습니다.")
    }

    private fun printEachRound() {
        val output = StringBuilder()
        for (car in cars)
            output.append("$car\n")
        println("$output")
    }
}

fun main() {
    val consoleInput = GameConsoleInput()
    val inputDto = consoleInput.getInputs()
    val gameApplication = GameApplication(inputDto)
    gameApplication.playGame()
}
