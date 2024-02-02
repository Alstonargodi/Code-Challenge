package ds.book.linkedlist.challenge

private fun <T>addInReverse(
    listChal: LinkedListChal<T>,
    node : NodeChal<T>
){
    val next = node.next
    if (next != null){
        addInReverse(listChal, next)
    }
    listChal.append(node.value)
}

fun <T>LinkedListChal<T>.reversed(): LinkedListChal<T>{
    val result = LinkedListChal<T>()
    val head = this.nodeAt(0)
    if (head != null){
        addInReverse(result,head)
    }
    return result
}


fun main(){
    val list = LinkedListChal<Int>()
    list.push(3)
    list.push(2)
    list.push(1)
    print("before reverse : $list")
    print("reversed : ${list.reversed()}")
}
