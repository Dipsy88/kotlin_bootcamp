package Generics

class MyList<T> {

    fun get(pos: Int): T{
        TODO("implement")
    }

    fun addItem(item: T){
        println("Add item")
    }
}

fun workWithMyList(){
    val intList: MyList<String>

}