import java.util.Scanner;

public class Ejercicio2
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int num;

        System.out.print("Introduce un número entero: ");
        num = teclado.nextInt();

        // Si no introducimos un número entero, se lanzará una excepción
        System.out.println("El número introducido es: " + num);
    }
}
