import java.io.BufferedWriter
import java.io.FileWriter
import java.util.*

class Solution {

    fun triplets(a: IntArray, b: IntArray, c: IntArray): Long {
        var distinct: Long = 0
        val distincta: IntArray = duplicates(a)
        val distinctb: IntArray = duplicates(b)
        val distinctc: IntArray = duplicates(c)
        Arrays.sort(distincta)
        Arrays.sort(distinctb)
        Arrays.sort(distinctc)
        for (q in distinctb) {
            val a1: Long = (getdisctint(distincta, q) + 1).toLong()
            val a2: Long = (getdisctint(distinctc, q) + 1).toLong()
            distinct += a1 * a2
        }
        return distinct
    }

    private fun duplicates(a: IntArray): IntArray {
        val set: MutableSet<Int> = HashSet()
        for (item in a) {
            set.add(item)
        }
        val len = set.size
        val result = IntArray(len)
        var i = 0
        for (item in set) {
            result[i++] = item
        }
        return result
    }

    fun getdisctint(distincta: IntArray, k: Int): Int {
        var low = 0
        var high = distincta.size - 1
        var cout = -1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (distincta[mid] <= k) {
                cout = mid
                low = mid + 1
            } else high = mid - 1
        }
        return cout
    }

    private val scanner = Scanner(System.`in`)

}