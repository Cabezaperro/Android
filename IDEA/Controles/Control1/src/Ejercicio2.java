import java.util.Scanner;

public class Ejercicio2
{
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args)
    {
        int k;

        try
        {
            System.out.print("Introduce un número natural: ");
            k = teclado.nextInt();

            buscarImparesConsecutivos(k);
        }
        catch(Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static void buscarImparesConsecutivos(int k) throws Exception
    {
        int num, contador = 0;

        if (k <= 0)
            throw new Exception("El número introducido no es mayor que 0");

        System.out.println("\nA continuación, introduce una secuencia de números acabada en 0:");

        do
        {
            System.out.print("Introduce un número: ");
            num = teclado.nextInt();

            if (num % 2 == 0 && contador < k)
                contador = 0;
            else
                contador++;

            if (contador == k)
                break;
        }
        while (num != 0);

        if (contador >= k)
            System.out.println("\nLa secuencia contiene al menos " + k + " números impares consecutivos");
        else
            System.out.println("\nLa secuencia NO contiene al menos " + k + " números impares consecutivos");
    }
}
