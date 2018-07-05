import java.util.Scanner;

public class Ejercicio5
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int num;

        try
        {
            System.out.print("Introduce un número positivo: ");
            num = teclado.nextInt();

            imprimirSumas(num);
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static int hallarNDigitos(int num)
    {
        int digitos = 0, n = num;

        while (n > 0)
        {
            digitos++;
            n /= 10;
        }

        return digitos;
    }

    private static int hallarDigito(int num, int pos) throws Exception
    {
        int digitos, n = num;

        if (num <= 0 || pos <= 0)
            throw new Exception("Número no válido");

        digitos = hallarNDigitos(n);

        if (pos > digitos)
            return -1;

        n = num;

        for (int i = digitos; i > pos; i--)
            n /= 10;

        return n % 10;
    }

    private static void imprimirSumas(int num) throws Exception
    {
        int d1, d2, suma, digitos = hallarNDigitos(num);

        if (num <= 0)
            throw new Exception("Número no válido");

        if (digitos < 2)
            throw new Exception("El número introducido no consta de suficientes dígitos");

        System.out.println();

        for (int i = 1; i <= digitos; i++)
        {
            if (i > digitos - i + 1)
                return;
            if (i == digitos - i + 1)
            {
                d1 = hallarDigito(num, i);
                System.out.println(d1);
            }
            else
            {
                d1 = hallarDigito(num, i);
                d2 = hallarDigito(num, digitos - i + 1);
                suma = d1 + d2;

                System.out.println(d1 + " + " + d2 + " = " + suma);
            }
        }
    }
}
