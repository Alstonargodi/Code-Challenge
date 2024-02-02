package ds.book.linkedlist.basic

fun main(){
   removingElements()
}
fun removingElements(){
    val list : MutableCollection<Int> = LinkedListMain()
    list.add(3)
    list.add(2)
    list.add(1)
    println(list)
    list.remove(1)
    println(list)
}

fun retrainingElements(){
    val list : MutableCollection<Int> = LinkedListMain()
    list.add(6)
    list.add(5)
    list.add(4)
    list.add(3)
    list.add(2)
    list.add(1)
    println(list)
    list.retainAll(listOf(1,2,3))
    println(list)
}

fun removeElements(){
    val list : MutableCollection<Int> = LinkedListMain()
    list.add(6)
    list.add(5)
    list.add(4)
    list.add(3)
    list.add(2)
    list.add(1)
    println(list)
    list.retainAll(listOf(1,2,3))
    println(list)
}