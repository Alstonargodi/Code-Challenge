package Sorting

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
 * Complete the 'countSwaps' function below.
 *
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun countSwaps(a: Array<Int>): Unit {
    var asize = a.size
    var temp = 0
    var swap = 0
    for(i in 0 until asize-1){
        for(j in 0 until asize-i-1){
            if(a[j] > a[j+1]){
                temp = a[j]
                a[j] = a[j+1]
                a[j+1] = temp
                swap += 1
            }
        }
    }
    println("Array is sorted in $swap swaps.")
    println("First Element: " + a[0])
    println("Last Element: " + a[asize-1])
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    countSwaps(a)
}
