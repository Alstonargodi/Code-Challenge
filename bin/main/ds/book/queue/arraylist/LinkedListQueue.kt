package ds.book.queue.arraylist

import ds.book.queue.DoublyLinkedList
import ds.book.queue.Queue


class LinkedListQueue<T>: Queue<T> {
    private val list = DoublyLinkedList<T>()
    private var size = 0

    override fun enqueue(element: T): Boolean {
        list.appendOperation(element)
        size++
        return true
    }


    override val count: Int
        get() = size

    override fun peek(): T? {
        TODO("Not yet implemented")
    }

    override fun dequeue(): T? {
        TODO("Not yet implemented")
    }
}