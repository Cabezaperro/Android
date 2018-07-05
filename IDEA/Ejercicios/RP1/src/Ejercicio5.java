import java.util.Locale;
import java.util.Scanner;

public class Ejercicio5
{
    public static void main(String[] args)
    {
        double velocidad, tiempo, distancia;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Cálculo de la distancia recorrida por un vehículo");
        System.out.println("=================================================");

        teclado.useLocale(Locale.ENGLISH);

        System.out.print("Introduce la velocidad en km/h: ");
        velocidad = teclado.nextDouble();

        System.out.print("Introduce el tiempo en minutos: ");
        tiempo = teclado.nextDouble();

        System.out.print("\nLa distancia recorrida por el vehículo será de " + calcular(velocidad, tiempo) + " m");
    }

    private static double calcular(double velocidad, double tiempo)
    {
        double vms = velocidad * 1000 / 3600;
        double tmin = tiempo * 60;

        return vms * tmin;
    }
}