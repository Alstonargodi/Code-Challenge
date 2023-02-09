package ds.book.trees

import sun.reflect.generics.tree.Tree
import sun.reflect.generics.visitor.Visitor

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value : T) {
    private val children : MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun foreEachTree(visit : Visitor<T>){
        visit(this)
        children.forEach {
            it.foreEach(visit)
        }
    }
}
fun makeBevarageTree(): TreeNode<String>{
    val tree = TreeNode("bevarages")

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val choco = TreeNode("choco")

    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.apply {
        add(hot)
        add(choco)
    }

    hot.apply {
        add(tea)
        add(coffee)
        add(choco)
    }

    cold.apply {
        add(soda)
        add(milk)
    }

    tea.apply {
        add(blackTea)
        add(greenTea)
        add(chaiTea)
    }

    soda.apply {
        add(gingerAle)
        add(bitterLemon)
    }

    return tree
}
fun main(){
//    val leaf1 = TreeNode("Leaf 1")
//    val leaf2 = TreeNode("leaf 2")
//    val tree = TreeNode("PARENTS").run {
//        add(leaf1)
//        add(leaf2)
//    }
//    print(tree)

    val tree = makeBevarageTree()
    tree.foreEachTree{ println(it.value) }
}