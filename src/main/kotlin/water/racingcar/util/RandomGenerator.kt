package water.racingcar.util

object RandomGenerator {
    private val startNumber = 0
    private val endNumber = 9
    fun generateRandomNumber(): Int {
        return (startNumber..endNumber).random()
    }
}
