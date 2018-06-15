import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio7
{
    public static void main(String[] args)
    {
        int[] a;

        try
        {
            a = ContarOcurrencias(LeerSecuencia());

            System.out.println();
            ImprimirHistograma(a);
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int[] LeerSecuencia() throws Exception
    {
        Scanner teclado = new Scanner(System.in);
        int num;

        System.out.println("Introduce una secuencia de números entre 0 y 9 acabada en uno negativo:");
        System.out.print("Introduce un número: ");
        num = teclado.nextInt();

        if (num > 9)
            throw new Exception("El valor introducido es demasiado grande");

        int[] numeros = { num };

        if (numeros[0] < 0)
            throw new Exception("La longitud del array debe ser superior a 0");

        do
        {
            System.out.print("Introduce un número: ");
            num = teclado.nextInt();

            if (num > 9)
                throw new Exception("El valor introducido es demasiado grande");

            if (num >= 0)
            {
                numeros = Arrays.copyOf(numeros, numeros.length + 1);
                numeros[numeros.length - 1] = num;
            }
        }
        while(num >= 0);

        return numeros;
    }

    private static int[] ContarOcurrencias(int[] a)
    {
        int[] ocurrencias = new int[10];

        for (int i = 0; i < a.length; i++)
            ocurrencias[a[i]]++;

        return ocurrencias;
    }

    private static String ArrayAString(int[] a)
    {
        String array = "";

        for (int i = 0; i < a.length; i++)
            if (i == a.length - 1)
                array += String.format("%d: %d", i, a[i]);
            else
                array += String.format("%d: %d; ", i, a[i]);

        return array;
    }

    private static void ImprimirHistograma(int[] a)
    {
        int max = 0;

        for (int n : a)
            if (n > max)
                max = n;

        while (max > 0)
        {
            for (int j = 0; j < a.length; j++)
                if (a[j] < max)
                    System.out.print("  ");
                else
                    System.out.print("* ");

            System.out.println();
            max--;
        }

        for (int i = 0; i < a.length; i++)
            System.out.print(String.format("%d ", i));
    }
}