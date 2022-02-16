package water.racingcar

import water.racingcar.domain.Car
import water.racingcar.ui.GameInputView
import water.racingcar.ui.GameOutputView
import water.racingcar.util.RandomGenerator.generateRandomNumber

class GameApplication(private val carNames: List<String>, private val times: Int) {
    private val cars = carNames.map { Car(it) }

    fun playGame() {
        repeat(times){
            playEachRound()
        }
        GameOutputView.printTotalResult(cars)
    }

    private fun playEachRound() {
        for (car in cars) {
            car.move(generateRandomNumber())
        }
        GameOutputView.printEachRound(cars)
    }
}

fun main() {
    val carNames = GameInputView.getCarNamesInput()
    val times = GameInputView.getTimesInput()
    val gameApplication = GameApplication(carNames,times)
    gameApplication.playGame()
}
