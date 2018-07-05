import java.util.Scanner;

public class Ejercicio3
{
    public static void main(String[] args)
    {
        int n1, n2, total;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Suma de números");
        System.out.println("===============");

        System.out.print("Introduce el primer número: ");
        n1 = teclado.nextInt();

        System.out.print("Introduce el segundo número: ");
        n2 = teclado.nextInt();

        total = n1 + n2;

        System.out.printf("\nLa suma de %d y %d es: %d%n", n1, n2, total);
    }
}