package data

sealed class Tree {
    class Node(val key: String,val children : Map<String,Tree>?): Tree()
    class Leaf(val result : Boolean): Tree()
}
