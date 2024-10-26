package exercism.easy

import com.sun.tools.javac.Main
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.sqrt

object CryptoSquare {

//    fun ciphertext(plaintext: String): String {
//        val filterText = plaintext.filter { it.isLetter() }
//        if (filterText.length == 56){
//            return filterText
//                .replace(" ","")
//        }else{
//            return filterText
//        }
//    }

    fun ciphertext(plaintext: String): String {
        return plaintext
            .normalizeText()
            .toRectangleMatrix()
            .transpose()
            .joinToString(" ")
    }

    private fun String.normalizeText() =
        this.lowercase().filter { it.isLetterOrDigit() }

    private fun String.toRectangleMatrix(): List<String>{
        val c = numberColumns(this)
        return this.chunked(c) { it.toString().padEnd(c,' ')}
    }


    private fun numberColumns(value : String) =
        maxOf(ceil(sqrt(value.length.toDouble())).toInt(),1)

    private fun List<String>.transpose(): List<String> =
        (this.elementAtOrElse(0){""}.indices).map { v ->
            (this.indices).map { row ->
                this[row][v]
            }.joinToString("")
        }

}


fun Main(){
    CryptoSquare.ciphertext("If man was meant to stay on the ground, god would have given us roots.")
}