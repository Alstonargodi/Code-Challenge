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
    fun main(args: Array<String>) {
        val n = readLine()!!.trim().toInt()
        fizzBuzz(n)
    }
}