package com.ml.quaterion.decisiontree.tfidf

import com.ml.quaterion.decisiontree.tfidf.stopword.englishStopWords
import com.sun.jdi.FloatType
import java.util.regex.Pattern

class Tokenizer {

    fun paragraphSetentence(text: String): Array<String>{
        val text = text.trim()

        //regex checker
        val pattern = Pattern.compile(
            "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)",
            Pattern.MULTILINE or Pattern.COMMENTS
        )

        val matcher = pattern.matcher(text)
        val sentences = ArrayList<String>()
        while (matcher.find()){
            sentences.add(matcher.group())
        }
        println(
            "paragraph setence : $sentences"
        )
        return sentences.toTypedArray()
    }

    //return list tokens
    fun sentenceToToken(text : String): Array<String>{
        val setence = text.trim().toLowerCase()
        var tokens = setence.split(" ")
        tokens = tokens.map {
            Regex("[^A-Za-z0-9 ]").replace( it , "")
        }
        tokens = tokens.filter {//remove stop words
            !englishStopWords.contains( it.trim() )
        }
        tokens = tokens.filter {
            it.trim().isNotEmpty() and it.trim().isNotBlank()
        }
        println(
            "sentence to token : $tokens"
        )
        return tokens.toTypedArray()
    }

    fun buildVocab(words : Array<String>): HashMap<String,Int>{
        val sortedWoerds = words.toSet()
        val vocab = HashMap<String,Int>()
        for(word in sortedWoerds){
            vocab[word] = words.count {
                it.equals(word)
            }
        }
        println(
            "build vocab : $vocab"
        )
        return vocab
    }

    fun getWeightVocab(vocab : HashMap<String,Int>): HashMap<String,Float>{
        val maxFreq = vocab.values.maxOrNull()?.toFloat()!!
        val weightedFreqHashMap = HashMap<String,Float>()
        vocab.entries.forEach {
            weightedFreqHashMap.put(
                it.key,
                it.value.toFloat() / maxFreq
            )
        }
        return weightedFreqHashMap
    }

    // Removes \n and \r from the given String.
    fun removeLineBreaks( para : String ) : String {
        return para
            .replace("\n", " " )
            .replace("\r", " " )
    }

    // Checks if the compression rate lie in ( 0 , 1 ].
    fun checkRate( rate : Double ) : Boolean {
        return rate > 0.0 && rate <= 1.0
    }

    // Get the indices of top N maximum values in X.
    fun getTopNIndices( x : Array<Float> , xSorted : Array<Float> , N : Int ) : Array<Int> {
        val topN = xSorted.take( N )
        val topNIndices = ArrayList<Int>()
        for ( i in topN ) {
            topNIndices.add( x.indexOf( i ) )
        }
        topNIndices.sort()
        return topNIndices.distinct().toTypedArray()
    }

}