import java.util.Scanner;

public class Ejercicio6
{
    public static void main(String[] args)
    {
        final int divisor = 8;
        int num;
        int suma = 0;
        Scanner teclado = new Scanner(System.in);

        do
        {
            System.out.print("Introduce una secuencia de números acabando en 0: ");
            num = teclado.nextInt();

            suma += num / divisor;
        }
        while (num != 0);

        System.out.println("Suma de restos al dividir los números por 8: " + suma);
    }
}
