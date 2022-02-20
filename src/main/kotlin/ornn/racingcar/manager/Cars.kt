package ornn.racingcar.manager

import ornn.racingcar.domain.Car

class Cars(private val cars: List<Car>) : List<Car> by cars {

    companion object {
        fun fromName(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }

    fun getWinners(): List<Car> {
        val winnerCar = cars.maxBy { it.getPosition() }
        return cars.filter { it.getPosition() == winnerCar?.getPosition() }
    }

    fun getCarsSize(): Int {
        return cars.size
    }
}
