public class Ejercicio3
{
    public static void main(String[] args)
    {
        /* Expresión original:
        if (edad >= 65)
        {
            System.out.println("Jubilado");
        }
        else
        {
            if (edad < 18)
            {
                System.out.println("Menor de edad");
            }
            else
            {
                if ((edad >= 18) && (edad < 65))
                {
                    System.out.println("Activo");
                }
            }
        }
        */

        /* Expresión refactorizada:
        if (edad < 18)
            System.out.println("Menor de edad");
        else if (edad >= 65)
            System.out.println("Jubilado");
        else
            System.out.println("Activo");
        */
    }
}
