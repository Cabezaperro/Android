import java.util.Scanner;

public class Ejercicio1A
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int a, b;

        try
        {
            System.out.print("Introduce un número natural a: ");
            a = teclado.nextInt();

            System.out.print("Introduce un número natural b: ");
            b = teclado.nextInt();

            System.out.println(String.format("\nLos números %d y %d%s son familia", a, b, SonFamilia(a, b) ? "" : " NO"));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static boolean SonFamilia(int a, int b) throws Exception
    {
        int divA = 0, divB = 0;

        if (a < 1 || b < 1)
            throw new Exception("Los números deben ser naturales");

        for (int i = 1; i < a; i++)
            if (a % i == 0)
                divA += i;

        for (int i = 1; i < b; i++)
            if (b % i == 0)
                divB += i;

        if (a != b && divA == b && divB == a)
            return true;

        return false;
    }
}
