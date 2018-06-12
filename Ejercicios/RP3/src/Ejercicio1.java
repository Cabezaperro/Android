public class Ejercicio1
{
    public static void main(String[] args)
    {
        /* Expresión original:
        if (b)
        {
            T;
            S;
        }
        else
        {
            T;
            U;
        }
        */

        /* Expresión refactorizada:
        T;

        if (b)
            S;
        else
            U;
        */
    }
}
