package ds.leetcode

import java.lang.StringBuilder

//fun mergeAlternately(word1: String, word2: String): String {
//    val arrWord1 = word1
//        .replace(""," ")
//        .trim()
//        .toCharArray()
//        .toMutableList()
//    val arrWord2 = word2
//        .replace(""," ")
//        .toCharArray()
//        .toMutableList()
//
//    println(arrWord1)
//    print(arrWord2)
//    return word1
//}


fun mergeAlternately(word1: String, word2: String): String {
    val result = StringBuilder()

    //cek minimum length of array
    val minimumLength = minOf(word1.length,word2.length)

    //append word per index to string
    for (i in 0 until minimumLength){
        result.append(word1[i]).append(word2[i])
    }

    //check word length in case one not have same lenght
    return if(word1.length == word2.length){
        result.toString()
    }else if(word1.length > word2.length){
        result
            .append(word1.substring(minimumLength))
            .toString()
    }else{
        result
            .append(word2.substring(minimumLength))
            .toString()
    }

    // each char per index
//    word1.forEachIndexed { index, char ->
//        print(index)
//        result.append(char).append(word2[index])
//    }
//    println(result)
//    return result.toString()
}

fun main(){
    mergeAlternately("abc","pqr")
}