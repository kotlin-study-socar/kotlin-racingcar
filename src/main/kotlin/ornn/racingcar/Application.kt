package ornn.racingcar

import ornn.racingcar.Application.Companion.inputService
import ornn.racingcar.data.Game
import ornn.racingcar.manager.CarManager
import ornn.racingcar.service.InputService
import java.util.*

fun main(){
    val carNames = inputService.readCarNames()
    val carManager = CarManager(carNames)
    val playingTimes = inputService.readPlayingTimes()

    val game = Game(carManager, playingTimes)
    game.playing()
}

class Application{
    companion object{
        val inputService = InputService()
        val random = Random()
    }
}


