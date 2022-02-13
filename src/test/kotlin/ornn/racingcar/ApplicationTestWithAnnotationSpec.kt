package ornn.racingcar

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import ornn.racingcar.Resource.Strings
import ornn.racingcar.Service.InputService
import ornn.racingcar.exception.IllegalInputException

class ApplicationTestWithAnnotationSpec : AnnotationSpec() {
    companion object {
        val inputService = InputService()
    }

    // Kotest @AnnotationSpec
    @Test
    fun 전체이름_널체크() {
        val input = ""
        val actual = assertThrows<IllegalInputException> {
            inputService.carNamesNullInput(input)
        }
        actual.message shouldBe Strings.ERROR_MESSAGE
    }

    @Test
    fun 자동차_이름_5자_이상_예외처리() {
        val input = "socarcar,sukwoo"
        val carNames = input.split(",")
        val actual = assertThrows<IllegalInputException> {
            inputService.carNameMoreThanFive(carNames)
        }
        actual.message shouldBe Strings.ERROR_MESSAGE
    }

}
