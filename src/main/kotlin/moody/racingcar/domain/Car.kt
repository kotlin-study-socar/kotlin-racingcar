package moody.racingcar.domain

class Car(val name: String, val position: Int = 0) {

    fun move(fuel: Int): Car {
        if (fuel >= 4) {
            return Car(name, position + 1)
        }
        return this
    }
}
