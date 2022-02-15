package moody.racingcar.domain

class Cars(val cars: MutableList<Car>) : MutableList<Car> by cars {

    fun moveAll(fuelGenerator: FuelGenerator): Cars {
        replaceAll { it.move(fuelGenerator.generateFuel()) }
        return Cars(cars)
    }

    fun findMaxPositionCars() = filter { it.isSamePosition(calculateMaxPosition()) }

    private fun calculateMaxPosition() = maxByOrNull(Car::position)?.position ?: 0
}
