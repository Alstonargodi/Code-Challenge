package ds.book.queue

import ds.book.linkedlist.basic.LinkedListMain

class LinkedListQueue<T>: Queue<T> {
    private val list = DoublyLinkedList<T>()
    private var size = 0

    override fun enqueue(element: T): Boolean {
        list.appendOperation(element)
        size++
        return true
    }

    override fun dequeue(): T? {
        val firstNode = list.first() ?: return null
        size--
        return list.remove(firstNode)
    }

    override val count: Int
        get() = size

    override fun peek(): T? {
        TODO("Not yet implemented")
    }
}