package ornn.racingcar.data

import ornn.racingcar.Application

data class Car(private val name: String) {

    var position: Int = 0
        private set

    fun printRecord() {
        print("${name} : ")
        for (i in 1..position) {
            print("-")
        }
        println()
    }

    fun move() {
        val randomNum = Application.random.nextInt(MOVE_TO - MOVE_FROM) + MOVE_FROM
        if (randomNum >= 4) {
            position++
        }
    }

    fun printName(){
        print(name)
    }

    companion object {
        const val MOVE_FROM = 0
        const val MOVE_TO = 10
    }
}