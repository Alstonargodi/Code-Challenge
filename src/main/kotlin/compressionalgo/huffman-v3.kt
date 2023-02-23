package compressionalgo

import java.io.ByteArrayOutputStream
import java.util.*

//data class Node(
//    val symbol: Int? = null,
//    val weight: Int? = null,
//    val left: Node? = null,
//    val right: Node? = null
//)
//
//fun buildHuffmanTree(frequencies: IntArray): Node {
//    val pq = PriorityQueue<Node>(kotlin.Comparator { a, b -> a.weight!! - b.weight!! })
//
//    for (i in 0 until frequencies.size) {
//        if (frequencies[i] > 0) {
//            pq.add(Node(i, frequencies[i], null, null))
//        }
//    }
//
//    while (pq.size > 1) {
//        val left = pq.poll()
//        val right = pq.poll()
//        val parent = Node(null, left.weight!! + right.weight!!, left, right)
//        pq.add(parent)
//    }
//
//    return pq.poll()
//}
//
//fun buildHuffmanCodes(node: Node, code: String, codes: Array<String>) {
//    if (node.symbol != null) {
//        codes[node.symbol] = code
//    } else {
//        buildHuffmanCodes(node.left!!, code + "0", codes)
//        buildHuffmanCodes(node.right!!, code + "1", codes)
//    }
//}
//
//fun compressImage(image: Array<IntArray>): ByteArray {
//    val frequencies = IntArray(256)
//
//    for (row in image) {
//        for (pixel in row) {
//            frequencies[pixel]++
//        }
//    }
//
//    val tree = buildHuffmanTree(frequencies)
//
//    val codes = Array<String>(256) { "" }
//    buildHuffmanCodes(tree, "", codes)
//
//    val outputStream = ByteArrayOutputStream()
//    val bitStream = BitOutputStream(outputStream)
//
//    for (row in image) {
//        for (pixel in row) {
//            val code = codes[pixel]
//            for (bit in code) {
//                bitStream.write(bit.toInt() - 48)
//            }
//        }
//    }
//
//    bitStream.flush()
//    return outputStream.toByteArray()
//}
//
//fun decompressImage(compressedData: ByteArray, width: Int, height: Int): Array<IntArray> {
//    val frequencies = IntArray(256)
//
//    for (byte in compressedData) {
//        frequencies[byte.toInt() and 0xFF]++
//    }
//
//    val tree = buildHuffmanTree(frequencies)
//
//    val codes = Array<String>(256) { "" }
//    buildHuffmanCodes(tree, "", codes)
//
//    val inputStream = ByteArrayInputStream(compressedData)
//    val bitStream = BitInputStream(inputStream)
//
//    val image = Array<IntArray>(height) { IntArray(width) }
//
//    for (y in 0 until height) {
//        for (x in 0 until width) {
//            var node = tree
//            while (node.symbol == null) {
//                node = if (bitStream.read() == 0) node.left!! else node.right!!
//            }
//            image[y][x] = node.symbol
//        }
//    }
//
//    return image
//}
//
//class BitInputStream(private val input: InputStream) {
//    private var buffer = 0
//    private var bufferSize = 0
//
//    fun read(): Int {
//        if (bufferSize == 0) {
//            buffer = input.read()
//            bufferSize = 8
//        }
//        bufferSize--
//        return (buffer ushr bufferSize) and 1
//    }
//}
//
//class BitOutputStream(private val output: OutputStream) {
//    private var buffer = 0
//    private var bufferSize = 0
//
//    fun write(bit: Int) {
//        buffer = (buffer shl 1) or bit
//        bufferSize++
//        if (bufferSize == 8) {
//            output.write(buffer)
//            buffer = 0
//
