package com.ml.quaterion.decisiontree.tfidf

class Summarizer {
    private val tokenizer = Tokenizer()
    fun compute(
        text : String,
        rate : Double
    ): Array<Int>{

        // Check whether the rate lies in the given range.
        if ( !tokenizer.checkRate( rate ) ){
            throw Exception( "The compression rate must lie in the interval ( 0 , 1 ].")
        }

        // Get sentences from the text.
        val sentences = tokenizer.paragraphSetentence( tokenizer.removeLineBreaks( text ) )
        val sentenceTokens = sentences.map { tokenizer.sentenceToToken( it ) }
        val tokensList = ArrayList<String>()

        // Collect all the words present in the text.
        sentenceTokens.forEach {
            tokensList.addAll( it )
        }

        // Create a ( word , frequency ) vocab.
        val vocab = tokenizer.buildVocab(
            tokensList.toTypedArray()
        )
        val tfidfSumList = ArrayList<Float>()

        // For each sentence, calculate TF, IDF and then TFIDF. Take the sum of all TF-IDF scores for all words in the
        // sentence and append it to a list.
        for (tokenizedSentence in sentenceTokens){
            val termFrequency = computeTermFrequency(
                tokenizedSentence,
                vocab
            )
            val inverseDocumentFrequency =
                computeInverseDocumentFrequency(
                    termFrequency,
                    sentenceTokens.toTypedArray()
                )
            val tfIDF = computeTFIDF(
                termFrequency,
                inverseDocumentFrequency
            )
            tfidfSumList.add(tfIDF.values.sum())
            println(
                "termFrequency : $termFrequency"
            )
            println(
                "inverseDocumentFrequency : $inverseDocumentFrequency"
            )
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
        println(N.toString())
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
            freqMatrix[word] = freqMatrix[word]!! + 1f
        }
        val tfFreqMatrix = HashMap<String,Float>()
        for ((word, count) in freqMatrix) {
            tfFreqMatrix[word] = count / s.size.toFloat() // Calculation of TF
        }
        return tfFreqMatrix
    }

    private fun computeInverseDocumentFrequency(
        freqMatrix : HashMap<String,Float>,
        docs : Array<Array<String> >
    ): HashMap<String,Float> {
        val freqInDocMap = HashMap<String,Float>()
        for(word in freqMatrix.keys ){
            freqInDocMap[word] = 0f
        }
        for ( doc in docs ){
            for( word in freqMatrix.keys ){
                if ( doc.contains( word )){
                    freqInDocMap[ word ] = freqInDocMap[ word ]!! + 1f
                }
            }
        }
        val numDocs = docs.size.toFloat()
        val idfMap = HashMap<String,Float>()
        for ((word,freqInDoc) in freqInDocMap ){
            idfMap[word] = Math.log10(
                numDocs.toDouble() / freqInDoc.toDouble()
            ).toFloat()
        }
        return idfMap
    }

    // Calculate the final product of the TF and IDF scores.
    private fun computeTFIDF(
        tfMatrix : HashMap<String,Float> ,
        idfMatrix : HashMap<String,Float>
    ): HashMap<String,Float>{
        val tfidfMatrix = HashMap<String,Float>()
        for( word in tfMatrix.keys ){
            tfidfMatrix[word] = tfMatrix[ word ]!! * idfMatrix[ word ]!!
        }

        println(
            "TFIDF matrix : ${tfidfMatrix}"
        )
        return tfidfMatrix
    }
}