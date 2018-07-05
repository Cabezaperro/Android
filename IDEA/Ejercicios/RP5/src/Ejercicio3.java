import java.util.Scanner;

public class Ejercicio3
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int num, iteraciones;

        try
        {
            System.out.print("Introduce un número: ");
            num = teclado.nextInt();

            System.out.print("Introduce el número de iteraciones: ");
            iteraciones = teclado.nextInt();

            aplicarConjeturaPalindromo(num, iteraciones);
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int hallarReverso(int num) throws Exception
    {
        int reverso = 0;

        if (num <= 0)
            throw new Exception("El número introducido debe ser positivo");

        while (num > 0)
        {
            reverso = reverso * 10 + num % 10;
            num /= 10;
        }

        return reverso;
    }

    private static void aplicarConjeturaPalindromo(int num, int iteraciones) throws Exception
    {
        int resultado, i = 0, n = num, reverso = hallarReverso(n);

        System.out.println();

        if (iteraciones <= 0)
        {
            System.out.println("El número de iteraciones debe ser mayor que 0");
            return;
        }

        if (reverso == n)
        {
            System.out.println("El número introducido ya es palíndromo");
            return;
        }

        do
        {
            resultado = n + reverso;
            System.out.println(n + " + " + reverso + " = " + resultado);

            n = resultado;
            reverso = hallarReverso(n);
            i++;
        }
        while (i < iteraciones && resultado != hallarReverso(resultado));

        if (resultado == hallarReverso(resultado))
            System.out.println("\nSÍ se cumple la Conjetura del Palíndromo. El resultado es: " + resultado);
        else
            System.out.println("\nTras " + iteraciones + " iteraciones, NO se cumple la Conjetura del Palíndromo");
    }
}
