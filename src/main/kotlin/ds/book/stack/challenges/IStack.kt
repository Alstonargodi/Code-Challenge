package ds.book.stack.challenges

interface IStack<Element> {
    fun push(element: Element)
    fun pop(): Element?
    fun peek(): Element?
    val count : Int
        get
    val isEmpty: Boolean
        get() = count == 0
}