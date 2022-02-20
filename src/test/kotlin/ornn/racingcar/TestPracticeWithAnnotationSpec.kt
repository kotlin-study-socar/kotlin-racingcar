package ornn.racingcar

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import ornn.racingcar.exception.IllegalInputException
import ornn.racingcar.resource.Strings
import ornn.racingcar.service.InputService

class TestPracticeWithAnnotationSpec : AnnotationSpec() {

    @Test
    fun 전체이름_널체크() {
        val input = ""
        val actual = assertThrows<IllegalInputException> {
            InputService.validateInputIsNull(input)
        }
        actual.message shouldBe Strings.ERROR_MESSAGE + Strings.ERROR_INFO_NULL_INPUT
    }

    @Test
    fun 자동차_이름_5자_이상_예외처리() {
        val input = "socarcar,sukwoo"
        val carsName = input.split(",")
        val actual = assertThrows<IllegalInputException> {
            InputService.validateCarNameMoreThanFive(carsName)
        }
        actual.message shouldBe Strings.ERROR_MESSAGE + Strings.ERROR_INFO_CAR_NAME_LENGTH_MORE_THAN_FIVE
    }

}
