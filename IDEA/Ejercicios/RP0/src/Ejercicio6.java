import java.util.Scanner;

public class Ejercicio6
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int n1, n2, n3, resultado;

        System.out.print("Introduce el primer número: ");
        n1 = teclado.nextInt();

        resultado = n1;

        System.out.print("Introduce el segundo número: ");
        n2 = teclado.nextInt();

        if (n2 > resultado)
            resultado = n2;

        System.out.print("Introduce el tercer número: ");
        n3 = teclado.nextInt();

        if (n3 > resultado)
            resultado = n3;

        if (n1 == n2 || n1 == n3)
            System.out.println("\nNo existe un número mayor estricto");
        else
            System.out.println("\nEl número mayor estricto es: " + resultado);
    }
}
