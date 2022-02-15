package moody.racingcar.domain.code

import moody.racingcar.domain.FuelGenerator

class ZeroFuelGenerator : FuelGenerator {
    override fun generateFuel(): Int {
        return NO_FUEL
    }

    companion object {
        private const val NO_FUEL = 0
    }
}
