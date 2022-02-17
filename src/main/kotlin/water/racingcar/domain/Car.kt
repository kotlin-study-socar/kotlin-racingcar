package water.racingcar.domain

class Car(val name: String) {
    var movedValue: Int = 0
        private set

    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            movedValue++
        }
    }

    override fun toString(): String {
        val output = StringBuilder()
        output.append("$name : ")
        repeat (movedValue){
            output.append("-")
        }
        return output.toString()
    }
}
