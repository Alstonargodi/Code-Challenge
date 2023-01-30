package ds.book.stack.challenges

data class NodeStack<T>(
    var value : T,var next : NodeStack<T>? = null
){
    override fun toString(): String {
        return if (next != null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
}
