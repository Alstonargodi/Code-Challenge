package ds.book.stack

import java.util.Stack

class StackOperator<T : Any>: IStack<T> {
    private val storage = arrayListOf<T>()
    override fun toString() = buildString {
        appendln("----top-----")
        storage.asReversed().forEach {
            appendln("$it")
        }
        appendln("-------------")
    }

    override fun push(element: T) {
       storage.add(element)
    }

    override fun pop(): T? {
       if (isEmpty){
           return null
       }
        return storage.removeAt(count-1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count : Int
        get() = storage.size

    companion object {
        fun <Element : Any>create(items : Iterable<Element>): IStack<Element>{
            val stack = StackOperator<Element>()
            for(item in items){
                stack.push(item)
            }
            return stack
        }

        fun <Element>stackOf(vararg element: Element): IStack<Element> {
            return StackOperator.create(element.asList())
        }
    }
}

fun main(){
//    val stack = StackOperator<Int>().apply {
//        push(1)
//        push(2)
//        push(3)
//    }
//    print(stack)
//    val popElement = stack.pop()
//    if (popElement != null){
//        print("pop element $popElement")
//    }
//    print(stack)


    val list = listOf('a','b','c')
    val stack = StackOperator.create(list)
    print(stack)
    print("${stack.pop()}")
}
