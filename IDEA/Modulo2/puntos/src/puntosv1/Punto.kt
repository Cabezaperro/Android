package puntosv1

import kotlin.math.pow
import kotlin.math.sqrt

class Punto(a: Double, b: Double)
{
    private var x: Double
    private var y: Double

    init
    {
        x = a
        y = b
    }

    constructor(): this(0.0, 0.0)

    fun getX() = x
    fun getY() = y

    fun distancia(p: Punto): Double =
            sqrt((p.x - this.x).pow(2.0) + (p.y - this.y).pow(2.0))

    fun trasladar(a: Double, b: Double)
    {
        x += a
        y += b
    }

    override fun toString() = "($x, $y)"
}