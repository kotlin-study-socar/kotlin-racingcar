package ornn.racingcar.domainTest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import ornn.racingcar.manager.Cars

class CarsTest : BehaviorSpec({
    given("자동차들 생성 시") {
        `when`("자동차들의 이름이 리스트 형태로 인자가 넘어오면") {
            val cars = Cars.fromName(carNames)
            then("Cars 객체가 생성된다.") {
                cars.getCarsSize() shouldBe 3
            }
        }
    }
}) {
    companion object {
        private const val carName1 = "a"
        private const val carName2 = "b"
        private const val carName3 = "c"
        val carNames = listOf(carName1, carName2, carName3)
    }
}
