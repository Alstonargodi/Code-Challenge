import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.util.*

class Solution {
    // Complete the triplets function below.
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
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val bufferedWriter = BufferedWriter(FileWriter(System.getenv("OUTPUT_PATH")))
        val lenaLenbLenc: Array<String> = Solution.scanner.nextLine().split(" ").toTypedArray()
        val lena = lenaLenbLenc[0].toInt()
        val lenb = lenaLenbLenc[1].toInt()
        val lenc = lenaLenbLenc[2].toInt()
        val arra = IntArray(lena)
        val arraItems: Array<String> = Solution.scanner.nextLine().split(" ").toTypedArray()
        Solution.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (i in 0 until lena) {
            val arraItem = arraItems[i].toInt()
            arra[i] = arraItem
        }
        val arrb = IntArray(lenb)
        val arrbItems: Array<String> = Solution.scanner.nextLine().split(" ").toTypedArray()
        Solution.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (i in 0 until lenb) {
            val arrbItem = arrbItems[i].toInt()
            arrb[i] = arrbItem
        }
        val arrc = IntArray(lenc)
        val arrcItems: Array<String> = Solution.scanner.nextLine().split(" ").toTypedArray()
        Solution.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (i in 0 until lenc) {
            val arrcItem = arrcItems[i].toInt()
            arrc[i] = arrcItem
        }
        val ans: Long = Solution.triplets(arra, arrb, arrc)
        bufferedWriter.write(ans.toString())
        bufferedWriter.newLine()
        bufferedWriter.close()
        Solution.scanner.close()
    }
}