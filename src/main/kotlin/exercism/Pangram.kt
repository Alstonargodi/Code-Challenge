package exercism

object Pangram {
    fun isPangram(input: String): Boolean {
        //check size input
        var charCount = input
            .replaceFirst(" ","")
            .toList()
            .size

        val wordCount = 0

        //count char exist
        for(i in input.indices){

        }

        return false
    }
}

fun main(){
    Pangram.isPangram("the quick brown fox jumps over the lazy dog")
}