package InterviewPreparation

import java.io.*
import java.util.stream.Collectors
import java.util.stream.Stream


object Solution {
    // Complete the countTriplets function below.
    fun countTriplets(arr: List<Long>, r: Long): Long {
        val leftmap: MutableMap<Long, Long> = HashMap()
        val rightmap: MutableMap<Long, Long> = HashMap()
        for (item in arr) {
            rightmap[item] = rightmap.getOrDefault(item, 0L) + 1
        }
        var count: Long = 0
        for (i in arr.indices) {
            val midterms = arr[i]
            var c1: Long = 0
            var c3: Long = 0
            rightmap[midterms] = rightmap.getOrDefault(midterms, 0L) - 1
            if (leftmap.containsKey(midterms / r) && midterms % r == 0L) {
                c1 = leftmap[midterms / r]!!
            }
            if (rightmap.containsKey(midterms * r) && midterms % r == 0L) {
                c3 = rightmap[midterms * r]!!
            }
            count += c1 * c3
            leftmap[midterms] = leftmap.getOrDefault(midterms, 0L) + 1
        }
        return count
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val bufferedWriter = BufferedWriter(FileWriter(System.getenv("OUTPUT_PATH")))
        val nr = bufferedReader.readLine().replace("\\s+$".toRegex(), "").split(" ").toTypedArray()
        val n = nr[0].toInt()
        val r = nr[1].toLong()
        val arr = Stream.of(*bufferedReader.readLine().replace("\\s+$".toRegex(), "").split(" ").toTypedArray())
            .map { s: String -> s.toLong() }
            .collect(Collectors.toList())
        val ans = countTriplets(arr, r)
        bufferedWriter.write(ans.toString())
        bufferedWriter.newLine()
        bufferedReader.close()
        bufferedWriter.close()
    }
}
