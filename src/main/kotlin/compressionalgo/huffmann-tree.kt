package compressionalgo

import java.io.*
import java.util.*

//fun compressImage(inputFile: String, outputFile: String) {
//    // Read the input image data into a byte array
//    val input = File(inputFile)
//    val data = input.readBytes()
//
//    // Calculate the frequency of occurrence of each pixel value in the byte array
//    val freq = IntArray(256)
//    for (b in data) {
//        freq[b.toInt() and 0xFF]++
//    }
//
//    // Build a Huffman tree based on the frequency of each pixel value
//    val tree = buildHuffmanTree(freq)
//
//    // Generate a code table that maps each pixel value to its Huffman code
//    val codeTable = generateCodeTable(tree)
//
//    // Encode the input image using the Huffman code table
//    val encodedData = encode(data, codeTable)
//
//    // Write the compressed image data to a file
//    val output = File(outputFile)
//    output.writeBytes(encodedData)
//}
//
//fun buildHuffmanTree(freq: IntArray): Node {
//    // Create a priority queue to hold the nodes
//    val pq = PriorityQueue<Node>(256)
//
//    // Create a leaf node for each pixel value with a non-zero frequency
//    for (i in freq.indices) {
//        if (freq[i] > 0) {
//            pq.offer(Node(i.toByte(), freq[i]))
//        }
//    }
//
//    // Merge the two lowest-weight nodes into a new parent node until there is only one node left in the tree
//    while (pq.size > 1) {
//        val left = pq.poll()
//        val right = pq.poll()
//        pq.offer(Node(left, right))
//    }
//
//    // Return the root node of the Huffman tree
//    return pq.poll()
//}
//
//fun generateCodeTable(tree: Node): Map<Byte, String> {
//    val codeTable = mutableMapOf<Byte, String>()
//    generateCodeTable(tree, "", codeTable)
//    return codeTable
//}
//
//fun generateCodeTable(node: Node, code: String, codeTable: MutableMap<Byte, String>) {
//    if (node.isLeaf()) {
//        codeTable[node.value] = code
//    } else {
//        generateCodeTable(node.left, code + "0", codeTable)
//        generateCodeTable(node.right, code + "1", codeTable)
//    }
//}
//
//fun encode(data: ByteArray, codeTable: Map<Byte, String>): ByteArray {
//    val bitSet = BitSet()
//    var bitIndex = 0
//    for (b in data) {
//        val code = codeTable[b]
//        for (c in code!!) {
//            if (c == '1') {
//                bitSet.set(bitIndex)
//            }
//            bitIndex++
//        }
//    }
//    return bitSet.toByteArray()
//}
//
//class Node(val value: Byte, val weight: Int) : Comparable<Node> {
//    var left: Node? = null
//    var right: Node? = null
//
//    constructor(left: Node, right: Node) : this(0, left.weight + right.weight) {
//        this.left = left
//
//
//






//    Read the input image data into a byte array.
//    Calculate the frequency of occurrence of each pixel value in the byte array.
//    Build a Huffman tree based on the frequency of each pixel value. The most frequent pixel values should be at the top of the tree.
//    Generate a code table that maps each pixel value to its Huffman code.
//    Encode the input image using the Huffman code table. Replace each pixel value in the input image with its corresponding Huffman code.
//    Write the compressed image data to a file.