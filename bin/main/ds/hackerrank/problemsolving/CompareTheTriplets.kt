package problemsolving

fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    var comp : Array<Int> = arrayOf()
    var ali = 0
    var ber = 0

    for (i in 0 until a.size){
        for(j in 0 until b.size){
            var Avalue = a[i]
            var Bvalue = b[i]

            if (Avalue > Bvalue){
                ali = ali + 1
            }else if (Bvalue < Avalue){
                ber = ber + 1
            }else if(Avalue == Bvalue){
                ali = ali + 0
                ber = ber + 0
            }
            print(ali)
            comp.set(ali,ber)
        }
    }

    return comp
}

fun solve(a0: Int, a1: Int, a2: Int, b0: Int, b1: Int, b2: Int): IntArray? {
    // Complete this function
    val solve = intArrayOf(0, 0)
    val a = intArrayOf(a0, a1, a2)
    val b = intArrayOf(b0, b1, b2)
    for (i in 0..2) {
        if (a[i] > b[i]) solve[0] += 1
        if (a[i] < b[i]) solve[1] += 1
    }
    return solve
}


fun compareTriplets2(a: Array<Int>, b: Array<Int>): Array<Int> {
    //compare two element
    var scoreA = 0
    var scoreB = 0

//solution 1
//    if(a[0] > b[0]) scoreA += 1
//    if(a[0] < b[0]) scoreB += 1
//    if(a[1] > b[1]) scoreA += 1
//    if(a[1] < b[1]) scoreB += 1
//    if(a[2] > b[2]) scoreA += 1
//    if(a[2] < b[2]) scoreB += 1

// solution 2
    for (i in 0..2){
        if(a[i] > b[i]) scoreA += 1
        if(a[i] < b[i]) scoreB += 1
    }

//    solution 3
    scoreA = a.zip(b).count{
        it.first > it.second
    } //count element on array
    scoreB = a.zip(b).count{
        it.first < it.second
    }

    return arrayOf(scoreA,scoreB)

}


fun main(){
    var result = compareTriplets2(arrayOf(5,6,7), arrayOf(3,6,10))
    println(result[0])
    println(result[1])
}