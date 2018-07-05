import java.util.Random;
import java.util.Scanner;

public class Ejercicio1
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        final int dim0 = 3, dim1 = 4;
        int[][] matriz = CrearMatriz(dim0, dim1);
        int num;

        try
        {
            System.out.print("Introduce un número a buscar en la matriz: ");
            num = teclado.nextInt();

            System.out.println(String.format("El número %d%s se ha encontrado en la matriz", num, Esta(num, matriz) ? "" : " no"));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int[][] CrearMatriz(int dim0, int dim1)
    {
        Random rnd = new Random();
        int[][] a = new int[dim0][dim1];

        for(int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                a[i][j] = rnd.nextInt(99) + 1;

        return a;
    }

    private static boolean Esta(int n, int[][] a)
    {
        boolean encontrado = false;

        for(int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] == n)
                    encontrado = true;

        return encontrado;
    }
}
