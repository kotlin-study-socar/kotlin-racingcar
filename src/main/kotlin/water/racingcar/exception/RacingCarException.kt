package water.racingcar.exception

open class InvalidInputRacingCarException(private val msg: String) : IllegalArgumentException(){
    override val message: String?
        get() = msg
}

class EmptyCarNamesInputException(msg: String) : InvalidInputRacingCarException(msg)
class InvalidCarNamesLengthInputException(msg: String) : InvalidInputRacingCarException(msg)
class InvalidTimesInputException(msg: String) : InvalidInputRacingCarException(msg)
