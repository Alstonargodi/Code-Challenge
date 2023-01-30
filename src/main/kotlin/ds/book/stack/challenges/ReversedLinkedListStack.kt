package ds.book.stack.challenges

import ds.book.stack.StackOperator

fun <T>LinkedListStack<T>.printReverse(){
    val stack = StackOperator<T>()
    for(node in this){
        stack.push(node)
    }
    var node = stack.pop()
    while (node != null){
        print(node)
        node = stack.pop()
    }
}


fun main(){
    var list= LinkedListStack<Int>()
    list.push(4)
    list.push(3)
    list.push(2)
    list.push(1)
    print("\n $list")
    list.printReverse()
}