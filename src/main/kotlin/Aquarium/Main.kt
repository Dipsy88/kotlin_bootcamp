package Aquarium
fun main (args: Array<String>){
    buildAquarium()
    makeFish()
}

fun buildAquarium(){
    val myAquarium = Aquarium()
    myAquarium.length = 90
    println("Length: ${myAquarium.length} "+
            "Width: ${myAquarium.width} "+
            "Height: ${myAquarium.height} "+
            "Volume: ${myAquarium.volume}");

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println(smallAquarium.toString())
    println("Small aquarium: ${smallAquarium.volume} Length: ${smallAquarium.length} "+
            "Width: ${smallAquarium.width} "+
            "Height: ${smallAquarium.height} "+
            "Volume: ${smallAquarium.volume}");

    var aquarium2 = Aquarium(numberOfFish = 100)
    println("Small aquarium 2: ${aquarium2.volume} Length: ${aquarium2.length} "+
            "Width: ${aquarium2.width} "+
            "Height: ${aquarium2.height} "+
            "Volume: ${aquarium2.volume}");
}

fun feedFish(fish: FishAction){
    fish.eat()
}

fun makeFish(){
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color} \nPlecostomus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}