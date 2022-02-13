package moody.racingcar.domain

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import moody.racingcar.exception.CarNameException

internal class CarTest : BehaviorSpec({

    given("자동차 생성 시") {
        `when`("5자 이하의 이름이 부여되면") {
            val result = Car("moody")
            then("정상적으로 객체가 생성된다.") {
                result.name shouldBe "moody"
            }
        }

        `when`("5자 초과한 이름이 부여되면") {
            val result = shouldThrowAny { Car("exception") }
            then("예외를 발생시킨다.") {
                result is CarNameException
            }
        }
    }

    given("자동차에") {
        val car = Car("moody")
        `when`("4 이상의 값이 들어오면") {
            val fuel = 4
            val result = car.move(fuel)
            then("1칸 움직인다.") {
                result.position shouldBe 1
            }
        }

        `when`("4 미만의 값이 들어오면") {
            val fuel = 3
            val result = car.move(fuel)
            then("움직이지 않는다.") {
                result.position shouldBe 0
            }
        }
    }
})