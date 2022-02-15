package moody.racingcar.ui

import moody.racingcar.application.CarService
import moody.racingcar.domain.RandomFuelGenerator
import moody.racingcar.ui.view.InputView
import moody.racingcar.ui.view.OutputView

class CarController {

    private val inputView = InputView
    private val outputView = OutputView

    fun run() {
        val carNames = inputView.inputCarNames()
        val round = inputView.inputTryNumber()
        val carService = CarService(carNames)

        outputView.printStartResultMessage()
        repeat(round) {
            outputView.printRoundResult(carService.moveAll(RandomFuelGenerator()))
        }
        outputView.printWinners(carService.findWinners())
    }

}