package ornn.racingcar

import ornn.racingcar.service.InputService

fun main(){
    val inputService = InputService()
    val carNames = inputService.readCarNames()

}


