import java.util.*

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val scan = Scanner(System.`in`)
        val N = scan.nextInt()
        val Q = scan.nextInt()
        var lastAns = 0

        /* Create 2-D ArrayList */
        val lists = ArrayList<ArrayList<Int>>()
        for (i in 0 until N) {
            lists.add(ArrayList())
        }

        /* Perform Q Queries */for (i in 0 until Q) {
            val q = scan.nextInt()
            val x = scan.nextInt()
            val y = scan.nextInt()
            val seq = lists[(x xor lastAns) % N]
            if (q == 1) {
                seq.add(y)
            } else if (q == 2) {
                lastAns = seq[y % seq.size]
                println(lastAns)
            }
        }
        scan.close()
    }
}