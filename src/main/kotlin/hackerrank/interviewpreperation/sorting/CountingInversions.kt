package interviewpreperation.sorting

class CountingInversions {
    fun countInversions(arr: Array<Int>): Long {
        // Write your code here
        var longNumber : Long = 0
        val intList = arr.copyOf()
//    arr.forEach { intList.add(it) }
//    intList.sort()

//    var a = 0
//    for (i in 0 until arr.size){
//        if (i > 1){
//            if (i != arr.size){
//                if (intList[i] <= intList[i+1]){
//                    intList[i] = intList[i+1]
//                    a++
//                }else{
//                    a++
//                }
//            }
//        }else{
//            a = 0
//        }
//    }
//
//    longNumber = a.toLong()

        fun merge(
            arrSort : Array<Int>,
            arrSrc : Array<Int>,
            a : Int,
            b : Int,
            c : Int
        ): Unit{
            var l = a
            var r = b
            var origin = a

            while (l < b && r < c){
                if (arrSrc[l] <= arrSrc[r]){
                    arrSort[origin++] = arrSrc[l++]
                }else{
                    arrSort[origin++] = arrSrc[r++]
                    longNumber += b - l
                }
            }

            while (l < b) arrSort[origin++] = arrSrc[l++]
            while (r < c) arrSort[origin++] = arrSrc[r++]
        }

        var interation = 0
        fun mergeSort(iL : Int,iR : Int): Unit{
            if (iR-iL < 2)
                return
            val iM = iL + ( iR - iL) / 2

            interation++
            mergeSort(iL,iM)
            mergeSort(iM,iR)
            interation--

            if (interation.rem(2) == 0){
                merge(arr,intList,iL,iM,iR)
            }else{
                merge(intList,arr,iL,iM,iR)
            }
        }

        mergeSort(0,arr.size)

        return longNumber
    }

    fun main(args: Array<String>) {
        val t = readLine()!!.trim().toInt()

        for (tItr in 1..t) {
            val n = readLine()!!.trim().toInt()

            val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

            val result = countInversions(arr)

            println(result)
        }
    }

}