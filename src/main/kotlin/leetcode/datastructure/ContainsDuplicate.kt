package leetcode.datastructure

/*
berdasarkan element pada index
jika index tidak sama dengan ukuran nums-1
jika index sama dengan index+1 pada nums
>kembali true
selain
>false
*/
fun containsDuplicate(nums: IntArray): Boolean {
    nums.forEachIndexed{ index,value ->
        if(index != nums.size-1){
            if (index == nums[index+1]){
                return true
            }
        }
    }
    return false
}

/*
membandingkan ukuran array
jika ukuran kedua tidak sama
Runtime 731 ms
Memory 72 MB
 */
fun containsDuplicate2(nums: IntArray): Boolean = (nums.size != nums.toSet().size)

/*
membandingkan ukuran array
jika kondisi perta
Runtime 777 ms / 471 ms
Memory 72 MB / 50.1 MB
 */
fun containsDuplicate3(nums: IntArray): Boolean = nums.size > nums.toSet().size

/*
membandingkan setiap elemen pada array
eleme pada array disimpan pada map, dan bernilai benar
jika map memiliki key dari elemen pada array
>kembali benar

Runtime 1168 ms
Memory 76.5 MB
 */
fun containsDuplicate4(nums: IntArray): Boolean {
    var result = mutableMapOf<Int,Boolean>()
    for(num in nums){
        print(num)
        if (result.containsKey(num)){
            return true
        }
        result[num] = true
    }
    return false
}

fun main(){
    val nums = intArrayOf(1,2,3,4,2,7,5,1)

    containsDuplicate4(nums)
}

