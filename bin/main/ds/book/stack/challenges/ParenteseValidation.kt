package ds.book.stack.challenges

fun String.checkParanthes(): Boolean{
    val stack = StackOperator<Char>()
    for (chracter in this){
        when(chracter){
            '('-> stack.push(chracter)
            ')'->if (stack.isEmpty){
                return false
            }else{
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}

fun main(){
}