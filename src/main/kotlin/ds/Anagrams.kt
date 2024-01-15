package ds

fun Anagrams(
    word1 : String,
    word2 : String,
): Boolean{
    //check length same
    if(word1.length != word2.length){
        return false
    }

    //character count
    val charCount = IntArray(26)

    //check word pattern
    for(i in word1.indices){
        charCount[word1[i]-'a']++
        charCount[word2[i]-'a']--
    }
    for(count in charCount){
        if(count != 0){
            return false
        }
    }
    return true
}


//silent listen
fun main(){
    val word1 = "listen"
    val word2 = "silent"

    if(Anagrams(word1,word2)){
        print("yes")
    }else{
        print("nos")
    }
}