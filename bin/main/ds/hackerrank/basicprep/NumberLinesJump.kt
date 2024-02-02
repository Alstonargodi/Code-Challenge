package ds.hackerrank.basicprep

import kotlin.math.abs

fun kangaroo(
    x1: Int,
    v1: Int,
    x2: Int,
    v2: Int
): String {
    // Write your code here
    var jump = if(v1 != v2){
        abs((x1-x2)/(v2-v1))
    }else{
        1
    }
    val k1 = x1 + jump * v1
    val k2 = x2 + jump * v2

    return if (k1 == k2) "yes" else "no"
}

fun main(){
    print(kangaroo(0,3,4,2))
}