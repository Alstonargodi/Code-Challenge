package compressionalgo

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.PriorityQueue
import java.util.HashMap

//data class Node(val symbol: Byte?, var weight: Int, var left: Node?, var right: Node?)
//
//fun buildFrequencyTable(data: ByteArray): HashMap<Byte, Int> {
//    val freqTable = HashMap<Byte, Int>()
//    for (byte in data) {
//        freqTable[byte] = freqTable.getOrDefault(byte, 0) + 1
//    }
//    return freqTable
//}
//
//fun buildHuffmanTree(freqTable: HashMap<Byte, Int>): Node {
//    val priorityQueue = PriorityQueue<Node>(Comparator.comparingInt { it.weight })
//    for ((symbol, weight) in freqTable) {
//        priorityQueue.offer(Node(symbol, weight, null, null))
//    }
//    while (priorityQueue.size > 1) {
//        val left = priorityQueue.poll()
//        val right = priorityQueue.poll()
//        val parent = Node(null, left.weight + right.weight, left, right)
//        priorityQueue.offer(parent)
//    }
//    return priorityQueue.poll()
//}
//
//fun buildCodeTable(huffmanTree: Node): HashMap<Byte, String> {
//    val codeTable = HashMap<Byte, String>()
//    fun traverse(node: Node, code: String) {
//        if (node.symbol != null) {
//            codeTable[node.symbol] = code
//            return
//        }
//        traverse(node.left!!, "$code" + "0")
//        traverse(node.right!!, "$code" + "1")
//    }
//    traverse(huffmanTree, "")
//    return codeTable
//}
//
//fun compress(inputFile: File, outputFile: File) {
//    val input: InputStream = FileInputStream(inputFile)
//    val output: OutputStream = FileOutputStream(outputFile)
//    val data = input.readBytes()
//    val freqTable = buildFrequencyTable(data)
//    val huffmanTree = buildHuffmanTree(freqTable)
//    val codeTable = buildCodeTable(huffmanTree)
//    output.write(freqTable.size)
//    freqTable.forEach { (symbol, freq) ->
//        output.write(symbol.toInt())
//        output.write(freq)
//    }
//    val stringBuilder = StringBuilder()
//    for (byte in data) {
//        stringBuilder.append(codeTable[byte])
//    }
//    while (stringBuilder.length % 8 != 0) {
//        stringBuilder.append('0')
//    }
//    val bytes = stringBuilder.toString().chunked(8)
//        .map { Integer.parseInt(it, 2).toByte() }
//        .toByteArray()
//    output.write(bytes)
//    input.close()
//    output.close()
//}
//
//fun decompress(inputFile: File, outputFile: File) {
//    val input: InputStream = FileInputStream(inputFile)
//    val output: OutputStream = FileOutputStream(outputFile)
//    val freqTableSize = input.read()
//    val freqTable = HashMap<Byte, Int>()
//    for (i in 0 until freqTableSize) {
//        val symbol = input.read().toByte()
//        val freq = input.read()
//        freqTable[symbol] = freq
//    }
//    val huffmanTree = buildHuffmanTree(freqTable)
//    var current = huffmanTree
//    val data = mutableListOf<Byte>()
//    while (true) {
//        val byte = input.read()
//        for (i in 7 downTo 0) {
//            if (byte and (1 shl i) != 0) {
//                current = current.right!!
//            } else {
//                current = current.left!!
//            }
//            if (current.symbol != null) {
//                data.add(current.symbol)
//                current = huffmanTree
//                if (data.size
