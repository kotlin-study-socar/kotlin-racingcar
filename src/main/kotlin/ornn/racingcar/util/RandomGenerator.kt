package ornn.racingcar.util

import java.util.Random

object RandomGenerator : Random() {
    private const val MOVE_FROM = 0
    private const val MOVE_TO = 10

    fun getRandomInt(): Int{
        return nextInt(MOVE_TO - MOVE_FROM) + MOVE_FROM
    }
}