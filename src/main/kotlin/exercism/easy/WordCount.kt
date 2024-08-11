package exercism.easy

import java.awt.SystemColor.text


object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
       //solustion one for text only
//        var result : MutableMap<String,Int> = mutableMapOf()
//        val trimText = phrase.trim()
//        trimText.toList().forEach {it->
//            val words = if (trimText.isEmpty()) 0
//            else trimText.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size
//            result.put(it.toString(),words)
//        }
//        return result

        //solustion two
        return phrase
            .split("[^\\w']+".toRegex())
            .map{ it.trim('\'')}
            .filter { it.isNotBlank() }
            .groupingBy { it.lowercase() }
            .eachCount()
    }


}