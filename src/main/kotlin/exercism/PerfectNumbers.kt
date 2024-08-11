enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if(naturalNumber <= 0) throw throw RuntimeException()

    val factors = factorsNumber(naturalNumber).sum()
    
    return when {
        factors == naturalNumber -> Classification.PERFECT
        factors < naturalNumber -> Classification.DEFICIENT
        else -> Classification.ABUNDANT
    }
}

private fun factorsNumber(n : Int): Sequence<Int> = (1..n/2).asSequence().filter{ n % it == 0 }