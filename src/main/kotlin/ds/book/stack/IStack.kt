package ds.book.stack

import com.sun.org.apache.xpath.internal.operations.Bool

interface IStack<Element> {
    fun push(element: Element)
    fun pop(): Element?
    fun peek(): Element?
    val count : Int
    val isEmpty: Boolean
        get() = count == 0
}