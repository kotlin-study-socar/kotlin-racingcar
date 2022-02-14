package ornn.racingcar.data

import ornn.racingcar.Application
import java.util.Random

data class Car (private val name : String){
    private var position: Int = 0

    fun printRecord() {
        print("${name} : ")
        for (i in 1..position){
            print("-")
        }
        println()
    }

    fun move(){
        val num = Application.random.nextInt(10)
        if (num >= 4) {
            position++
        }
    }
}