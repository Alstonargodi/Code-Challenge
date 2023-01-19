package ds.book.linkedlist


//arraylist
class LinkedList<T> {
    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    var size = 0

    override fun toString(): String {
        if (isEmpty()){
            return "empty list"
        }else{
            return head.toString()
        }
    }

    //check if empty node
    fun isEmpty(): Boolean{
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

}

fun main(){
    popPushOperation()
}

fun pushOperation(){
    /*
    Push operation
    chain push tail first
    0(1)
 */
    val list = LinkedList<Int>()
    list.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)
    print(list)
}

fun appendOperation(){
    /*
    Append operation
    chain list head first
    0(1)
 */
    val appendList = LinkedList<Int>()
    appendList.appendOperation(1)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(3)
    print(appendList)
}

fun insertOperation(){
    /*
    insert operation
    0(1)
    nodeAt 0(index)
 */
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

fun popPushOperation(){
    val list = LinkedList<Int>()
    list.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)
    print("push value :$list \n")
    val popValue = list.popOperation()
    print("after pop :$list \n")
    print("remove value: $popValue \n")
}
