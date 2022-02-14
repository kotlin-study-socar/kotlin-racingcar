package ornn.racingcar.data;

import ornn.racingcar.manager.CarManager
import ornn.racingcar.resource.Strings

class Game (private val carManager: CarManager, val playingTimes : Int){

    fun playing(playingTimes : Int) {
        println("\n" + Strings.RESULT)
        for (i in 1..playingTimes) {
            oneTimes()
        }
        getResult()
    }

    private fun getResult() {
        val winners = carManager.getWinners()
        print(Strings.ANNOUNCE_WINNER)
        var count = 0
        for (winner in winners) {
            count++
            print(" ")
            winner.printName()
            if (winners.size == count) {
                break;
            }
            print(",")
        }
    }

    private fun oneTimes() {
        carManager.moveCars()
        carManager.printCarsRecord()
    }
}
