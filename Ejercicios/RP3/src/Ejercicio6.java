import java.util.Scanner;

public class Ejercicio6
{
    public static void main(String[] args)
    {
        int cantidad;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el número de artículos a comprar: ");
        cantidad = teclado.nextInt();

        System.out.println("El precio total a pagar es: " + CalcularPrecio(cantidad));
    }

    private static int CalcularPrecio(int cantidad)
    {
        if (cantidad == 1)
            return 100;

        if (cantidad == 2)
            return cantidad * 95;

        if (cantidad == 3)
            return cantidad * 90;

        if (cantidad > 3)
            return cantidad * 85;

        return 0;
    }
}
