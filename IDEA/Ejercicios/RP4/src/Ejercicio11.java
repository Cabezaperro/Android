import java.util.Scanner;

public class Ejercicio11
{
    public static void main(String[] args)
    {
        int num;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número natural: ");
        num = teclado.nextInt();

        System.out.println("El número " + num + " de la progresión de Fibonacci es: " + fibonacci(num - 1));
    }

    private static int fibonacci(int n)
    {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
