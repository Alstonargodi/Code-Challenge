package exercism.easy

object Hamming {
    fun compute(leftStrand: String, rightStrand: String): Int {
        var wordCount = 0
        var listLeftStrand = leftStrand.toList()
        var listRightStrand = rightStrand.toList()
        if(listLeftStrand.size != listRightStrand.size){
            throw IllegalArgumentException("left and right strands must be of equal length")
        }else{
            for(i in 0 until leftStrand.toList().size){
                if(leftStrand[i] != rightStrand[i]){
                    wordCount = wordCount + 1
                }
            }
        }

        return wordCount
    }
}

fun main(){
    print(Hamming.compute(
        leftStrand = "GAGCCTACTAACGGGAT",
        rightStrand = "CATCGTAATGACGGCCT"
    ))
}