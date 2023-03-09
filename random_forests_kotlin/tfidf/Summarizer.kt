package com.ml.quaterion.decisiontree.tfidf

import com.ml.quaterion.decisiontree.tfidf.stopword.docWords
import com.ml.quaterion.decisiontree.tfidf.stopword.docsWords
import kotlin.math.sqrt

class Summarizer {
    private val tokenizer = Tokenizer()
    fun compute(
        text : String,
        rate : Float
    ): Array<Int>{

        val sentences = tokenizer.paragraphSetentence( tokenizer.removeLineBreaks( text ) )
        val sentenceTokens = sentences.map { tokenizer.sentenceToToken( it ) }
        val tokensList = ArrayList<String>()

        sentenceTokens.forEach {
            tokensList.addAll( it )
        }

        val vocab = tokenizer.buildVocab(
            tokensList.toTypedArray()
        )
        val tfidfSumList = ArrayList<Float>()

        for (tokenizedSentence in sentenceTokens){
            val termFrequency = computeTermFrequency(
                tokenizedSentence,
                vocab
            )
            val inverseDocumentFrequency =
                computeInverseDocumentFrequency(
                    termFrequency,
                    docs = docsWords
                )
            val tfIDF = computeTFIDF(
                termFrequency,
                inverseDocumentFrequency
            )
            tfidfSumList.add(tfIDF.values.sum())
            println(
                "TF : $termFrequency"
            )
            println(
                "IDF : $inverseDocumentFrequency"
            )
            println(
                "TFIDF : $tfIDF"
            )
            println("==========")
        }

        docWords.forEach {docvalue ->

            val sentencesDoc = tokenizer.paragraphSetentence(
                tokenizer.removeLineBreaks(docvalue)
            )
            val sentenceTokensDoc = sentencesDoc.map { tokenizer.sentenceToToken( it ) }
            val tokensListDoc = ArrayList<String>()


            sentenceTokensDoc.forEach {
                tokensListDoc.addAll(it)
            }

            // Create a ( word , frequency ) vocab.
            val vocabDoc = tokenizer.buildVocab(
                tokensListDoc.toTypedArray()
            )

            for (docSetence in sentenceTokensDoc){

                val termFrequencyDoc = computeTermFrequency(
                    docSetence,
                    vocabDoc
                )
                val inverseDocumentFrequencyDoc =
                    computeInverseDocumentFrequency(
                        termFrequencyDoc,
                        docs = docsWords
                    )
                val tfIDFDoc = computeTFIDF(
                    termFrequencyDoc,
                    inverseDocumentFrequencyDoc
                )
                println(
                    "TF-DOC : $termFrequencyDoc"
                )
                println(
                    "IDF-Doc : $inverseDocumentFrequencyDoc"
                )
                println(
                    "TFIDF-doc : $tfIDFDoc"
                )
                println("==========")
            }
        }



        // Get the indices of top N maximum values from `weightedFreqSums`.
        val N = Math.floor((sentences.size * rate).toDouble()).toInt()
        val topNIndices = tokenizer.getTopNIndices(
            tfidfSumList.toTypedArray(),
            tfidfSumList.toTypedArray().apply{
                sort()
                reverse()
            },
            N
        )

        return topNIndices
    }

    private fun computeTermFrequency(
        s: Array<String>,
        vocab: HashMap<String,Int>
    ): HashMap<String, Float> {
        val freqMatrix = HashMap<String, Float>()
        for (word in vocab.keys) {
            freqMatrix[word] = 0f
        }
        for (word in s) {
            freqMatrix[word] = freqMatrix[word]!! + 1
        }
        val tfFreqMatrix = HashMap<String,Float>()
        for ((word, count) in freqMatrix) {
            tfFreqMatrix[word] = 1F // jika frekuensi hadir maka beri 1
        }
        return tfFreqMatrix
    }

    private fun computeInverseDocumentFrequency(
        freqMatrix : HashMap<String,Float>,
        docs : Array<Array<String>>
    ): HashMap<String,Float> {
        val freqInDocMap = HashMap<String,Float>()
        for(word in freqMatrix.keys ){
            freqInDocMap[word] = 0f
        }
        for (doc in docs){
            for(word in freqMatrix.keys ){
                if (doc.contains(word)){
                    freqInDocMap[ word ] = freqInDocMap[ word ]!! + 1f
                }
            }
        }
        val numDocs = docs.size.toFloat()
        val idfMap = HashMap<String,Float>()
        for ((word,freqInDoc) in freqInDocMap ){
            val freq = Math.log10(
                numDocs.toDouble() / freqInDoc.toDouble()
            ).toFloat()
            idfMap[word] = freq
//            println(
//                "calculationResultIDF : $word"
//            )
        }
        return idfMap
    }

    private fun computeTFIDF(
        tfMatrix : HashMap<String,Float> ,
        idfMatrix : HashMap<String,Float>
    ): HashMap<String,Float>{
        val tfidfMatrix = HashMap<String,Float>()
        for( word in tfMatrix.keys ){
            tfidfMatrix[word] = tfMatrix[ word ]!! * idfMatrix[ word ]!!
        }
        return tfidfMatrix
    }


    private fun cosineCalculation(
        tfresult : HashMap<String, Float>
    ){
        var cosineResult = HashMap<String,Float>()

        for ((keys,value) in tfresult){
            cosineResult[keys] = sqrt(value*value)
        }
    }
}