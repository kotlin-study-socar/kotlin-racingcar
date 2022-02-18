package moody.racingcar.application.dto

import moody.racingcar.domain.Cars

data class CarsDto(val cars: List<CarDto>) : List<CarDto> by cars {

    companion object {
        fun from(cars: Cars): CarsDto {
            return CarsDto(cars.map { CarDto.from(it) })
        }
    }
}
