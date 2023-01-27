package ds.book.linkedlist.challenge

//extension function
fun <T>LinkedListChal<T>.printInReverse(){
    this.nodeAt(0)?.printInReverse()
}

fun <T>NodeChal<T>.printInReverse(){
    this.next?.printInReverse()
    if (this.next != null){
        print(">")
    }
    print("${this.value}")
}

fun main(){
    printReversed()
}

fun printReversed(){
    var list= LinkedListChal<Int>()
    list.push(4)
    list.push(3)
    list.push(2)
    list.push(1)
    print("\n $list")
    list.printInReverse()
}