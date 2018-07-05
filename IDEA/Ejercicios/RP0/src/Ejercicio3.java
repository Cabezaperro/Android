import java.util.Scanner;

public class Ejercicio3
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        final double valorTeoria = 0.7;
        final double valorPractica = 0.3;
        double teoria, practica, notaFinal;

        System.out.print("Introduce la nota de la parte teórica: ");
        teoria = teclado.nextDouble();

        System.out.print("Introduce la nota de la parte práctica: ");
        practica = teclado.nextDouble();

        notaFinal = teoria * valorTeoria + practica * valorPractica;

        System.out.println("La nota final es: " + notaFinal);
    }
}
