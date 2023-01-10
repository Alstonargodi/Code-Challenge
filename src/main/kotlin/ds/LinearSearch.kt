package ds

object LinearSearch {

    //linearly search
    //0(n)
    fun linearSearch(arr: IntArray, x: Int): Boolean{
        val n = arr.size
        for (i in 0 until n ){
            if (arr[i] == x){
                return true
            }
        }
        return false
    }

    //recursif search
    //0(n)
    fun linearRecursif(arr: IntArray,size : Int,key : Int): Boolean{
        if (size == 0 ){
            return false
        }else if(arr[size-1] == key){
            return true
        }else {
            return linearRecursif(arr, size - 1, key)
        }
    }
}

fun main(){
    val number = intArrayOf(2,3,4,10,40)
    val searchValue = 10

    val search = LinearSearch.linearRecursif(number,number.size,searchValue)
    if (search){
        print("found number")
    }else{
        print("not found")
    }
}