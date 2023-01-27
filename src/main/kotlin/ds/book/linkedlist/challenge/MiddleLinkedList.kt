package ds.book.linkedlist.challenge

import java.util.LinkedList

//runner technique 0(n)
fun <T>LinkedListChal<T>.getMiddle(): NodeChal<T>?{
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while (fast != null){
        fast = fast.next
        if (fast != null){
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}

fun main(){
    printMiddle()
}

fun printMiddle(){
    val list= LinkedListChal<Int>()
    list.push(4)
    list.push(3)
    list.push(2)
    list.push(1)
    print("\n $list")
    print("middle value ${list.getMiddle()?.value}")
}