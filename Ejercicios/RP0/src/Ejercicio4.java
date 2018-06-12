import java.util.Scanner;

public class Ejercicio4
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int num, mb = 0, kb = 0, b = 0, i = 1;

        System.out.print("Introduce un número natural: ");
        num = teclado.nextInt();

        if (num <= 0)
        {
            System.out.println("El número introducido debe ser mayor que 0");
            return;
        }

        while (i <= num)
        {
            if (b < 1023)
                b++;
            else if (kb < 1023)
            {
                kb++;
                b = 0;
            }
            else
            {
                mb++;
                b = 0;
                kb = 0;
            }

            i++;
        }

        System.out.println(num + " B = " + mb + " MB + " + kb + " KB + " + b + " B");
    }
}
