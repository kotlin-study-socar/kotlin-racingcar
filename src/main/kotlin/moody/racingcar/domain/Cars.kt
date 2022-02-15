package moody.racingcar.domain

class Cars(val cars: List<Car>) : List<Car> by cars {

    fun moveAll(fuelGenerator: FuelGenerator): Cars {
        val movedCars = map { it.move(fuelGenerator.generateFuel()) }
        return Cars(movedCars)
    }

    fun findMaxPositionCar() = filter { it.isSamePosition(calculateMaxPosition()) }

    private fun calculateMaxPosition() = maxByOrNull { it.position }?.position ?: 0
}
