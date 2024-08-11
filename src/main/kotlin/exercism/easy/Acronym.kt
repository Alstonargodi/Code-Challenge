package exercism.easy

class Acronym {
    fun generate(phrase: String) : String {
        return phrase.split("","-").joinToString("") {
            it.filter { char -> char.isLetter() }.take(1).toUpperCase()
        }
    }
}