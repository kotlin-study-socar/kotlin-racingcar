package ornn.racingcar.manager

import ornn.racingcar.data.Car

class CarManager(carNames: List<String>) {
    private val cars = mutableListOf<Car>()

    init {
        for (carName in carNames) {
            cars.add(Car(carName))
        }
    }

    fun printCarsRecord() {
        for (car in cars) {
            car.printRecord()
        }
        println()
    }

    fun moveCars() {
        for (car in cars) {
            car.move()
        }
    }

    fun getWinners() : MutableList<Car> {
        var max = -1
        val winners = mutableListOf<Car>()
        for (car in cars) {
            if (car.position > max) {
                max = car.position
                winners.clear()
            }
            if (car.position == max) {
                winners.add(car)
            }
        }
        return winners
    }
}