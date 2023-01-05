package problemsolving

/*
 * Complete the 'diagonalDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var result = 0
    /*
    var arrA1 = arr[0][0]
    var arrA2 = arr[1][1]
    var arrA3 = arr[2][2]

    var arrB1 = arr[2][0]
    var arrB2 = arr[1][1]
    var arrB3 = arr[0][2]


    var sumA = arrA1 + arrA2 + arrA3
    var sumB = arrB1 + arrB2 + arrB3
     */

    var hasila = 0
    var hasilb = 0
    var n = arr.size
    for (i in 0 until arr.size){
        hasila += arr[i][i]
        hasilb += arr[i][n-1-i]
    }

    result = Math.abs(hasila-hasilb)

    return result
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}