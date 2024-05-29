package exercism

data class Year(val year: Int) {

    // TODO: Implement proper constructor
    var isLeap: Boolean = year % 4 == 0 && year % 100 != 0 || year % 400 == 0
}
