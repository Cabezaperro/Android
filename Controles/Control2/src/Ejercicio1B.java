import java.util.Scanner;

public class Ejercicio1B
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int n, m;

        try
        {
            System.out.print("Introduce un límite inferior: ");
            n = teclado.nextInt();

            System.out.print("Introduce un límite superior: ");
            m = teclado.nextInt();

            System.out.println(String.format("\nLas parejas de números familia entre %d y %d son:", n, m));
            FamiliasIntervalo(n, m);
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

    private static void FamiliasIntervalo(int n, int m) throws Exception
    {
        if (n >= m)
            throw new Exception("n debe ser menor que m");

        for (int i = n; i <= m; i++)
            for (int j = n; j <= m ; j++)
                if (i < j && SonFamilia(i, j))
                    System.out.println(String.format("%d es familia de %d", i, j));
    }
}
