package ds.hackerrank.problemsolving.candle

fun birthdayCakeCandles(candles: Array<Int>): Int {
    // Write your code here find tallest
    var tallest = 0

    //solution 1
    tallest = candles.maxOf { it }
    return candles.count {
        it == tallest
    }

    //solution 2

}