package ds.hackerrank.problemsolving.grandingstudent


fun main(){
    val result = gradingStudents(
        arrayOf(4, 73, 67, 38, 33)
    )
    print(result.joinToString())
}

fun gradingStudents(grades: Array<Int>): Array<Int> {
    /*
     grade 1 84 round to 84 (84-84 less than 3)
     grade 2 29 not round (less than 40)
     grade 3 57 do not round (60-57)
     */

    return grades.map{
        when{
            it < 38 -> it
            it % 5 == 3 -> it + 2
            it % 5 == 4 -> it +1
            else -> it
        }
    }.toTypedArray()

}