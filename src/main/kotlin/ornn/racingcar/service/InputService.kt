package ornn.racingcar.service

import ornn.racingcar.resource.Strings
import ornn.racingcar.exception.IllegalInputException

class InputService {

    fun readCarNames(): List<String> {
        var carNames: List<String>
        while (true) {
            println(Strings.ASK_CAR_NAMES)
            val input = readLine().toString()
            try {
                checkInputIsNull(input)
                carNames = input.split(",")
                checkCarNameMoreThanFive(carNames)
                break
            } catch (e: IllegalInputException) {
                println(Strings.ERROR_MESSAGE + " " + Strings.ERROR_INFO_INVALID_INPUT)
            }
        }
        return carNames
    }

    fun readPlayingTimes(): Int {
        var input : String
        while (true) {
            println(Strings.ASK_HOW_MANY_TIMES_TO_PLAY)
            input = readLine().toString()
            try {
                checkInputIsNull(input)
                checkPlayTimeIsNum(input)
                break
            } catch (e: IllegalInputException) {
                println(Strings.ERROR_MESSAGE + " " + Strings.ERROR_INFO_INVALID_INPUT)
            }
        }
        return input.toInt()
    }

    fun checkPlayTimeIsNum (input : String) {
        for (c in input) {
            if (!c.isDigit()) {
                throw IllegalInputException(Strings.ERROR_MESSAGE)
            }
        }
    }

    fun checkCarNameMoreThanFive(carsName: List<String>) {
        for (carName in carsName) {
            if (carName.length >= 5 || carName.isEmpty()) {
                throw  IllegalInputException(Strings.ERROR_MESSAGE);
            }
        }
    }

    fun checkInputIsNull(input: String?) {
        if (input == null || input.isEmpty() || input == "null") {
            throw IllegalInputException(Strings.ERROR_MESSAGE)
        }
    }

}