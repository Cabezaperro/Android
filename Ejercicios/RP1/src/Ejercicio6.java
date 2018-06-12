import java.util.Locale;
import java.util.Scanner;

public class Ejercicio6
{
    public static void main(String[] args)
    {
        double numero;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Separación de las partes entera y decimal de un número real");
        System.out.println("===========================================================");

        teclado.useLocale(Locale.ENGLISH);

        System.out.print("Introduce un número real: ");
        numero = teclado.nextDouble();

        System.out.println("\nParte entera: " + separarParteEntera(numero));
        System.out.println("Parte decimal: " + separarParteDecimal(numero));
    }

    private static int separarParteEntera(double numero)
    {
        String num = Double.toString(numero);

        for (int i = 0; i < num.length(); i++)
            if (num.toCharArray()[i] == '.')
                return Integer.valueOf(num.substring(0, i));

        return Integer.valueOf(num);
    }

    private static int separarParteDecimal(double numero)
    {
        String num = Double.toString(numero);

        for (int i = 0; i < num.length(); i++)
            if (num.toCharArray()[i] == '.')
                return Integer.valueOf(num.substring(i + 1, num.length()));

        return 0;
    }
}
