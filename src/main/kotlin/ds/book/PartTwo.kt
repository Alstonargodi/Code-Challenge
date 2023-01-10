package ds.book

class PartTwo {
    fun checkFirst(names : List<String>){
        if (names.firstOrNull() != null){
            print(names.first())
        }else{
            print("no names")
        }
    }
}

fun main(){
    val data = listOf("a","b","c")
    QuadtricTime().multiplicationBoard(100000)
}