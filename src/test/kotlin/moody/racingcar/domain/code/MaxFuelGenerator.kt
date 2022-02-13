package moody.racingcar.domain.code

import moody.racingcar.domain.FuelGenerator

class MaxFuelGenerator : FuelGenerator {
    override fun generateFuel(): Int {
        return MAX_FUEL
    }

    companion object {
        private const val MAX_FUEL = 9
    }
}