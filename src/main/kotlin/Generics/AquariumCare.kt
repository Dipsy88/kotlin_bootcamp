package Generics

fun main(args: Array<String>) {
    val testList = listOf(11,12,13,14,15,16,17,18,19,20)
    println(testList.reversed())
}



/*
fun reverseList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 0..list.size-1){
        result.add(list[list.size-1-i])
    }
    return result
}*/
