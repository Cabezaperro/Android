import java.util.Scanner;

public class Ejercicio8
{
    public static void main(String[] args)
    {
        long segundos;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Conversión de segundos a otras unidades horarias");
        System.out.println("================================================");

        System.out.print("Introduce un periodo de tiempo en segundos: ");
        segundos = teclado.nextLong();

        System.out.println('\n' + ConvertirAUnidadesHorarias(segundos));
    }

    private static String ConvertirAUnidadesHorarias(long s)
    {
        long semanas, dias, horas, minutos, segundos;

        segundos = s;

        minutos = segundos / 60;
        if (minutos > 0)
            segundos %= minutos;

        horas = minutos / 60;
        if (horas > 0)
            minutos %= horas;

        dias = horas / 24;
        if (dias > 0)
            horas %= dias;

        semanas = dias / 7;
        if (semanas > 0)
            dias %= semanas;

        return String.format(s + " segundos equivalen a " + semanas + " semanas, " + dias + " días, " + horas + " horas, " + minutos + " minutos y " + segundos + " segundos");
    }
}
