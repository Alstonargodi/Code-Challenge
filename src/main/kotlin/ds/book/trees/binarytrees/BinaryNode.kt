package ds.book.trees.binarytrees

//provide alternative name for existing types
typealias Visitor<T> = (T)-> Unit

//T kotlin generics
class BinaryNode<T>(val value : T) {
    var leftChild : BinaryNode<T>? = null
    var rightChild : BinaryNode<T>? = null


}