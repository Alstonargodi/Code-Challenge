package exercism.easy

//when approach 2 sec
object ScrambleScore {
    private fun scoreLetter(c: Char): Int {
        return when(c.uppercaseChar()){
            'A','E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1
            'D', 'G' -> 2
            'B', 'C', 'M', 'P'->3
            'F', 'H', 'V', 'W','Y' -> 4
            'K'->5
            'J','X'->8
            'Q','Z'->10
            else-> 0
        }
    }

    fun scoreWord(word: String): Int {
//        val wordList = word.toList()
//        var score = 0
//        wordList.sumOf { scoreLetter(it) }
        return word.sumOf {
            scoreLetter(it)
        }
    }
}

//map approach 5 second
object ScrambleScore2{

    //take more time to make map first
    private val wordMap =
        mapOf(
            1 to listOf('A','E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
            2 to listOf('D', 'G'),
            3 to listOf('B', 'C', 'M', 'P'),
            4 to listOf('F', 'H', 'V', 'W','Y'),
            5 to listOf('K'),
            8 to listOf('J','X'),
            10 to listOf('Q','Z')
        )
    private val lookUp = mutableMapOf<Char,Int>()
    init {
        wordMap.forEach { entry->
            entry.value.forEach { word ->
                lookUp.put(word,entry.key)
            }
        }
    }
    fun scoreWord(word: String) = word.sumOf {
        lookUp.getValue(it.uppercaseChar())
    }
}

fun main(){
    println(ScrambleScore.scoreWord("cabbage"))
}