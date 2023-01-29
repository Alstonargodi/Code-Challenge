package ds.book.stack

class StackOperator<T : Any>(): IStack<T> {
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
       if (storage.size == 0){
           return null
       }
        return storage.removeAt(storage.size-1)
    }
}

fun main(){
    val stack = StackOperator<Int>().apply {
        push(1)
        push(2)
        push(3)
    }
    print(stack)
    val popElement = stack.pop()
    if (popElement != null){
        print("pop element $popElement")
    }
    print(stack)
}