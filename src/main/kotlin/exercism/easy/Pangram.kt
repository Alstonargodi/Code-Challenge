package exercism.easy

object Pangram {
    fun isPangram(input: String): Boolean {
        //check size input
//        var charCount = input
//            .replaceFirst(" ","")
//            .toList()
//            .size
//
//        val wordCount = 0
        val words = "abcdefghijklmnopqrstuvwxyz".split("")
        return input.toLowerCase().split("").containsAll(words) //check word contain
    }
}

fun main(){
    Pangram.isPangram("the quick brown fox jumps over the lazy dog")
}