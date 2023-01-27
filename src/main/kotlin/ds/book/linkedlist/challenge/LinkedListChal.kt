package ds.book.linkedlist.challenge

class LinkedListChal<T> {
    private var head: NodeChal<T>? = null
    private var tail : NodeChal<T>? = null
    private var size = 0

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
        head = NodeChal(
            value = value,
            next = head
        )
        size++
    }

    fun nodeAt(index : Int): NodeChal<T>?{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

}

