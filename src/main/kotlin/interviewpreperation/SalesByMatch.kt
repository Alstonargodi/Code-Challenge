package interviewpreperation

import java.util.*

/*
 * Complete the 'sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */

fun sockMerchant(n: Int, ar: List<Int>): Int {
    // Write your code here
    Collections.sort(ar)
    var count = 0
    var j = 0
    while (j < ar.size - 1) {
        if (ar[j] === ar[j + 1]) {
            count++
            j++
        }
        j++
    }
    return count
}


fun sockMerchant(n: Int, ar: Array<Int>): Int {
    var listData = arrayListOf<Int>()
    var result = 1
    var a = 0
    ar.forEach {
        listData.add(it)
    }

    listData.sort()
    while (a < listData.size - 1){
        if (ar[a] === ar[a+1]){
            result++
            a++
        }
        a++
    }

    return result
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
