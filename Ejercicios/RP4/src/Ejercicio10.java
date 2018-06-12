import java.util.Scanner;

public class Ejercicio10
{
    public static void main(String[] args)
    {
        double num, pi, numerador = 2, denominador = 1;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número natural: ");
        num = teclado.nextInt();

        pi = 4;

        for (int i = 1; i <= num; i++)
        {
            if (i % 2 == 0)
                numerador += 2;
            else
                denominador += 2;

            pi *= numerador / denominador;
        }

        System.out.println("El valor aproximado de pi es: " + pi);
    }
}
