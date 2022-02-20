package ornn.racingcar.applicationTest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import ornn.racingcar.domain.Car
import ornn.racingcar.manager.Cars
import ornn.racingcar.service.CarService

class CarServiceTest : BehaviorSpec({

    given("자동차 경주에서 게임이 끝났을 때 ") {
        `when`("자동차a가 1칸 b와 c가 2칸 갔다면") {
            val testCars = Cars(cars)
            val testCarService = CarService(testCars)
            then("우승자는 b와 c가 된다") {
                val result = testCarService.getResult()
                result.size shouldBe 2
                result shouldContainAll listOf<String>("b", "c")
            }
        }
    }
}) {
    companion object {
        val carA = Car("a", 1)
        val carB = Car("b", 2)
        val carC = Car("c", 2)
        val cars = listOf(carA, carB, carC)
    }
}
