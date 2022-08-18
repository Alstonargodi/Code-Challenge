import java.util.*

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
