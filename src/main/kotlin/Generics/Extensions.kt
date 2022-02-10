package Generics



fun main(args: Array<String>) {
   extensionsExample()
}

fun String.hasSpaces()= find {it == ' '} !=null

/*fun String.hasSpaces(): Boolean {
    val found = this.find {it == ' '}
    return found != null
}*/

fun extensionsExample() {
   println("Does it have spaces?".hasSpaces())
}

open class AquariumPlant(val color: String, private val size:Int)
class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)

fun AquariumPlant.isRed() = color == "Red"

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample(){
   val plant = GreenLeafyPlant(size=50)
   plant.print()

   val aquariumPlant: AquariumPlant = plant
   aquariumPlant.print()
}