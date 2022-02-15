package moody.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import moody.racingcar.domain.code.MaxFuelGenerator

internal class CarsTest : BehaviorSpec({

    given("자동차들 생성 시") {
        `when`("자동차들이 리스트 형태로 인자가 넘어오면") {
            val result = Cars(carList)
            then("Cars 객체가 생성된다.") {
                result shouldHaveSize 3
                result shouldContainAll carList
            }
        }
    }

    given("생성된 자동차들에") {
        val cars = Cars(carList)
        `when`("한 라운드 만큼 이동을 실행하면") {
            val result = cars.moveAll(MaxFuelGenerator())
            then("각 자동차들이 조건에 따라 이동한다.") {
                result.forEach { it.position shouldBe 1 }
            }
        }

        val movedCars = cars.moveAll(MaxFuelGenerator())
        `when`("가장 멀리 간 자동차를 조회하면") {
            val result = movedCars.findMaxPositionCars()
            then("해당하는 자동차를 반환한다.(복수개 반환 가능)") {
                result shouldHaveSize 3
            }
        }
    }
}) {
    companion object {
        private val car1 = Car("a")
        private val car2 = Car("b")
        private val car3 = Car("c")
        private val carList = mutableListOf(car1, car2, car3)
    }
}