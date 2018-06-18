import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int[] coleccion, resultado;
        int rep;

        try
        {
            System.out.print("Introduce un número de repeticiones: ");
            rep = teclado.nextInt();

            resultado = Criba(Leer(teclado), rep);

            System.out.print(String.format("\nLos números que se repiten %d veces son: ", rep));

            for (int n : resultado)
                System.out.print(String.format("%d ", n));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int[] Leer(Scanner teclado) throws Exception
    {
        int num;
        int[] coleccion;

        System.out.println("Introduce una secuencia de números acabada en uno negativo:");

        System.out.print("Introduce un número: ");
        num = teclado.nextInt();

        if (num >= 0)
            coleccion = new int[] { num };
        else
            throw new Exception("La longitud del array debe ser superior a 0");

        do
        {
            System.out.print("Introduce un número: ");
            num = teclado.nextInt();

            if (num >= 0)
            {
                coleccion = Arrays.copyOf(coleccion, coleccion.length + 1);
                coleccion[coleccion.length - 1] = num;
            }
        }
        while (num >= 0);

        return coleccion;
    }

    private static int[] Criba(int[] coleccion, int x) throws Exception
    {
        int[] resultado = new int[0];
        int rep = 0;
        boolean existe = false;

        if (x < 1)
            throw new Exception("El número de repeticiones debe ser superior a 0");

        for (int i = 0; i < coleccion.length; i++)
        {
            rep = 0;
            existe = false;

            for (int j = 0; j < coleccion.length; j++)
                if (coleccion[j] == coleccion[i])
                    rep++;

            if (rep == x && resultado.length == 0)
                resultado = new int[] { coleccion[i] };
            else if (rep == x && resultado.length > 0)
            {
                for (int k = 0; k < resultado.length; k++)
                    if (resultado[k] == coleccion[i])
                        existe = true;

                if (!existe)
                {
                    resultado = Arrays.copyOf(resultado, resultado.length + 1);
                    resultado[resultado.length - 1] = coleccion[i];
                }
            }
        }

        return resultado;
    }
}
