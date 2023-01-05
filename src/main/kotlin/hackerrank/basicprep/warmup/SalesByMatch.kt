fun sockMerchant(n: Int, ar: Array<Int>): Int {
    return ar.groupBy { it }
        .values
        .map { it.size/2 }
        .sum()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
