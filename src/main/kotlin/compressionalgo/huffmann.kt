package compressionalgo

import java.util.*

data class HuffmanNode(
    val char: Char?,
    val frequency: Int,
    val left: HuffmanNode?,
    val right: HuffmanNode?
)

fun buildHuffmanTree(text: String): HuffmanNode? {
    val frequencyMap = text.groupingBy { it }.eachCount()

    val priorityQueue = PriorityQueue<HuffmanNode>(
        frequencyMap.size,
        compareBy { it.frequency }
    )

    for ((char, frequency) in frequencyMap) {
        priorityQueue.add(HuffmanNode(char, frequency, null, null))
    }

    while (priorityQueue.size > 1) {
        val left = priorityQueue.poll()
        val right = priorityQueue.poll()

        val parent = HuffmanNode(
            null,
            left.frequency + right.frequency,
            left,
            right
        )

        priorityQueue.add(parent)
    }

    return priorityQueue.poll()
}

fun generateHuffmanCodes(root: HuffmanNode, prefix: String = ""): Map<Char, String> {
    if (root.char != null) {
        return mapOf(root.char to prefix)
    }

    val codes = mutableMapOf<Char, String>()

    if (root.left != null) {
        codes.putAll(generateHuffmanCodes(root.left, prefix + "0"))
    }

    if (root.right != null) {
        codes.putAll(generateHuffmanCodes(root.right, prefix + "1"))
    }

    return codes
}

fun compress(text: String, huffmanCodes: Map<Char, String>): String {
    return text.map { huffmanCodes[it] }.joinToString("")
}

fun decompress(bits: String, root: HuffmanNode): String {
    var node = root
    val result = StringBuilder()

    for (bit in bits) {
        node = if (bit == '0') node.left!! else node.right!!

        if (node.char != null) {
            result.append(node.char)
            node = root
        }
    }

    return result.toString()
}


fun main(){
    val text = "this is a test text his is a test text his is a test texthis is a test text"
    val tree = buildHuffmanTree(text)
    val codes = generateHuffmanCodes(tree!!)
    val compressed = compress(text, codes)
    val decompressed = decompress(compressed, tree)
    println("Original text: $text")
    println("Compressed text: $compressed")
    println("Decompressed text: $decompressed")
}

