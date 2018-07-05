import java.util.Scanner;

public class Ejercicio7
{
    public static void main(String[] args)
    {
        int num;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        num = teclado.nextInt();

        if (num < 0)
            System.out.println("El número es negativo");
        else if (num > 0)
            System.out.println("El número es positivo");
        else
            System.out.println("El número es cero");
    }
}
