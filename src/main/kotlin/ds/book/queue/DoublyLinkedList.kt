package ds.book.queue

import ds.book.linkedlist.basic.LinkedListIterator
import ds.book.linkedlist.basic.LinkedListMain
import ds.book.linkedlist.basic.Node

class DoublyLinkedList<T> {
    private val list = arrayListOf<T>()

    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    var size = 0

    override fun toString(): String {
        if (size == 0){
            return "empty list"
        }else{
            return head.toString()
        }
    }


    //push new value
    fun pushOperation(value: T): DoublyLinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null){
            tail = head
        }
        size++ //increment size
        return this
    }

    //append new value
    fun appendOperation(value: T): DoublyLinkedList<T> {
        if (size == 0){
            pushOperation(value)
            return this
        }
        tail?.next = Node(value = value)
        tail = tail?.next
        size++
        return this
    }

    //insert new value
    fun nodeAt(index : Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }
    fun insertOperation(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode){
            appendOperation(value)
            return tail!!
        }
        val newNode = Node(
            value = value,
            next = afterNode.next
        )
        afterNode.next = newNode
        size++
        return  newNode
    }

    //pop operation
    fun popOperation(): T?{
        if (size != 0)
            size--
        val result = head?.value
        head = head?.next

        if (size == 0){
            tail = null
        }
        return result
    }

    //remove operation
    fun removeLast(): T?{
        val head = head ?: return null
        if(head.next == null ) return popOperation()
        size--

        var prev = head
        var current = head

        var next = current.next
        while (next != null){
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.value
    }

    //removeAfter
    fun removeAfter(node: Node<T>): T?{
        val result = node.next?.value
        if (node.next == tail){
            tail = node
        }
        if (node.next != null){
            size--
        }
        node.next = node.next?.next
        return result
    }
}