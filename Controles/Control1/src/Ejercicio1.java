import java.util.Scanner;

public class Ejercicio1
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int n1, n2;

        try
        {
            System.out.print("Introduce un multiplicando: ");
            n1 = teclado.nextInt();

            System.out.print("Introduce un multiplicador: ");
            n2 = teclado.nextInt();

            System.out.println("\nEl producto de los coeficientes es: " + operar(n1, n2));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
            return;
        }
    }

    private static int operar(int n1, int n2) throws Exception
    {
        int resultado = 0;

        if (n1 < 0 || n1 < 0)
            throw new Exception("Los números introducidos deben ser naturales");

        if (n1 == 0 || n2 == 0)
            return 0;

        do
        {
            if (n1 % 2 != 0)
                resultado += n2;

            n1 /= 2;
            n2 *= 2;
        }
        while (n1 >= 1);

        return resultado;
    }
}
