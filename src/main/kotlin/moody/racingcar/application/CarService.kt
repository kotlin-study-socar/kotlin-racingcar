package moody.racingcar.application

import moody.racingcar.application.dto.CarsDto
import moody.racingcar.domain.Car
import moody.racingcar.domain.Cars
import moody.racingcar.domain.FuelGenerator

class CarService(names: List<String>) {
    val cars: Cars

    init {
        cars = Cars(names.map { Car(it) })
    }

    fun moveAll(fuelGenerator: FuelGenerator): CarsDto {
        val movedCars = cars.moveAll(fuelGenerator)
        return CarsDto.toDto(movedCars)
    }

    fun findWinners(): List<String> {
        return cars.findMaxPositionCars()
            .map { it.name }
    }
}
