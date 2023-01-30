package ds.book.stack.challenges

import ds.book.linkedlist.basic.Node

class LinkedListIteratorStack<T>(
    private val list : LinkedListStack<T>
): Iterator<T>, MutableIterator<T> {
    private var index = 0
    private var lastNode : NodeStack<T>? = null

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