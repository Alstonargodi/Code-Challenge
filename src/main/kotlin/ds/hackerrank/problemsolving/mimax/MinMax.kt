package ds.hackerrank.problemsolving.mimax

fun miniMaxSum(arr: Array<Int>): Unit {
    // Write your code here
    var maxArr = 0
    var minArr = Int.MAX_VALUE
    var sumArr = 0L


    //solution 1
    for(number in arr){
        sumArr += number
        if(number < minArr) minArr = number
        if (number > maxArr) maxArr = number
    }


    //solustion 2 functional
    minArr = arr.minOf { it }
    maxArr = arr.maxOf { it }
    sumArr = arr.map { it.toLong() }.sum()

    println("${sumArr - maxArr} ${sumArr-minArr}")
}