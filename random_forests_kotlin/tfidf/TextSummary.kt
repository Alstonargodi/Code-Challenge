package com.ml.quaterion.decisiontree.tfidf

public class TextSummary {
    val tokenizer = Tokenizer()

    fun summarize(
        text : String,
        compressionRate : Float
    ): String{
        val setences = Tokenizer().paragraphSetentence(
            tokenizer.removeLineBreaks(text)
        )
        val sumarize = Summarizer()
        val result = sumarize.compute(text,compressionRate)
//        println(
//            "summaries $result"
//        )
        return buildString(setences,result)
    }

    private fun buildString(
        sentences : Array<String>,
        topNValues : Array<Int>
    ) : String {
        val stringBuilder = StringBuilder()
        for( n in topNValues ){
            stringBuilder.append( sentences[ n ] + " ." )
        }
        return stringBuilder.toString()
    }

    interface SummaryCallback {
        fun onSummaryProduced( summary : String )
    }

}