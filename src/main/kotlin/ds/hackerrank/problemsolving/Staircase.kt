package ds.hackerrank.problemsolving

fun staircase(n: Int): Unit {
    // Write your code here
    for(i in 1..n){
        for(y in 1..n){
            val data = if((i+y) > n) '#' else ' '
            print(data)
        }
        println()
    }
}

fun main(){
    staircase(6)
}