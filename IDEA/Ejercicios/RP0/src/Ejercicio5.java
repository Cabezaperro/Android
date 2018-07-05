import java.util.Scanner;

public class Ejercicio5
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int n1, n2;

        System.out.print("Introduce un número entero n1: ");
        n1 = teclado.nextInt();

        System.out.print("Introduce un número entero n2: ");
        n2 = teclado.nextInt();

        System.out.println();

        System.out.println(String.format("n1 %ses divisible por n2", n1 % n2 == 0 ? "" : "no "));
        System.out.println(String.format("n2 %ses divisible por n1", n2 % n1 == 0 ? "" : "no "));
    }
}
