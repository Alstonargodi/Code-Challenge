package ds.book

class SpaceComplexity {
    //0(n)
    //functional sort
    fun printSorted(numberList: List<Int>){
        val sorted = numberList.sorted()
        for(value in sorted){
            print(value)
            print(Int.MIN_VALUE)
        }
    }

    //space cosntraints
    fun sortedManual(numbers: List<Int>){
        if (numbers.isEmpty()) print("empty list")

        var currentCount = 0
        var minValue = Int.MIN_VALUE //store last printed value

        for(value in numbers){
            if(value == minValue){
                print(value)
                currentCount += 1
            }
        }

        //two loops = 1 0(1)
        while (currentCount < numbers.size){
            var currentValue = numbers.maxOf { it }

            for (value in numbers){
                if(value < currentValue && value > minValue){
                    currentValue = value
                }
            }

            for(value in numbers){
                if (value == currentValue){
                    print(value)
                    currentCount += 1
                }
            }
            minValue = currentValue
        }

    }
}

fun main(){
    SpaceComplexity().sortedManual(listOf(1,2,3,4,9,4,8,4,3,1))
}