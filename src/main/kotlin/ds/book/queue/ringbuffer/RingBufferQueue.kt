package ds.book.queue.ringbuffer

import ds.book.queue.Queue

//class RingBufferQueue<T>(size : Int): Queue<T> {
//    private val ringBuffer: RingBuffer<T> = RingBuffer(size)
//
//    override fun enqueue(element: T): Boolean =
//        ringBuffer.write(element)
//
//    override fun dequeue(): T? {
//        if(isEmpty) null else ringBuffer.read()
//    }
//
//    override val count: Int
//        get() = ringBuffer.count
//
//    override fun peek(): T? = ringBuffer.first
//
//}