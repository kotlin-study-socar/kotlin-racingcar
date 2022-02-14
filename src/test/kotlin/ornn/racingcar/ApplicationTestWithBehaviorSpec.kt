package ornn.racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.assertThrows
import ornn.racingcar.resource.Strings
import ornn.racingcar.service.InputService
import ornn.racingcar.exception.IllegalInputException

class ApplicationTestWithBehaviorSpec : BehaviorSpec({

    given("Cars 이름 입력"){
        println(Strings.ASK_CAR_NAMES)
        `when`("아무것도 입력하지 않으면"){
            val input = ""
            then("에러가 발생한다"){
                shouldThrow<IllegalInputException> {
                    inputService.checkInputIsNull(input)
                }
            }
        }

        `when`("Car 이름이 5자 이상이면"){
            val input = "socarcar,sukwoo"
            val carsName = input.split(",")
            then("오류가 발생해야된다"){
                assertThrows<IllegalInputException> {
                    inputService.checkCarNameMoreThanFive(carsName)
                }
            }
        }
    }
}) {

    companion object {
        val inputService = InputService()
    }
}