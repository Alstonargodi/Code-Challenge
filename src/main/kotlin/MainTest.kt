

fun alternatingCharacters(s: String): Int {
    // Write your code here
    var result = 0
    for (i in 1 until s.length step 2){
        if (s[i] == s[i-1]){
            result++
        }
    }
    return result
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = alternatingCharacters(s)

        println(result)
    }
}
