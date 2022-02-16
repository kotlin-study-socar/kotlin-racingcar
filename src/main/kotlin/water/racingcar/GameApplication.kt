package water.racingcar

import water.racingcar.domain.Car
import water.racingcar.ui.GameInputView
import water.racingcar.ui.GameOutputView
import water.racingcar.util.RandomGenerator

class GameApplication(private val carNames: List<String>, private val times: Int) {
    private val cars = carNames.map { Car(it) }
    private val randomGenerator = RandomGenerator()

    fun playGame() {
        repeat(times){
            playEachRound()
        }
        GameOutputView.printTotalResult(cars)
    }

    private fun playEachRound() {
        for (car in cars) {
            car.move(randomGenerator.generateRandomNumber())
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
