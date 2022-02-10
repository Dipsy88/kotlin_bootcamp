package Generics

fun main(args: Array<String>){
    genericExample()
    genericExample2()
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater: WaterSupply(true){
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater: WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

/*class Aquarium<T>(val waterSupply:T)*/
/*class Aquarium<T: Any>(val waterSupply: T)*/

class Aquarium<T: WaterSupply>(val waterSupply: T){

    fun addWater(){
        check(!waterSupply.needsProcessed) {"water supply needs processed"}
        println("adding water from $waterSupply")
    }
}

fun genericExample(){
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()
    println(aquarium.waterSupply.needsProcessed)

/*    val aquarium2 = Aquarium("string")
    println(aquarium2.waterSupply)*/

/*    var aquarium3 = Aquarium(null)
    println(aquarium3.waterSupply)*/

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()

}

class Aquarium2<out T: WaterSupply>(val waterSupply: T){
    fun addWater(){
        check(!waterSupply.needsProcessed) {"water supply needs processed"}
        println("adding water from $waterSupply")
    }
}

interface Cleaner<in T:WaterSupply> {
    fun clean(waterSupply: T)
}


fun addItemTo(aquarium2: Aquarium2<WaterSupply>) = println("item added")

fun genericExample2(){
    val aquarium2 = Aquarium2(TapWater())
    addItemTo(aquarium2)
}

