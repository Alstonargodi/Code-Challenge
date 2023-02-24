package problemsolving

import java.util.*

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        /* Get size */
        val scan = Scanner(System.`in`)
        val size: Int = scan.nextInt()

        /* Count instances of +/-/0 */
        var positives = 0.0
        var negatives = 0.0
        var zeroes = 0.0
        for (i in 0 until size) {
            val value: Int = scan.nextInt()
            if (value > 0) {
                positives++
            } else if (value < 0) {
                negatives++
            } else {
                zeroes++
            }
        }
        scan.close()

        /* Print ratios */println(positives / size)
        println(negatives / size)
        println(zeroes / size)
    }
}