package ds.book.linkedlist.challenge

fun <T: Comparable<T>>LinkedListChal<T>.mergedSorted(
    secondList: LinkedListChal<T>
): LinkedListChal<T>{
    if (this.isEmpty()) return secondList
    if (secondList.isEmpty()) return this
    val result = LinkedListChal<T>()

    var left = nodeAt(0)
    var right = secondList.nodeAt(0)

    //merging
    while (left != null && right != null){
        if (left.value < right.value){
            left = append(
                result,left
            )
        }else{
            right = append(
                result,right
            )
        }
    }

    while (left != null){
        left = append(
            result,left
        )
    }

    while (right != null){
        right = append(
            result,right
        )
    }
    return result
}

//add currenct node
private fun <T: Comparable<T>> append(
    result : LinkedListChal<T>,
    nodeChal: NodeChal<T>
): NodeChal<T>?{
    result.append(nodeChal.value)
    return nodeChal.next
}

fun main(){
    val firstList = LinkedListChal<Int>()
    firstList.push(4)
    firstList.push(3)
    firstList.push(2)
    firstList.push(1)

    val secondList = LinkedListChal<Int>()
    secondList.push(-4)
    secondList.push(-3)
    secondList.push(-2)
    secondList.push(-1)

    print("first : $firstList")
    print("second : $secondList")
    print("merged : ${firstList.mergedSorted(secondList)}")

}