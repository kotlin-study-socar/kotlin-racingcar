package moody.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CarTest : BehaviorSpec({

    given("자동차에") {
        val car = Car("moody")
        `when`("4 이상의 값이 들어오면"){
            val fuel = 4
            val result = car.move(fuel)
            then("1칸 움직인다."){
                result.position shouldBe 1
            }
        }

        `when`("4 미만의 값이 들어오면"){
            val fuel = 3
            val result = car.move(fuel)
            then("움직이지 않는다."){
                result.position shouldBe 0
            }
        }
    }
})