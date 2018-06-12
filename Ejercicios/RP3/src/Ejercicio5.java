import java.util.Scanner;

public class Ejercicio5
{
    public static void main(String[] args)
    {
        int num;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        num = teclado.nextInt();

        if (num % 3 == 0)
            System.out.println("El número es múltiplo de 3");
        if (num % 4 == 0)
            System.out.println("El número es múltiplo de 4");
        if (num % 5 == 0)
            System.out.println("El número es múltiplo de 5");
        if (num % 3 != 0 && num % 4 != 0 && num % 5 != 0)
            System.out.println("El número no es múltiplo de 3, 4 o 5");
    }
}
