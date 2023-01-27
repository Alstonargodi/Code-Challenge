package ds.book.linkedlist

var size = 0
    private set

class LinkedListIterator <T>(
    private val list : ds.book.linkedlist.LinkedList<T>
) : Iterator<T>, MutableIterator<T>{
    private var index = 0
    private var lastNode : Node<T>? = null

    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun next(): T {
       if(index >= list.size) throw IndexOutOfBoundsException()

        lastNode = if (index == 0){
            list.nodeAt(0)
        }else{
            lastNode?.next
        }

        index++
        return lastNode!!.value
    }

    override fun remove() {
        if (index == 1){
            list.popOperation()
        }else{
            val prevNode = list.nodeAt(
                index-2
            ) ?: return
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }
}

fun main(){
    printingDoubles()
}

fun printingDoubles(){
    val list = LinkedList<Int>()
    list.pushOperation(3)
    list.pushOperation(2)
    list.pushOperation(1)
    print(list)

    for (item in list){
        print("\n Double: ${item*2}")
    }
}