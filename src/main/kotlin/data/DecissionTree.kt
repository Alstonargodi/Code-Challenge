package data

class DecissionTree {

    //find maximum
    private fun argMax(x : ArrayList<Double>): Int{
        var y = Double.NEGATIVE_INFINITY
        var index = 0
        for(i in 0 until x.count()){
            if (x[i] > y){
                y = x[i]
                index = i
            }
        }
        return index
    }

    private fun getFreq(x : ArrayList<String>): ArrayList<Int>{
        val counts = ArrayList<Int>()
        for ( i in x){
            counts.add( x.count { it == i })
        }
        return counts
    }

    private fun logbase2(x : Double): Double{
        return Math.log10(x) / Math.log10(2.0)
    }
}