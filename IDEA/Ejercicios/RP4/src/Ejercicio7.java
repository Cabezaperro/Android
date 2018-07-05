import java.util.Scanner;

public class Ejercicio7
{
    public static void main(String[] args)
    {
        int num;
        int contador = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número natural: ");
        num = teclado.nextInt();

        if (num <= 0)
        {
            System.out.println("Número no natural");
            return;
        }

        do
        {
            if ((num % 10) % 2 == 0)
                contador++;

            num /= 10;
        }
        while (num > 1);

        System.out.println("El número contiene " + contador + " dígitos pares");
    }
}
