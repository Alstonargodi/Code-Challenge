package ds.book.linkedlist

import ds.book.mutablecollection.LinkedListIterator

//arraylist
class LinkedList<T>
    : Iterable<T>, Collection<T>, MutableIterable<T>,MutableCollection<T>{
    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    override var size = 0

    override fun toString(): String {
        if (isEmpty()){
            return "empty list"
        }else{
            return head.toString()
        }
    }

    //check if empty node
    override fun isEmpty(): Boolean{
        return size == 0
    }

    //push new value
    fun pushOperation(value: T): LinkedList<T>{
        head = Node(value = value, next = head)
        if (tail == null){
            tail = head
        }
        size++ //increment size
        return this
    }

    //append new value
    fun appendOperation(value: T): LinkedList<T>{
        if (isEmpty()){
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
        if (!isEmpty())
            size--
        val result = head?.value
        head = head?.next

        if (isEmpty()){
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

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun contains(element: T): Boolean {
        for (item in this){
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
       for(searched in elements){ //0(n^2)
           if (!contains(searched)) return false
       }
        return true
    }

    //mutable collection
    override fun add(element: T): Boolean {
        appendOperation(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
      for(element in elements){
          appendOperation(element)
      }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()){
            val item = iterator.next()
            if (item == element){
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for(item in elements){
            result = remove(item) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()){
            val item = iterator.next()
            if (!elements.contains(item)){
                iterator.remove()
                result = true
            }
        }
        return result
    }
}
