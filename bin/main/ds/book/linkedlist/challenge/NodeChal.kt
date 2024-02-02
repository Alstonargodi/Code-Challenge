package ds.book.linkedlist.challenge

data class NodeChal<T>(
    var value : T,var next : NodeChal<T>? = null
){
    override fun toString(): String {
        return if (next != null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
}
