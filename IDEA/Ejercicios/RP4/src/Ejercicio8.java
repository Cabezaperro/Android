import java.util.Scanner;

public class Ejercicio8
{
    public static void main(String[] args)
    {
        int modelos;
        int precioTotal = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el número de modelos de coche: ");
        modelos = teclado.nextInt();

        for (int i = 1; i <= modelos; i++)
        {
            System.out.print("Precio del modelo " + i + ": ");
            precioTotal += teclado.nextInt();
        }

        System.out.println("\nLa media de los precios de los modelos es: " + precioTotal / modelos + " €");
    }
}
