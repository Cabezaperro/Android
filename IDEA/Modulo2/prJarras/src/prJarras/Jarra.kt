package prJarras

class Jarra(a: Int)
{
    private var capacidad: Int
    private var contenido: Int

    init
    {
        capacidad = a
        contenido = 0
    }

    fun getCapacidad() = capacidad
    fun getContenido() = contenido

    fun llenar() { contenido = capacidad }
    fun vaciar() { contenido = 0 }

    fun llenarDesde(a: Jarra)
    {
        var restantes = capacidad - contenido

        if (a.contenido > restantes)
        {
            contenido += restantes
            a.contenido -= restantes
        }
        else
        {
            contenido += a.contenido
            a.contenido = 0
        }
    }

    override fun toString() = "Capacidad: $capacidad, contenido: $contenido"
}