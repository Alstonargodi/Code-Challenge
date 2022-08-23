import java.util.*
import kotlin.collections.ArrayList

fun hourglassSum(arr: Array<Array<Int>>): Int {
    // Write your code here
    var intList : ArrayList<Int> = arrayListOf()
    var maxSum = -64

    for(col in 0..4){
        for (row in 0..4){
            var sum = 0
            sum += arr[col][row]

            sum += arr[col][row+1]
            sum += arr[col][row+2]

            sum += arr[col+1][row+1]

            sum += arr[col+2][row]
            sum += arr[col+2][row+1]
            sum += arr[col+2][row+1]

            if (maxSum < sum){
                maxSum = sum
            }
        }
    }

    return maxSum

}

fun main(args: Array<String>) {

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
