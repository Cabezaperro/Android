import java.util.Scanner;

public class Ejercicio1
{
    private static final double TASA = 25.0;
    private static final double PRECIO_HORA = 60.0;

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        double horas,dias,total,neto;

        System.out.print("Introduzca las horas trabajadas: ");
        horas = teclado.nextDouble();

        System.out.print("Introduzca los dias trabajados: ");
        dias = teclado.nextDouble();

        total = horas * dias * PRECIO_HORA;
        neto = total - TASA;

        System.out.println("El valor total a pagar es: " + total);
        System.out.print("El valor neto a pagar es: " + neto);

        teclado.close();
    }
}