package problemsolving

fun aVeryBigSum(ar: Array<Long>): Long {
        var result : Long = 0

        for(i in 0 until ar.size){
            result = result + ar[i]
        }

        return result
}

fun main(args: Array<String>) {
    val arCount = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()

    val result = aVeryBigSum(ar)

    println(result)
}
