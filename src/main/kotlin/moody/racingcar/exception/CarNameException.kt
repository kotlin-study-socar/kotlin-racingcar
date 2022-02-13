package moody.racingcar.exception

class CarNameException(message: String = "자동차의 이름은 5자 이하여야 합니다.") : RuntimeException(message)
