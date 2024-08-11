package exercism.easy//package exercism
//
//import java.awt.Color
//
//enum class Color{
//    white,black,yellow
//}
//
//object ResistorColorTrio {
//    fun text(vararg input: exercism.Color): String {
//        var ohm = input[0].ordinal * 10 + input[1].ordinal //ordinal function dari enum class
//        var zeroes = input[2].ordinal
//        var remainder = 0
//        while (true){
//            remainder = ohm % 10
//            if(remainder == 0){
//                ohm /= 10
//                zeroes++
//            }
//
//            else
//                break
//        }
//
//        val read = zeroes % 3
//        val thousand = zeroes / 3
//
//        if (read == 1) ohm *= 10
//        else if(read == 2) ohm *= 100
//
//        val unit = Unit.values()[thousand].toString()
//        return "$ohm ${unit.toLowerCase()}"
//    }
//}
