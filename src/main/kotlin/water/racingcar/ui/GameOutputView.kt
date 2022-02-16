package water.racingcar.ui

import water.racingcar.domain.Car

object GameOutputView {
    fun printTotalResult(cars: List<Car>) {
        val maxMovedValue = cars.maxBy { it.movedValue }?.movedValue
        val winnerNameList = cars.filter { it.movedValue == maxMovedValue }.map { it.name }
        val winnerNamesOutput = winnerNameList.joinToString(separator = ", ")
        println("${winnerNamesOutput}가 최종 우승했습니다.")
    }

    fun printEachRound(cars: List<Car>) {
        val output = StringBuilder()
        for (car in cars) {
            output.append("$car\n")
        }
        println("$output")
    }
}