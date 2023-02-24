package interviewpreperation.dictinories

class SherlockAnagrams {
    fun sherlockAndAnagrams(s: String): Int {
        // Write your code here
        val charWord = arrayListOf<Char>()
        var listString = mutableListOf<String>()
        var i = 0
        var j = 0


        for (i in s.indices){
            for (a in i+1 until s.length + 1){
                listString.add(i,s.substring(i,a))
                j++
            }
        }

        return listString.groupBy { it.length }
            .map {
                it.value.map { it.toCharArray().sorted().hashCode() }
            }
            .map {
                it.groupingBy { it }.eachCount()
            }
            .map {
                it.values.filter { it > 1 }
            }
            .map {
                it.map{
                    (it-1)*((it-1)+1)/2
                }.sum()
            }
            .sum()

    }

    fun main(args: Array<String>) {
        val q = readLine()!!.trim().toInt()

        for (qItr in 1..q) {
            val s = readLine()!!

            val result = sherlockAndAnagrams(s)

            println(result)
        }
    }

}