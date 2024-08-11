package exercism.easy

private fun Int.squared() = this * this

class Squares(private val value : Int){

    fun sumOfSquares() = 1.rangeTo(value).map(Int::squared).sum()

    fun squareOfSum() = 1.rangeTo(value).sum().squared()

    fun difference() = squareOfSum() - sumOfSquares()
}