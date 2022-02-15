package moody.racingcar.application

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import moody.racingcar.domain.code.MaxFuelGenerator

class CarServiceTest : BehaviorSpec({

    given("하나의 라운드에서") {
        val carService = CarService(names)
        `when`("각 자동차들에 이동을 실행하면") {
            val result = carService.moveAll(MaxFuelGenerator())
            then("각 자동차들이 이동한 후의 상태를 반환한다.") {
                result shouldHaveSize 3
                result.map { it.name } shouldContainAll names
                result.forEach { it.position shouldBe 1 }
            }
        }
    }

    // 최종 승자를 반환r
    given("모든 라운드만큼 이동한 후") {
        val carService = CarService(names)
        carService.moveAll(MaxFuelGenerator())
        carService.moveAll(MaxFuelGenerator())
        `when`("가장 멀리간 자동차를 조회하면") {
            val winners = carService.findWinners()
            then("해당 자동차의 이름을 반환한다.(여러대 가능)") {
                winners shouldContainAll names
            }
        }
    }

}) {
    companion object {
        private val names = listOf("a", "b", "c")
    }
}