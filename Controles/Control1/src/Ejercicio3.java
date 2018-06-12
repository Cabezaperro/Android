import java.util.Scanner;

public class Ejercicio3
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int num, n;

        try
        {
            System.out.print("Introduce un coeficiente natural: ");
            num = teclado.nextInt();

            System.out.print("Introduce el orden de la raíz: ");
            n = teclado.nextInt();

            System.out.println("\nLa raíz de orden " + n + " de " + num + " es: " + calcularRaiz(num, n));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int calcularRaiz(int coef, int orden) throws Exception
    {
        int resultado, i = 1;

        if (coef <= 0 || orden < 2)
            throw new Exception("Números introducidos no válidos");

        while (i < coef)
        {
            resultado = 1;

            for (int j = 0; j < orden; j++)
                resultado *= i;

            if (resultado > coef)
                return i - 1;
            else if (resultado == coef)
                return i;

            i++;
        }

        return -1;
    }
}
