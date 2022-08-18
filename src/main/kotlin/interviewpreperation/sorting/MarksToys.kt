import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'maximumToys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY prices
 *  2. INTEGER k
 */

fun maximumToys(prices: Array<Int>, k: Int): Int {
    var a = 0
    var choose = Int
    var cart = ArrayList<Int>()

    var hadiah = 0
    var uang = k
    Arrays.sort(prices)

    for(i in prices.indices){
        if(k>0 && prices[i] < uang ){
            uang -= prices[i]
            uang = uang
            hadiah++
        }
    }

    return hadiah
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val prices = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = maximumToys(prices, k)

    println(result)
}
