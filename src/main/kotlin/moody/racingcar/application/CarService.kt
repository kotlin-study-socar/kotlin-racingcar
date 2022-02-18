package moody.racingcar.application

import moody.racingcar.application.dto.CarsDto
import moody.racingcar.domain.Car
import moody.racingcar.domain.Cars
import moody.racingcar.domain.FuelGenerator

class CarService(names: List<String>) {
    private val cars: Cars

    init {
        cars = Cars(names.map { Car(it) } as MutableList<Car>)
    }

    fun moveAll(fuelGenerator: FuelGenerator): CarsDto {
        return CarsDto.from(cars.moveAll(fuelGenerator))
    }

    fun findWinners(): List<String> {
        return cars.findMaxPositionCars()
            .map { it.name }
    }
}
