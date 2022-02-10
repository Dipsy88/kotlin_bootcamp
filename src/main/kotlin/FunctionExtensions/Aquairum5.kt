package FunctionExtensions

import java.util.*

data class Fish (var name: String)

fun main(args: Array<String>){
    fishExamples()
}

fun fishExamples(){
    val fish = Fish("splashy")

    with (fish.name){
       println(replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })
    }
    println(fish.run{name})
    println(fish.apply{})

    val fish2: Fish = Fish(name="splashy").apply{name="Sharky"}
    println(fish2.name)

    // without inline an object is created ever call to myWith
    myWith (fish.name, object: Function1<String, Unit>{
        override fun invoke(name: String){
            println(name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })
        }
    })

    // with inline no object is created, and lambda body is inlined where
    fish.name.capitalize()
}

inline fun myWith(name: String, block: String.() -> Unit){
    name.block()


}