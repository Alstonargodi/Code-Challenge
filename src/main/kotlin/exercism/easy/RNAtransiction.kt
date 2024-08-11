package exercism.easy

fun transcribeToRna(dna: String): String {
    var transcribedRNA : String = ""
    val RNAConversion : Map<Char,String> = mapOf('G' to "C",'C' to "G",'T' to "A",'A' to "U")

    for(letter in dna) transcribedRNA += RNAConversion[letter]

    return transcribedRNA
}
