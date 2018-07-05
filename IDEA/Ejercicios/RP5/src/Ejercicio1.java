import java.util.Scanner;

public class Ejercicio1
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int altura;

        try
        {
            System.out.print("Introduce un valor para la altura de la pirámide: ");
            altura = teclado.nextInt();

            imprimirPiramide(altura);
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static void imprimirPiramide(int altura) throws Exception
    {
        int cont = 1, ancho = altura * 2;

        if (altura <= 0)
            throw new Exception("El valor de la altura debe ser positivo");

        System.out.println();

        for (int i = 0; i < altura; i++)
        {
            for (int j = ancho; j > 0; j--)
                System.out.print(' ');

            for (int j = 1; j <= cont / 2 + 1; j++)
                System.out.print(j);

            for (int j = cont / 2; j > 0; j--)
                System.out.print(j);

            System.out.println();
            ancho--;
            cont = cont + 2;
        }
    }
}
