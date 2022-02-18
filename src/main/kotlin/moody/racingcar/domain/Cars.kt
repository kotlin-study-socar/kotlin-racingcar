package moody.racingcar.domain

class Cars(private val cars: MutableList<Car>) : MutableList<Car> by cars {

    fun moveAll(fuelGenerator: FuelGenerator): Cars {
        cars.replaceAll { it.move(fuelGenerator.generateFuel()) }
        return this
    }

    fun findMaxPositionCars(): List<Car> {
        val maxPosition = calculateMaxPosition()
        return filter { it.isSamePosition(maxPosition) }
    }

    private fun calculateMaxPosition() = maxByOrNull(Car::position)?.position ?: 0
}
