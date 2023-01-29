package ds.book.complexcity

class ComparingTime {
    //o(n)

    //logic
    fun sumAmount(n : Int): Int{
        var result = 0
        for(i in 1..n){
            result += i
        }
        return result
    }

    //reduce
    fun sumReduce(n : Int): Int{
        return (1..n).reduce { sum, value -> sum + value }
    }
}

fun main(){
    print(ComparingTime().sumReduce(2))
}