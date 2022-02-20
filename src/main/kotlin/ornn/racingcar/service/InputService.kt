package ornn.racingcar.service

import ornn.racingcar.exception.IllegalInputException
import ornn.racingcar.resource.Strings

object InputService {

    fun readCarNames(): List<String> {
        lateinit var carNames: List<String>
        println(Strings.ASK_CAR_NAMES)
        val input = readLine()
        return try {
            validateInputIsNull(input)
            carNames = input!!.split(",")
            validateCarNameMoreThanFive(carNames)
            carNames
        } catch (e: IllegalInputException) {
            println(e.message)
            readCarNames()
        }
    }

    fun readPlayingTimes(): Int {
        println(Strings.ASK_HOW_MANY_TIMES_TO_PLAY)
        val input = readLine()
        return try {
            validateInputIsNull(input)
            validatePlayTimeIsNum(input!!)
            input.toInt()
        } catch (e: IllegalInputException) {
            println(e.message)
            readPlayingTimes()
        } catch (e: NumberFormatException) {
            println(e.message)
            readPlayingTimes()
        }
    }

    fun validatePlayTimeIsNum(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException(Strings.ERROR_MESSAGE + Strings.ERROR_INFO_NOT_NUM)
        }
    }

    fun validateCarNameMoreThanFive(carsName: List<String>) {
        for (carName in carsName) {
            if (carName.length > 5 || carName.isEmpty()) {
                throw  IllegalInputException(Strings.ERROR_MESSAGE + Strings.ERROR_INFO_CAR_NAME_LENGTH_MORE_THAN_FIVE)
            }
        }
    }

    fun validateInputIsNull(input: String?) {
        input?.replace(" ", "")
        if (input == null || input.isEmpty()) {
            throw IllegalInputException(Strings.ERROR_MESSAGE + Strings.ERROR_INFO_NULL_INPUT)
        }
    }
}
