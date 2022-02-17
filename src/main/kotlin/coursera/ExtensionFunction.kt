package coursera

open class Parent

class Child: Parent()

fun Parent.foo() = "parent"
fun Child.foo() = "child"

class A{
    fun foo() = 1
}
fun A.foo() = 3

fun main(){
    val parent: Parent = Child()
    println(parent.foo())
    println(A().foo())

    val employees: List<Employee> = arrayListOf(Employee(City.OSLO, 13), Employee(City.PRAGUE, 11))
    println(employees.filter{it.city == City.PRAGUE}.map{it.age}.average())
    println(isEven(11))
    println(isOdd(11))
    run {println("Hello")}

    val persons: List<Person> = listOf(Person("Xek", 34), Person("hero", 4))
    println("${persons.maxByOrNull{it.age}?.name} and ${persons.maxByOrNull(Person::age)?.name}")
    println(list)
    println("${oneHalf(13.4)}, ${oneHalf(1)}, ${oneHalf(null)}")

    val name="Kotlin"
    myRun{ println("Hi, $name") }

    val result = 4.takeUnless{it>10}
    println(result)
}
val isEven: (Int) -> Boolean ={ it % 2 == 0 }
val isOdd = {i: Int -> i%2==1}

class Person(val name: String, val age:Int)


enum class City{
    PRAGUE, OSLO, HELSINKI
}

data class Employee (val city:City, val age:Int)

var list: List<Int> = listOf(1,null).filterNotNull()

fun <T: Number?> oneHalf(value: T): Double? {
    return if (value == null) null else value.toDouble()/2.0
}

fun myRun(f:()->Unit) = f()

inline fun <R> run(f:() ->R):R = f()

inline fun <T> T.takeUnless(pred: (T) ->Boolean):T? = if (!pred(this)) this else null

