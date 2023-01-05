package interviewpreperation.stringmanipulation

class MakeAnagram {
    fun makeAnagram(a: String, b: String): Int {
        // Write your code here
        var result = 0
        var match = 0
        val aChar = a.toCharArray()
        var bChar = b
        val amountB = bChar.length

        aChar.forEach {
            if (bChar.indexOf(it) != -1){
                bChar = bChar.replaceFirst(""+it,"")
                match++
            }else{
                result++
            }
        }

        result = result + amountB - match

        return result
    }

    fun main(args: Array<String>) {
        val a = readLine()!!

        val b = readLine()!!

        val res = makeAnagram(a, b)

        println(res)
    }
}