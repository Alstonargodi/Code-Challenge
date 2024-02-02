package ds.hackerrank.basicprep

fun AppleOrange(
    s: Int,
    t: Int,
    a: Int,
    b: Int,
    apples: IntArray,
    oranges: IntArray
) {
    var appleCount = 0
    var orangeCount = 0
    for(fruit in apples){
        if(a+fruit >= s && a+fruit <=t){
            appleCount++
        }
    }
    for (count in oranges){
        if(b+count >= s && b+count <=t){
            orangeCount++
        }
    }

    println(appleCount)
    println(orangeCount)
}

fun main(){
    AppleOrange(
        7,
        10,
        4,
        12,
        intArrayOf(1,2,3),
        intArrayOf(1,2,3),
    )
}