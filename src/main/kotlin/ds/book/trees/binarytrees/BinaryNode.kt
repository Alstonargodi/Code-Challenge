package ds.book.trees.binarytrees

//provide alternative name for existing types
typealias Visitor<T> = (T)-> Unit

//T kotlin generics
class BinaryNode<T>(val value : T) {
    var leftChild : BinaryNode<T>? = null
    var rightChild : BinaryNode<T>? = null

    override fun toString(): String = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top : String = "",
        root : String = "",
        bottom: String = ""
    ): String{
        return node?.let {
            if (node.leftChild == null && node.rightChild == null){
                "${root} null \n"
            }else{
                diagram(
                    node.rightChild,
                    "$top ",
                    "$top┌──",
                    "$top│ ") +
                        root + "${node.value}\n" +
                        diagram(
                            node.leftChild,
                            "$bottom│ ",
                            "$bottom└──",
                            "$bottom "
                        )
            }
        } ?: "${root} null \n"
    }
}



fun main(){
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    seven.rightChild = nine
    one.leftChild = zero
    one.rightChild = five
    nine.leftChild = eight

    val tree = seven
    print(tree)
}