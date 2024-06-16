package exercism

import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(val value : Int) {

    // TODO: Implement proper constructor
    fun onEarth(): Double = calculation(1.0)
    fun onMercury(): Double = calculation(0.2408467)
    fun onVenus(): Double = calculation(0.61519726)
    fun onMars(): Double = calculation(1.8808158)
    fun onJupiter(): Double = calculation(11.862615)
    fun onSaturn(): Double = calculation(29.447498)
    fun onUranus(): Double = calculation(84.016846)
    fun onNeptune(): Double = calculation(164.79132)

    private fun calculation(argument : Double): Double =
        ((((value/60)/60)/24)/(365.25 * argument)).round()
}

fun Double.round() =
    BigDecimal(this).setScale(2,RoundingMode.HALF_UP).toDouble()


