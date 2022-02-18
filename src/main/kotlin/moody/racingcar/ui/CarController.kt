package moody.racingcar.ui

import moody.racingcar.application.CarService
import moody.racingcar.domain.RandomFuelGenerator
import moody.racingcar.ui.view.InputView
import moody.racingcar.ui.view.OutputView

class CarController {

    fun run() {
        val carNames = InputView.inputCarNames()
        val round = InputView.inputTryNumber()
        val carService = CarService(carNames)

        OutputView.printStartResult()
        repeat(round) {
            OutputView.printRoundResult(carService.moveAll(RandomFuelGenerator()))
        }
        OutputView.printWinners(carService.findWinners())
    }
}
