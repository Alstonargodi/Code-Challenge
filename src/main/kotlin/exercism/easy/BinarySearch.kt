package exercism.easy

object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {

        //check if list is empty
        if (list.isEmpty()) { throw NoSuchElementException() }

        //split mid index in list
        val midIndex = list.size / 2
        val mid = list[midIndex]

        //item the number that we search
        return when {
            // when mid index small than item
            mid > item ->{
                val left = list.subList(0,midIndex)
                search(left,item)
            }
            // when mid index greater than item
            mid < item ->{
                val right = list.subList(midIndex + 1,list.size)
                (midIndex + 1) + search(right,item)
            }
            // when midindex same as item
            else -> midIndex
        }

    }
}