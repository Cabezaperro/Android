public class Ejercicio2
{
    public static void main(String[] args)
    {
        /* Expresión original:
        if (b)
        {
            x = true;
        }
        else
        {
            x = false;
        }
        */

        /* Expresión refactorizada:
        x = false;

        if (b)
            x = true;
        */
    }
}
