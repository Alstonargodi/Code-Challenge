package exercism.easy

fun translate(rna: String?): List<String>{
    if(rna == null) return emptyList()

    val proteins = mutableListOf<String>()
    for (codon in rna.chunkedSequence(3)){
        if(codon.length < 3)
            throw IllegalArgumentException("Invalid codon length")

        val protein = translateCodonToProtein(codon,"STOP")
        if(protein == "STOP") break
        proteins.add(protein)
    }
    return proteins
}


fun translateCodonToProtein(
    codon : String,
    stopCode: String
): String{
    return when(codon){
        "AUG" -> "Methionine"
        "UUU", "UUC" -> "Phenylalanine"
        "UUA", "UUG" -> "Leucine"
        "UCU", "UCC", "UCA", "UCG" -> "Serine"
        "UAU", "UAC" -> "Tyrosine"
        "UGU", "UGC" -> "Cysteine"
        "UGG" -> "Tryptophan"
        "UAA", "UAG", "UGA" -> stopCode
        else -> throw IllegalArgumentException()
    }
}