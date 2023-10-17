package problemsolving

import java.util.*


fun plusMinus(arr: Array<Int>) {
    /* Get size */
//    val scan = Scanner(System.`in`)
//    val size: Int = scan.nextInt()

    var value1 = 0
    var value2 = 0

//    solution 1
    /* Count instances of +/-/0 */
//    var positives = 0.0
//    var negatives = 0.0
//    var zeroes = 0.0
//    for (i in 0 until size) {
//        val value: Int = scan.nextInt()
//        if (value > 0) {
//            positives++
//        } else if (value < 0) {
//            negatives++
//        } else {
//            zeroes++
//        }
//    }
//    scan.close()

    //solution 2
    value1 = arr.count{ it > 0}
    value2 = arr.count { it < 0 }
    val zero = arr.count { it == 0 }

    /* Print ratios */
//    println(positives / size)
//    println(negatives / size)
//    println(zeroes / size)

    //formating
    val arrSize = arr.size.toDouble()
    println("%.6f".format(value1/arrSize))
    println("%.6f".format(value2/arrSize))
    println("%.6f".format(zero/arrSize))
}

fun main(){

}