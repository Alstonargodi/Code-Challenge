package exercism
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(val gigaSecond : LocalDateTime) {

    // TODO: Implement proper constructor
    constructor(date : LocalDate) : this(date.atTime(0,0)) //start time

    val date: LocalDateTime = gigaSecond.plusSeconds(1000000000)
}
