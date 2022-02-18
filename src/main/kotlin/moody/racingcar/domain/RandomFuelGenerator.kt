package moody.racingcar.domain

import kotlin.random.Random

class RandomFuelGenerator : FuelGenerator {
    override fun generateFuel(): Int {
        return Random.nextInt(NUMBER_BOUNDARY)
    }

    companion object {
        private const val NUMBER_BOUNDARY = 10
    }
}
