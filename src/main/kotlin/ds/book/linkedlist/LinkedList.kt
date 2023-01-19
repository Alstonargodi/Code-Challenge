package ds.book.linkedlist

data class NodeLinked<T>(var value : T, var next: NodeLinked<T>?= null){
    override fun toString(): String {
        return if (next != null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
}

//arraylist
class LinkedList<T> {
    private var head : NodeLinked<T>? = null
    private var tail : NodeLinked<T>? = null
    var size = 0

    //check if empty node
    fun isEmpty(): Boolean{
        return size == 0
    }

    //push new value
    fun pushOperation(value: T): LinkedList<T>{
        head = NodeLinked(value = value, next = head)
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
        tail?.next = NodeLinked(value = value)
        tail = tail?.next
        size++
        return this
    }

    //insert new value
    fun nodeAt(index : Int): NodeLinked<T>?{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }
    fun insertOperation(value: T, afterNode: NodeLinked<T>): NodeLinked<T>{
        if (tail == afterNode){
            appendOperation(value)
            return tail!!
        }
        val newNode = NodeLinked(
            value = value,
            next = afterNode.next
        )
        afterNode.next = newNode
        size++
        return  newNode
    }

    override fun toString(): String {
        if (isEmpty()){
            return "empty list"
        }else{
            return head.toString()
        }
    }
}

fun main(){
    //node
    val node1 = NodeLinked(1)
    val node2 = NodeLinked(2)
    val node3 = NodeLinked(3)
    node1.next = node2 // call constructor
    node2.next = node3
//    print(node1)

    //push
    val list = LinkedList<Int>()
    //chain push tail first
    list.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)
//    print(list)

    val appendList = LinkedList<Int>()
    //chain list head first
    appendList.appendOperation(1)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(3)
//    print(appendList)asd

    val insertList = LinkedList<Int>()
    insertList.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)


    print("before insert $insertList")
    var middleNode = insertList.nodeAt(1)
    for (i in 1..insertList.size){
        middleNode = middleNode?.let {
            insertList.insertOperation(
                value = -1 * i, //insert negatif
                afterNode = it
            )
        }
    }
    print("after insert $insertList")

}