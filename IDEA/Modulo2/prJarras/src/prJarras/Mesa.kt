package prJarras

class Mesa(a: Int, b: Int)
{
    private var jarraA: Jarra
    private var jarraB: Jarra

    init
    {
        jarraA = Jarra(a)
        jarraB = Jarra(b)
    }

    fun getContenido() = jarraA.getContenido() + jarraB.getContenido()

    fun llenarA() = jarraA.llenar()
    fun llenarB() = jarraB.llenar()

    fun vaciarA() = jarraA.vaciar()
    fun vaciarB() = jarraB.vaciar()

    fun volcarASobreB() = jarraB.llenarDesde(jarraA)
    fun volcarBSobreA() = jarraA.llenarDesde(jarraB)

    override fun toString() = "Jarra A = ($jarraA)\nJarra B = ($jarraB)"
}