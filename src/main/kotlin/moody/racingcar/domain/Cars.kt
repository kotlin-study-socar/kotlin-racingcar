package moody.racingcar.domain

class Cars(val cars: List<Car>, val fuelGenerator: FuelGenerator) : List<Car> by cars {

    fun moveAll(): Cars {
        val movedCars = cars.map { it.move(fuelGenerator.generateFuel()) }
        return Cars(movedCars, fuelGenerator)
    }

}
