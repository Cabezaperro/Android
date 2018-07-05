import java.util.Scanner;

public class Ejercicio8
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int n;

        try
        {
            System.out.print("Introduce un número positivo: ");
            n = teclado.nextInt();

            Eratostenes(InicializarArray(n));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int[] InicializarArray(int n)
    {
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++)
            a[i] = i + 1;

        return a;
    }

    private static void Eratostenes(int[] a)
    {
        a[0] = 0;

        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == 0)
                continue;

            for (int j = 0; j < a.length; j++)
            {
                if (a[j] == a[i])
                    continue;

                if (a[j] % a[i] == 0)
                    a[j] = 0;
            }
        }

        System.out.print("Números primos del 1 al " + a.length + ": ");

        for (int n : a)
            if (n != 0)
                System.out.print(String.format("%d ", n));
    }
}
