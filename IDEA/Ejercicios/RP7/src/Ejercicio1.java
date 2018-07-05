import java.util.Scanner;

public class Ejercicio1
{
    public static void main(String[] args)
    {
        final int max = 10;
        int[] numeros;

        try
        {
            numeros = Leer(max);
            System.out.println("\nEl valor máximo encontrado en el array introducido es: " + Mayor(numeros));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int[] Leer(int max)
    {
        Scanner teclado = new Scanner(System.in);
        int[] numeros = new int[max];

        System.out.println("Introduce una secuencia de " + max + " números:");

        for (int i = 0; i < max; i++)
        {
            System.out.print("Introduce un número entero: ");
            numeros[i] = teclado.nextInt();
        }

        return numeros;
    }

    private static int Mayor(int[] numeros) throws Exception
    {
        int num;

        if (numeros.length == 0)
            throw new Exception("La longitud del array debe ser al menos de un número");

        num = numeros[0];

        for (int i = 0; i < numeros.length; i++)
            if (numeros[i] > num)
                num = numeros[i];

        return num;
    }
}
