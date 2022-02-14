package ornn.racingcar

import ornn.racingcar.Application.Companion.carManager
import ornn.racingcar.Application.Companion.inputService
import ornn.racingcar.manager.CarManager
import ornn.racingcar.service.InputService

fun main(){
    val carNames = inputService.readCarNames()
    carManager.setCars(carNames)
    val playingTimes = inputService.readPlayingTimes()
    
}


class Application{
    companion object{
        val inputService = InputService()
        val carManager = CarManager()
    }
}


