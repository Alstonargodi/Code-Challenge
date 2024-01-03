package ds.hackerrank.problemsolving.timeconversion

fun main(){
   val time = timeConversion("07:05:45PM")
    println(time)
}
fun timeConversion(s: String): String {
    //07:05:45PM
    var hour = s.take(2).toInt()
    val amPm = s.takeLast(2)
    val middle = s.substring(2..7)

    //number and am pm checking
    if(hour == 12 && amPm == "AM"){
        hour = 0
    }
    if(hour < 12 && amPm == "PM"){
        hour += 12
    }

    //return char seq
    val strHour = hour.toString().padStart(2,'0')
    return strHour + middle
}