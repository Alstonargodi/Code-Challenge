package interviewpreperation.stringmanipulation

import kotlin.math.abs

class Sherlock {
    fun isValid(s: String): String {
        val wordMap = HashMap<Char,Int>()

        for ( i in 0 until s.length step 1){
            if (wordMap.containsKey(s[i])){
                wordMap[s[i]] = wordMap[s[i]]!! + 1

            }else{
                wordMap[s[i]] = 1
            }
        }

        wordMap.values.sorted().let {
            return when {

                it[0] == 1 && it.subList(1,it.size).distinct().size == 1 -> "yesy"

                it.size >= 2 && it[0] == 1 && it[0] == 1 -> "no"
                else -> when(it.distinct().size){
                    1 -> "yes"
                    2 -> if (abs(it.distinct()[0]) - it.distinct()[1] == 1)
                        "yes"
                    else
                        "no"
                    else -> "NO"
                }
            }
        }



    }

    fun main(args: Array<String>) {
        val s = readLine()!!

        val result = isValid(s)

        println(result)
    }

}