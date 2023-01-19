package ds.book.linkedlist

//any type
data class Node<T>(var value : T, var next: Node<T>?= null){
    override fun toString(): String {
        return if (next != null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
}

fun main(){
    val node1 = Node("a")
    val node2 = Node("b")
    val node3 = Node("c")
    node1.next = node2 // call constructor
    node2.next = node3
    print(node1)
}