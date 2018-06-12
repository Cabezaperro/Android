import java.util.Scanner;

public class Ejercicio10
{
    public static void main(String[] args)
    {
        int numBuscado;
        int num;
        boolean encontrado = false;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Búsqueda de un número en una secuencia");
        System.out.println("======================================");

        System.out.print("Introduce un número: ");
        numBuscado = teclado.nextInt();

        do
        {
            System.out.print("Introduce una secuencia de números acabando en 0: ");
            num = teclado.nextInt();

            if (num == numBuscado)
                encontrado = true;
        }
        while (!encontrado && num != 0);

        if (encontrado)
            System.out.println("Número " + numBuscado + " encontrado en la secuencia");
        else
            System.out.println("Número " + numBuscado + " no encontrado en la secuencia");
    }
}
