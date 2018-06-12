import java.util.Scanner;

public class Ejercicio11
{
    public static void main(String[] args)
    {
        int n1, n2;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Cálculo del precio de un recibo de electricidad");
        System.out.println("===============================================");

        System.out.print("Introduce el penúltimo valor del contador: ");
        n1 = teclado.nextInt();

        System.out.print("Introduce el último valor del contador: ");
        n2 = teclado.nextInt();

        System.out.println("\nEl precio a pagar por el recibo es: " + CalcularPrecio(n1, n2) + " €");
    }

    private static double CalcularPrecio(int n1, int n2)
    {
        int consumo = n1 - n2;
        double resultado = 1;

        if (consumo == 0)
            return resultado;

        for (int i = 1; i <= consumo; i++)
        {
            if (i <= 100)
                resultado += 0.5;
            else if (i <= 250)
                resultado += 0.35;
            else
                resultado += 0.25;
        }

        resultado = Math.round(resultado * 100);

        return resultado / 100;
    }
}