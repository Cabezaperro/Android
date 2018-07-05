import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(MayorMinimo(LeerSecuencia()));
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

        System.out.println("Introduce una secuencia de números enteros:");
        System.out.print("Introduce un número entero: ");
        num = teclado.nextInt();

        int[] numeros = { num };

        if (numeros[0] == 0)
            throw new Exception("La longitud del array debe ser superior a 0");

        do
        {
            System.out.print("Introduce un número entero: ");
            num = teclado.nextInt();

            if (num != 0)
            {
                numeros = Arrays.copyOf(numeros, numeros.length + 1);
                numeros[numeros.length - 1] = num;
            }
        }
        while(num != 0);

        return numeros;
    }

    private static int MayorMinimo(int[] a) throws Exception
    {
        int num;
        boolean iguales = true;

        if (a.length < 3)
            throw new Exception("El array no consta de suficientes valores");

        num = a[0];

        for (int n : a)
        {
            if (n != num)
                iguales = false;

            if (n < num)
                num = n;
        }

        if (iguales)
            throw new Exception("Todos los valores del array son iguales");

        for (int n : a)
            if (n > num)
            {
                num = n;
                break;
            }

        return num;
    }
}
