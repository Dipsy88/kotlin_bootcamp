package Aquarium

import java.lang.Math.PI

open class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40 ) {
/*    var length: Int = 100
    var width: Int = 20
    var height: Int = 40*/

    open var volume : Int
        get() = width * height * length / 1000
        set(value){
            height = (value * 1000)/(width*length)
        }

    open var water = volume * 0.9

    constructor(numberOfFish: Int): this(){}

/*    val volume : Int
        get(){
            return  width * height * length / 1000
        }*/

  /*  fun volume() = width * height * length / 1000*/

  /*  fun volume(): Int {
        return width * height * length / 1000
    }*/

}

class TowerTank(): Aquarium(){
    override var water = volume * 0.8

    override var volume: Int
        get() = (width*height*length/1000* PI).toInt()
        set(value){
            height = (value*1000) / (width*length)
        }
}
