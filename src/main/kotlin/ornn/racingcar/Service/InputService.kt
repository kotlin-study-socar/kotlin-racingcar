package ornn.racingcar.Service

import ornn.racingcar.Resource.Strings
import ornn.racingcar.exception.IllegalInputException

class InputService {

    fun readCarNames(): List<String> {
        var carNames : List<String>
        while (true) {
            println(Strings.ASK_CAR_NAMES)
            val input = readLine().toString()
            println(input)
            try {
                carNamesNullInput(input)
                carNames = input.split(",")
                carNameMoreThanFive(carNames)
                break
            } catch (e: IllegalInputException) {
                println(Strings.ERROR_MESSAGE + Strings.ERROR_INFO_INVALID_CARNAME)
            }
        }
        return carNames
    }

    fun carNameMoreThanFive(carNames: List<String>) {
        for (carName in carNames) {
            if (carName.length >= 5 || carName.isEmpty()) {
                throw  IllegalInputException(Strings.ERROR_MESSAGE);
            }
        }
    }

    fun carNamesNullInput(input: String?) {
        if (input == null || input.isEmpty() || input == "null") {
            throw IllegalInputException(Strings.ERROR_MESSAGE)
        }
    }


}