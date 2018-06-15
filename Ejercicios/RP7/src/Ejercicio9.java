import java.util.Scanner;

public class Ejercicio9
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int num, base;

        try
        {
            System.out.print("Introduce un número natural: ");
            num = teclado.nextInt();

            System.out.print("Introduce una base a la que convertir: ");
            base = teclado.nextInt();

            System.out.println('\n' + CambiarBase(num, base));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static String CambiarBase(int num, int base) throws Exception
    {
        int valor, i = 0;
        int[] valores = new int[50];
        String resultado = "";
        boolean leer = false;

        if (base < 2 || base > 9)
            throw new Exception("La base introducida no es válida");

        if (num == 0)
            return "0";

        valor = num;

        while (valor != 0 && i < valores.length)
        {
            valores[i++] = valor % base;
            valor /= base;
        }

        for (i = valores.length - 1; i >= 0; i--)
        {
            if (valores[i] != 0)
                leer = true;

            if (leer)
                resultado += valores[i];
        }

        return resultado;
    }
}
