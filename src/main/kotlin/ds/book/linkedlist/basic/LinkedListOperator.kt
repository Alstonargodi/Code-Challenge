package ds.book.linkedlist.basic

fun main(){
    removeAfterOperation()
}

fun pushOperation(){
    /*
    Push operation
    chain push tail first
    0(1)
 */
    val list = LinkedListMain<Int>()
    list.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)
    print(list)
}

fun appendOperation(){
    /*
    Append operation
    chain list head first
    0(1)
 */
    val appendList = LinkedListMain<Int>()
    appendList.appendOperation(1)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(2)
        .appendOperation(3)
    print(appendList)
}

fun insertOperation(){
    /*
    insert operation
    0(1)
    nodeAt 0(index)
 */
    val insertList = LinkedListMain<Int>()
    insertList.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)
    print("before insert $insertList")
    var middleNode = insertList.nodeAt(1)
    for (i in 1..insertList.size){
        middleNode = middleNode?.let {
            insertList.insertOperation(
                value = -1 * i, //insert negatif
                afterNode = it
            )
        }
    }
    print("after insert $insertList")
}

fun popPushOperation(){
    //remove head 0(1)
    val list = LinkedListMain<Int>()
    list.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)
    print("push value :$list \n")
    val popValue = list.popOperation()
    print("after pop :$list \n")
    print("remove value: $popValue \n")
}


fun removeLastOperation(){
    //remove tail last 0(n)
    val listb = LinkedListMain<Int>()
    listb.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)
    print("push value :$listb \n")
    val popValue = listb.removeLast()
    print("after pop :$listb \n")
    print("remove value: $popValue \n")
}

fun removeAfterOperation(){
    //remove next node 0(1)
    val listc = LinkedListMain<Int>()
    listc.pushOperation(1)
        .pushOperation(2)
        .pushOperation(3)
        .pushOperation(4)
        .pushOperation(5)
        .pushOperation(6)
    print("removing at index :$listc \n")
    val index = 2
    val node = listc.nodeAt(index)
    val removeValue = node?.let { listc.removeAfter(it) }


    print("after remove :$listc \n")
    print("remove value: $removeValue \n")
}