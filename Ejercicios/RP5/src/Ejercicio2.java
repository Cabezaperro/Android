import java.util.Scanner;

public class Ejercicio2
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int altura;

        try
        {
            System.out.print("Introduce un valor para la altura del rombo: ");
            altura = teclado.nextInt();

            imprimirRombo(altura);
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static void imprimirRombo(int altura) throws Exception
    {
        int cont = 1, ancho = altura * 2, mitad = altura / 2;

        if (altura <= 0)
            throw new Exception("El valor de la altura debe ser positivo");

        System.out.println();

        for (int i = 0; i < mitad + 1; i++)
        {
            for (int j = ancho; j > 0; j--)
                System.out.print(' ');

            for (int j = 0; j < cont; j++)
                System.out.print("* ");

            System.out.println();
            ancho--;
            cont++;
        }

        ancho = ancho + 2;
        cont = cont - 2;

        for (int i = 0; i < mitad; i++)
        {
            for (int j = 0; j < ancho; j++)
                System.out.print(' ');

            for (int j = cont; j > 0; j--)
                System.out.print("* ");

            System.out.println();

            ancho++;
            cont--;
        }
    }
}
