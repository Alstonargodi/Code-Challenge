package compressionalgo

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.HashMap

//fun compress(inputFile: File, outputFile: File) {
//    val input: InputStream = FileInputStream(inputFile)
//    val output: OutputStream = FileOutputStream(outputFile)
//    val dictionary = HashMap<String, Int>()
//    for (i in 0..255) {
//        dictionary[i.toChar().toString()] = i
//    }
//    var code = 256
//    var current = ""
//    val buffer = mutableListOf<Int>()
//    while (true) {
//        val byte = input.read()
//        if (byte == -1) {
//            break
//        }
//        val next = current + byte.toChar()
//        if (dictionary.containsKey(next)) {
//            current = next
//        } else {
//            buffer.add(dictionary[current]!!)
//            dictionary[next] = code
//            code++
//            current = byte.toChar().toString()
//        }
//    }
//    if (current.isNotEmpty()) {
//        buffer.add(dictionary[current]!!)
//    }
//    for (value in buffer) {
//        output.write(value)
//    }
//    input.close()
//    output.close()
//}
//
//fun decompress(inputFile: File, outputFile: File) {
//    val input: InputStream = FileInputStream(inputFile)
//    val output: OutputStream = FileOutputStream(outputFile)
//    val dictionary = HashMap<Int, String>()
//    for (i in 0..255) {
//        dictionary[i] = i.toChar().toString()
//    }
//    var code = 256
//    var previous = ""
//    while (true) {
//        val value = input.read()
//        if (value == -1) {
//            break
//        }
//        val current: String
//        if (dictionary.containsKey(value)) {
//            current = dictionary[value]!!
//        } else if (value == code) {
//            current = previous + previous[0]
//        } else {
//            throw IllegalStateException("Invalid input file")
//        }
//        output.write(current.toByteArray())
//        dictionary[code] = previous + current[0]
//        code++
//        previous = current
//    }
//    input.close()
//    output.close()
//}
