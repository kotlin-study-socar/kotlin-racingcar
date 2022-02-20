package ornn.racingcar

import ornn.racingcar.manager.Cars
import ornn.racingcar.resource.Strings
import ornn.racingcar.service.CarService
import ornn.racingcar.service.InputService

fun main(){
    val carNames = InputService.readCarNames()
    val cars = Cars.fromName(carNames)
    val playingTimes = InputService.readPlayingTimes()
    val carService = CarService(cars)

    carService.playing(playingTimes)
    println(Strings.ANNOUNCE_WINNER + carService.getResult().joinToString(", "))
}
