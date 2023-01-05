package leetcode

fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = mutableMapOf<Int,Int>()
    nums.forEachIndexed{ index,value ->
        result[value]?.let{ indexV ->
            return intArrayOf(indexV,index)
        }
        result[target-value] = index
    }
    return intArrayOf()
}

fun twoSums(nums: IntArray, target: Int): IntArray {
    val result = mutableMapOf<Int,Int>()
    nums.forEachIndexed{ index,value ->
        result[value]?.let{ indexV ->
            return intArrayOf(indexV,index)
        }
        result[target-value] = index
    }
    return intArrayOf()
}
