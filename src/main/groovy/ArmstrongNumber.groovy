class ArmstrongNumber {

    static isArmstrongNumber(number) {
        def numberList = number.toString().toList().collect { it.toInteger() }
        def sizeList = numberList.size()
        def sum = numberList.collect{ it ** sizeList }.sum()
        return sum == number
    }

}