package moody.racingcar.ui.view

import moody.racingcar.application.dto.CarDto

object OutputView {
    fun printStartResult() {
        println("실행 결과")
    }

    fun printRoundResult(cars: List<CarDto>) {
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
        println()
    }

    fun printWinners(winnerNames: List<String>) {
        println("${winnerNames.joinToString(",")}가 최종 우승했습니다.")
    }
}
