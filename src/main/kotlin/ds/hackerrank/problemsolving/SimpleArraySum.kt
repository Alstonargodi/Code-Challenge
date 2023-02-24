package problemsolving

fun simpleArraySum(ar: Array<Int>): Int {
    var total = 0
    var com : IntArray
    for(i in 0 until ar.size){
        total = total + ar[i]
    }

    return total

}

fun main(args: Array<String>) {
    val arCount = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = simpleArraySum(ar)

    println(result)
}