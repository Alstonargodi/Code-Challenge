package ds.book

class LogarithmaticTime {

    //sorted array
    //o(n)
    fun linearContains(value : Int,numbers: List<Int>): Boolean{
        for (element in numbers){
            if(element == value){
                return true
            }
        }
        return false
    }

    //check middle
    //0(log n)
    fun pseudoBinaryContains(value: Int,number : List<Int>): Boolean{
        if(number.isEmpty()) return false

        val middleIndex = number.size / 2

        if (value <= number[middleIndex]){
            for (index in 0..middleIndex){
                if(number[index] == value){
                    return true
                }
            }
        }else{
            for(index in middleIndex until number.size){
                if (number[index] == value){
                    return true
                }
            }
        }
        return false
    }
}

fun main(){
    val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
    print(LogarithmaticTime().linearContains(3,numbers))
    print(LogarithmaticTime().pseudoBinaryContains(3,numbers))
}