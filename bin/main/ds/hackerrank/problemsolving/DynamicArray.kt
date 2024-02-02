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
 * Complete the 'dynamicArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun dynamicArray(n: Int, queries: Array<Array<Int>>) {
    val scan  = Scanner(System.`in`)

    val a = scan.nextInt()
    val b = scan.nextInt()
    var lastanswer : Int = 0

    val data = ArrayList<ArrayList<Int>>()
    for(i in 0 until a){
        data.add(ArrayList())
    }

    for(i in 0 until b){
        val q = scan.nextInt()
        val x = scan.nextInt()
        val y = scan.nextInt()
        val sq = data[(x xor lastanswer)%a]
        if(q == 1){
            sq.add(y)
        }else if( q == 2){
            lastanswer = sq[y % sq.size]
            println(lastanswer)
        }
    }
    scan.close()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val q = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(3, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = dynamicArray(n, queries)

//    println(result.joinToString("\n"))
}
