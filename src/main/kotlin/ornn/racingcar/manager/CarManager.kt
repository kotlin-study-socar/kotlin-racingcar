package ornn.racingcar.manager

import ornn.racingcar.data.Car

class CarManager{

    val cars = mutableListOf<Car>()

    fun setCars(carNames: List<String>) {
        for (carName in carNames) {
            cars.add(Car(carName))
        }
    }
}