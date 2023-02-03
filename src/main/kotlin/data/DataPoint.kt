package data

data class DataPoint(
    val map : Map<String,Any>,
    val result : Boolean? = null
){
    val outlook : String by map
    val temperatur : String by map
    val humidty : String by map
    val wind : String by map
}
