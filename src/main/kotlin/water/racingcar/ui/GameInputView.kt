package water.racingcar.ui

import water.racingcar.exception.EmptyCarNamesInputException
import water.racingcar.exception.InvalidCarNamesLengthInputException
import water.racingcar.exception.InvalidInputRacingCarException
import water.racingcar.exception.InvalidTimesInputException

object GameInputView {
    private const val CAR_NAME_INPUT_INFO_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분) "
    private const val CAR_NAME_INPUT_ERROR_INFO_MESSAGE = "※ 이름은 5자 이하만 가능합니다."
    private const val EMPTY_CAR_NAME_ERROR_INFO_MESSAGE = "값을 입력해야 합니다."
    private const val PLAY_TIMES_INPUT_INFO_MESSAGE = "시도할 회수는 몇회인가요?"
    private const val PLAY_TIMES_ERROR_INFO_MESSAGE = "※ 숫자를 입력해주세요. ex) 5"
    private const val NAME_LENGTH_LIMIT = 5

    fun getCarNamesInput(): List<String> {
        return try {
            println(CAR_NAME_INPUT_INFO_MESSAGE)
            getCarNames(readLine())
        } catch (e: InvalidInputRacingCarException) {
            getCarNamesInput()
        }
    }

    fun getTimesInput(): Int {
        println(PLAY_TIMES_INPUT_INFO_MESSAGE)
        return try {
            getNumberOfTimes(readLine())
        } catch (e: InvalidTimesInputException) {
            getTimesInput()
        }
    }

    private fun getCarNames(input: String?): List<String> {
        validCarNameInputExist(input)
        val nameList = input?.split(",")
        validCarNameLength(nameList)
        return nameList.orEmpty()
    }

    private fun validCarNameInputExist(input: String?) {
        if (input?.isEmpty() == true) {
            println(EMPTY_CAR_NAME_ERROR_INFO_MESSAGE)
            throw EmptyCarNamesInputException(EMPTY_CAR_NAME_ERROR_INFO_MESSAGE)
        }
    }

    private fun validCarNameLength(nameList: List<String>?) {
        val exceedNameLimitList = nameList?.filter { it.length > NAME_LENGTH_LIMIT }
        if (exceedNameLimitList?.isNotEmpty() == true) {
            println(CAR_NAME_INPUT_ERROR_INFO_MESSAGE)
            throw InvalidCarNamesLengthInputException(CAR_NAME_INPUT_ERROR_INFO_MESSAGE)
        }
    }

    private fun getNumberOfTimes(input: String?): Int {
        val times = try {
            input?.toInt()
        } catch (e: NumberFormatException) {
            println(PLAY_TIMES_ERROR_INFO_MESSAGE)
            null
        }
        return times ?: throw InvalidTimesInputException(PLAY_TIMES_ERROR_INFO_MESSAGE)
    }
}
