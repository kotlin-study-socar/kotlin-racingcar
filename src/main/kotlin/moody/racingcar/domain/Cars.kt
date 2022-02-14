package moody.racingcar.domain

class Cars(val cars: List<Car>, private val fuelGenerator: FuelGenerator) : List<Car> by cars {

    fun moveAll(): Cars {
        val movedCars = map { it.move(fuelGenerator.generateFuel()) }
        return Cars(movedCars, fuelGenerator)
    }

    fun findMaxPositionCar() = filter { it.isSamePosition(calculateMaxPosition()) }

    private fun calculateMaxPosition() = maxByOrNull { it.position }?.position ?: 0

}
