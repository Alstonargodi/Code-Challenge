package ds.book.stack

interface IStack<Element> {
    fun push(element: Element)
    fun pop(): Element?
}