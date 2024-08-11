package exercism.easy

data class Year(val year: Int) {

    // TODO: Implement proper constructor
    //never use in built function
    var isLeap: Boolean = year % 4 == 0 && year % 100 != 0 || year % 400 == 0

    //if expresion
    var isLeap2 : Boolean = if(year % 100 == 0) year % 400 == 0 else year % 4 == 0
}
