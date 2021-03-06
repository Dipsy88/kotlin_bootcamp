import java.util.*

fun main(args: Array<String>){
    println("Hello, world!")
    feedFish()

    var bubbles = 0
    while (bubbles < 50){
        bubbles ++
    }

    repeat(2){
        println("A fish is swimming")
    }
    eagerExample()
    dirtyProcessor()
}

var dirty = 200
val waterFilter: (Int) -> Int = {dirty -> dirty/2}
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty, {dirty -> dirty + 50 })
}

fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter{it[0] == 'p'}
    println(eager)

    // apply filter lazily
    val filtered = decorations.asSequence().filter{it[0]=='p'}
    println(filtered.toList())

    // apply map lazily
    val lazyMap = decorations.asSequence().map{
        println("map:$it")
    }


}

fun shouldChangeWater(day: String, temperature: Int=22, dirty: Int = 20): Boolean{
    val isTooHot = temperature > 30
    val isDirty= dirty > 30
    val isSunday = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun feedFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)

    if(shouldChangeWater(day)){
        println("Change the water today")
    }
}

fun randomDay(): String{
    val week = listOf ("Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day: String) : String {
    return when (day){
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" ->  "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }

}