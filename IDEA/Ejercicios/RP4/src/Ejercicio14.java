import java.util.Scanner;

public class Ejercicio14
{
    public static void main(String[] args)
    {
        int num, maximo, smaximo, contador = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una secuencia de números (acabada en 0):");

        System.out.print("Introduce un número entero: ");
        num = teclado.nextInt();

        contador++;

        maximo = num;
        smaximo = num;

        while (num != 0)
        {
            System.out.print("Introduce un número entero: ");
            num = teclado.nextInt();

            if (num > maximo)
                maximo = num;

            if (num > smaximo && num < maximo)
                smaximo = num;

            contador++;
        }

        if (contador < 3)
        {
            System.out.println("No has introducido valores suficientes");
            return;
        }
        else if (maximo == smaximo)
        {
            System.out.println("Todos los valores introducidos son iguales");
            return;
        }

        System.out.println("\nEl valor máximo de la secuencia es: " + maximo);
        System.out.println("El segundo valor máximo de la secuencia es: " + smaximo);
    }
}
