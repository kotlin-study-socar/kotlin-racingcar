package ornn.racingcar

import ornn.racingcar.Application.Companion.carManager
import ornn.racingcar.Application.Companion.inputService
import ornn.racingcar.manager.CarManager
import ornn.racingcar.resource.Strings
import ornn.racingcar.service.InputService
import java.util.Random

fun main(){
    val carNames = inputService.readCarNames()
    carManager.setCars(carNames)
    val playingTimes = inputService.readPlayingTimes()
    playing(playingTimes)
}

fun playing(playingTimes : Int) {
    println("\n" + Strings.RESULT)
    for (i in 1..playingTimes) {
        oneTimes()
    }
}

fun oneTimes() {
    carManager.moveCars()
    carManager.printCarsRecord()
}


class Application{
    companion object{
        val inputService = InputService()
        val carManager = CarManager()
        val random = Random()
    }
}


