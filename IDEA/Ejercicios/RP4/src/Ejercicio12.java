import java.util.Scanner;

public class Ejercicio12
{
    public static void main(String[] args)
    {
        final int numInicial;
        int num, minimo, maximo;
        double media;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        numInicial = teclado.nextInt();

        minimo = numInicial;
        maximo = numInicial;
        media = numInicial;

        for (int i = 1; i < numInicial; i++)
        {
            System.out.print("Introduce otro número: ");
            num = teclado.nextInt();

            if (num < minimo)
                minimo = num;

            if (num > maximo)
                maximo = num;

            media += num;
        }

        media /= numInicial;

        System.out.println("\nEl valor mínimo en la secuencia introducida es: " + minimo);
        System.out.println("El valor máximo en la secuencia introducida es: " + maximo);
        System.out.println("La media de los valores introducidos es: " + media);
    }
}
