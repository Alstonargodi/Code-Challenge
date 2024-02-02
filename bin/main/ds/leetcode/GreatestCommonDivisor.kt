package ds.leetcode

import java.lang.StringBuilder

fun gcdOfStrings(str1: String, str2: String): String {
    var result = StringBuilder()

    var word1 = str1.toCharArray().toList()
    var word2 = str2.toCharArray().toList().distinct()

    for( i in 0 until word2.size){
        if(word1[i] === word2[i]){
            result.append(str2[i])
        }
    }
    println(result)
    return result.toString()
}

fun main(){
    gcdOfStrings("ABABAB","ABAB")
}