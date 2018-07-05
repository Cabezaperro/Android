import java.util.*

fun main(args: Array<String>)
{
    val TAM = 10
    var array = IntArray(TAM)

    println(String.format("La longitud de la mayor sub-sucesión es: ${MayorLongitud(LeerSecuencia(array))}"))
}

private fun LeerSecuencia(a: IntArray): IntArray
{
    var teclado = Scanner(System.`in`)

    println("Introduce una secuencia de números de longitud ${a.lastIndex + 1}:")

    for (i in 0 .. a.lastIndex)
    {
        print("Introduce un número: ")
        a[i] = teclado.nextInt()
    }

    return a
}

fun MayorLongitud(a: IntArray): Int
{
    var sucesion1 = 1
    var aux = 1

    for (i in 0 .. a.lastIndex)
        if (i > 0)
        {
            if (a[i] >= a[i - 1])
                sucesion1++
            else
                sucesion1 = 1

            if (sucesion1 > aux)
                aux = sucesion1
        }

    return aux
}