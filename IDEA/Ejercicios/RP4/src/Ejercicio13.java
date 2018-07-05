import java.util.Scanner;

public class Ejercicio13
{
    public static void main(String[] args)
    {
        int num, suma = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una secuencia de números (acabada en 0):");

        do
        {
            System.out.print("Introduce un número positivo: ");
            num = teclado.nextInt();

            if (esPrimo(num))
                suma += num;
        }
        while (num != 0);

        System.out.println("La suma de los números primos de la secuencia es: " + suma);
    }

    private static boolean esPrimo (int n)
    {
        if (n < 2)
            return false;

        if (n < 4)
            return true;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
