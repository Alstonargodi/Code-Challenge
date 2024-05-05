package exercism

object Transpose {
    fun transpose(input: List<String>): List<String> {
        var rez : MutableList<String> = mutableListOf()
        input.forEachIndexed { index, s ->
            s.forEachIndexed{ i, c ->
                //Returns a char sequence with content of this char sequence padded
                if(rez.size <= i) rez.add(i,"".padEnd(index,' ')+c) //
                else rez.set(i,rez[i].padEnd(index,' ')+c)
            }
        }
        return rez
    }

}
