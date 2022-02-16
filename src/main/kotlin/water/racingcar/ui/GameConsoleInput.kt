package water.racingcar.ui

import water.racingcar.dto.InputDto
import kotlin.math.abs

class GameConsoleInput {
    fun getInputs(): InputDto {
        val carNameList: List<String> = getCarNamesInput()
        val times = getTimesInput()
        return InputDto(carNameList,times)
    }

    private fun getCarNamesInput(): List<String> {
        var carNameList: List<String> = ArrayList<String>()
        while (carNameList.isEmpty()) {
            println(CAR_NAME_INPUT_INFO_MESSAGE)
            carNameList = getCarNames(readLine())
        }
        return carNameList
    }

    private fun getTimesInput(): Int {
        println(PLAY_TIMES_INPUT_INFO_MESSAGE)
        var times = getNumberOfTimes(readLine())
        while (times == null) {
            times = getNumberOfTimes(readLine())
        }
        return times
    }

    fun getNumberOfTimes(input: String?): Int? {
        val times = try {
            input?.toInt()
        } catch (e: NumberFormatException) {
            println("$PLAY_TIMES_ERROR_INFO_MESSAGE\n$PLAY_TIMES_INPUT_INFO_MESSAGE")
            null
        }
        return times?.let { abs(it) }
    }

    fun getCarNames(input: String?): List<String> {
        val nameList = input?.split(",")
        if (input?.isEmpty() == true || !validNameLength(nameList)) {
            return ArrayList()
        }
        return nameList.orEmpty()
    }

    private fun validNameLength(nameList: List<String>?): Boolean {
        val exceedNameLimitList = nameList?.filter { it.length > NAME_LENGTH_LIMIT }
        if (exceedNameLimitList?.isNotEmpty() == true) {
            println(CAR_NAME_INPUT_ERROR_INFO_MESSAGE)
            return false
        }
        return true
    }

    companion object {
        const val CAR_NAME_INPUT_INFO_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분) "
        const val CAR_NAME_INPUT_ERROR_INFO_MESSAGE = "※ 이름은 5자 이하만 가능합니다."
        const val PLAY_TIMES_INPUT_INFO_MESSAGE = "시도할 회수는 몇회인가요?"
        const val PLAY_TIMES_ERROR_INFO_MESSAGE = "※ 숫자를 입력해주세요. ex) 5"
        const val NAME_LENGTH_LIMIT = 5
    }
}