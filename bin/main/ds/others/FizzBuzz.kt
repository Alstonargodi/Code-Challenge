class FizzBuzz {
    fun fizzBuzz(n: Int): Unit {
        // Write your code here
        for(i in 1..n){
            if(i%15 == 0){
                print("FizzBuzz \n")
            }else if(i%5 == 0){
                print("Buzz \n")
            }else if(i%3 == 0){
                print("Fizz \n")
            }else{
                print("$i \n")
            }
        }
    }
}

fun main() {
//    val intArray = 1..100
//    intArray.forEach {
//        FizzBuzz().fizzBuzz(it)
//    }

    //one line
    print((1..100).map{it ->
        mapOf(
            0 to it,
            it % 3 to "Fizz",
            it % 5 to "Buzz",
            it % 15 to "FizzBuzz"
        )[0]
    })
}