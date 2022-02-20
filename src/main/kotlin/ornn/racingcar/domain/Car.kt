package ornn.racingcar.domain

data class Car(private val name: String, private val position: Int = 0) {

    fun getName(): String {
        return this.name
    }

    fun getPosition(): Int {
        return this.position
    }

    fun move(randomNum: Int): Car {
        if (randomNum >= 4) {
            return Car(this.name, this.position + 1)
        }
        return this
    }

    fun printRecord() {
        println("$name : ${"-".repeat(position)}")
    }
}
