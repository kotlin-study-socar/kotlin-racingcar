package moody.racingcar.application.dto

import moody.racingcar.domain.Car

data class CarDto(val name: String, val position: Int) {

    companion object {
        fun toDto(car: Car): CarDto {
            return CarDto(car.name, car.position)
        }
    }
}
