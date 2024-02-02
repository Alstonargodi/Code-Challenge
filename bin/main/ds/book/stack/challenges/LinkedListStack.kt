package ds.book.stack.challenges

import ds.book.linkedlist.basic.Node

class LinkedListStack<T> {
    private var head: NodeStack<T>? = null
    private var tail : NodeStack<T>? = null
    var size = 0

    fun isEmpty(): Boolean{
        return size == 0
    }

    override fun toString(): String {
        if(isEmpty()){
            return "empty list"
        }else{
            return head.toString()
        }
    }

    fun push(value : T){
        head = NodeStack(
            value = value,
            next = head
        )
        size++
    }

    fun nodeAt(index : Int): NodeStack<T>?{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    //append operator 0(1)
    fun append(value : T){

        //push the value
        if(isEmpty()){
            push(value)
            return
        }

        tail?.next = NodeStack(
            value = value
        )

        tail = tail?.next
        size++
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

    //removeAfter
    fun removeAfter(node: NodeStack<T>): T?{
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

    operator fun iterator(): Iterator<T> {
        return LinkedListIteratorStack(this)
    }
}

