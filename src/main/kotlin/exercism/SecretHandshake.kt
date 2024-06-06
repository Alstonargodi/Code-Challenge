package exercism

import sun.misc.Signal

//object HandshakeCalculator {
//    fun calculateHandshake(number: Int): List<Signal> {
//        var n = number
//        val present = mutableListOf<Boolean>()
//
//        while (n > 0){
//            present += n.takeLowestOneBit() == 1
//            n = n shr 1 //bit count number of bits
//        }
//
//        val result = mutableListOf<Signal>()
//
//        //coerce at least Ensures that this value is not less than the specified minimumValue
//        present.subList(0,5.coerceAtMost(present.size)).forEachIndexed { index, present ->
//            if(present){
//                when(index){
////                    0 -> result.add(Signal.WINK)
////                    1 -> result.add(Signal.DOUBLE_BLINK)
////                    2 -> result.add(Signal.CLOSE_YOUR_EYES)
////                    3 -> result.add(Signal.JUMP)
////                    4 -> result.reverse()
//                }
//            }
//        }
//        return result
//    }
//}
