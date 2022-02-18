package moody.racingcar.domain

import moody.racingcar.exception.CarNameException

class Car(val name: String, val position: Int = 0) {
    init {
        if (name.length > 5) {
            throw CarNameException()
        }
    }

    fun move(fuel: Int): Car {
        if (fuel >= 4) {
            return Car(name, position + 1)
        }
        return this
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }
}
