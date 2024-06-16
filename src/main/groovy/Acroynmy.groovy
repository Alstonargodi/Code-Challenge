class Acronym {
    static String abbreviate(String phrase) {
        phrase.toUpperCase()
                .replaceAll(/[^A-Z']/, " ")
                .tokenize()
                .collect{it->it[0]}
                .join("")
    }
}


def acro = Acronym.abbreviate("As Soon As Possible")
println(acro)
