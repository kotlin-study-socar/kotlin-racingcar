package ornn.racingcar.domainTest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe
import ornn.racingcar.domain.Car

class CarTest : BehaviorSpec({

    given("차가 이동할지 여부를 판단해주는 값이 주어졌을때") {
        var testCar = Car(name, position)
        `when`("값이 4미만이면") {
            val randomNum = 1
            then("앞으로 전진하지 않는다.") {
                val movedCar = testCar.move(randomNum)
                randomNum shouldBeLessThan 4
                movedCar.getPosition() shouldBe 0
            }
        }

        testCar = Car(name, position)
        `when`("값이 4이상이면") {
            val randomNum = 5
            then("앞으로 전진한다.") {
                val movedCar = testCar.move(randomNum)
                randomNum shouldBeGreaterThanOrEqualTo 4
                movedCar.getPosition() shouldBe 1
            }
        }
    }

}) {
    companion object {
        const val name = "socar"
        const val position = 0
    }
}
