import java.util.Scanner;

public class Ejercicio2
{
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args)
    {
        int[] numeros;
        int num;

        try
        {
            numeros = Leer();

            System.out.print("\nIntroduce el número a buscar: ");
            num = teclado.nextInt();

            System.out.println(String.format("El número %d%s ha sido encontrado en el array", num, Esta(num, numeros) ? "" : " no"));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static boolean Esta(int n, int[] numeros)
    {
        for (int num : numeros)
            if (num == n)
                return true;

        return false;
    }

    private static int[] Leer() throws Exception
    {
        int max;
        int[] numeros;

        System.out.print("Introduce la longitud del array: ");
        max = teclado.nextInt();

        if (max <= 0)
            throw new Exception("La longitud debe ser superior a 0");

        numeros = new int[max];

        System.out.println("Introduce una secuencia de " + max + " números:");

        for (int i = 0; i < max; i++)
        {
            System.out.print("\tIntroduce un número entero: ");
            numeros[i] = teclado.nextInt();
        }

        return numeros;
    }
}
