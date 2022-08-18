
fun twoStrings(s1: String, s2: String): String {
    // Write your code here
    val wordHas : MutableSet<Char> = s1.toHashSet()
    for (a in s2){
        if (wordHas.contains(a)){
            return "YES"
        }
    }
    return "NO"
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s1 = readLine()!!

        val s2 = readLine()!!

        val result = twoStrings(s1, s2)

        println(result)
    }
}
