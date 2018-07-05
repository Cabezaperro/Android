import java.util.Scanner;

public class Ejercicio4
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int num, pos;

        try
        {
            System.out.print("Introduce un número positivo: ");
            num = teclado.nextInt();

            System.out.print("Introduce la posición del dígito buscado: ");
            pos = teclado.nextInt();

            System.out.println("\nEl dígito encontrado en la posición " + pos + " es: " + hallarDigito(num, pos));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int hallarDigito(int num, int pos) throws Exception
    {
        int digitos = 0, n = num;

        if (num <= 0 || pos <= 0)
            throw new Exception("Los dos números deben ser positivos");

        while (n > 0)
        {
            digitos++;
            n /= 10;
        }

        if (pos > digitos)
            return -1;

        n = num;

        for (int i = digitos; i > pos; i--)
            n /= 10;

        return n % 10;
    }
}
