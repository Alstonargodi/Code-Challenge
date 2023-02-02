package ds.book.queue

/*
    0(1)
    resizing 0(n) operator
 */
class ArrayListQueue<T>: Queue<T> {
    private val list = arrayListOf<T>()

    //insert value to element
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? {
        return if(isEmpty) null else list.removeAt(0)
    }

    override val count: Int
        get() = list.size

    override fun peek(): T? {
        return list.getOrNull(0)
    }

    override fun toString(): String {
        return list.toString()
    }
}

fun main(){
    val queue = ArrayListQueue<Int>().apply {
        enqueue(1)
        enqueue(2)
        enqueue(3)
        enqueue(4)
        enqueue(5)
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("nextvalue ${queue.peek()}")
}