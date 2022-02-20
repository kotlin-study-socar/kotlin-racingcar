package ornn.racingcar.service

import ornn.racingcar.manager.Cars
import ornn.racingcar.resource.Strings
import ornn.racingcar.util.RandomGenerator

class CarService(private var cars: Cars) {

    fun playing(playingTimes: Int) {
        println("\n" + Strings.PLAYING_RESULT)
        repeat(playingTimes) {
            oneRound()
        }
    }

    private fun oneRound() {
        moveCars()
        printCarsRecord()
    }

    private fun moveCars() {
        cars = Cars(cars.map { it.move(RandomGenerator.getRandomInt()) })
    }

    private fun printCarsRecord() {
        cars.forEach { it.printRecord() }
        println()
    }

    fun getResult(): List<String> {
        return cars.getWinners().map { it.getName() }
    }
}
