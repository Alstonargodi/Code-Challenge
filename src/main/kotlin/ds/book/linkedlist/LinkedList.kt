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

class LinkedList<T> {
    private var head : NodeLinked<T>? = null
    private var tail : NodeLinked<T>? = null

}