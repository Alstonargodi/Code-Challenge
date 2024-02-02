package ds.book.queue.doublestack

import ds.book.queue.DoublyLinkedList
import ds.book.queue.Queue
import ds.book.stack.challenges.StackOperator

class StackQueue<T>: Queue<T> {
    private val rightStack = StackOperator<T>()
    private val leftStack = StackOperator<T>()

    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty){
            transferElements()
        }
        return leftStack.pop()
    }

    override val count: Int
        get() = TODO("Not yet implemented")

    override fun peek(): T? {
       if (leftStack.isEmpty){
           transferElements()
       }
        return leftStack.peek()
    }

    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    private fun transferElements(){
        var nextElement = rightStack.pop()
        while (nextElement != null){
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }

    override fun toString(): String {
        return "left stack: \n $leftStack \n right stack : \n $rightStack"
    }
}

fun main(){
    val queue = StackQueue<String>().apply {
        enqueue("1")
        enqueue("2")
        enqueue("3")
        enqueue("4")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("next value : ${queue.peek()}")
}