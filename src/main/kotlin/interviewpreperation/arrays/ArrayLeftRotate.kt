package interviewpreperation

fun ArrayLeftRotate(a: Array<Int>, d: Int): Array<Int> {


    val array = a.copyOf()
    for((index,value) in a.withIndex()){
        array[findindex(d, index, a.size)] = value
    }
    return array
}

fun findindex (left : Int,currin : Int,arrSize: Int): Int{
    if(left > currin){
        return arrSize + (currin-left)
    }
    return currin-left
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = ArrayLeftRotate(a, d)

    println(result.joinToString(" "))
}
