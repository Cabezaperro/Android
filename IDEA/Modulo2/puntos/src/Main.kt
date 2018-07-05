import puntosv1.Punto

fun main(args: Array<String>)
    {
        val p = Punto(3.0, 5.0)
        val q = Punto()

        p.trasladar(2.0, 1.0)

        println(p)
        println(p.getX())
        println(q)
    }