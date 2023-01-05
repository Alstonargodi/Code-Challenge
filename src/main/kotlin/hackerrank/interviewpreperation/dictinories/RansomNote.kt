package interviewpreperation.dictinories

class RansomNote {
    fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
        val magazineWord = magazine.groupingBy { it }.eachCount()
        //one two three four five six seven eight nine ten

        //o = 1 t = 4 f = 2  s = 2 e = 1 n =1

        note.groupingBy { it }.eachCount().forEach {
            if (magazineWord.getOrDefault(it.key, 0) < it.value) {
                return println("No")
            }
        }
        return print("Yes")
    }

    fun main(args: Array<String>) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val m = first_multiple_input[0].toInt()

        val n = first_multiple_input[1].toInt()

        val magazine = readLine()!!.trimEnd().split(" ").toTypedArray()

        val note = readLine()!!.trimEnd().split(" ").toTypedArray()

        checkMagazine(magazine, note)
    }

}