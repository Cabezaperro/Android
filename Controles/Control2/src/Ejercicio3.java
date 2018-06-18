import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3
{
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args)
    {
        String patron;
        String[] texto;

        try
        {
            System.out.print("Introduce un patrón: ");
            patron = teclado.next().toUpperCase();

            texto = Leer();
            BuscarPatron(patron, texto);
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static String[] Leer()
    {
        String[] palabras = new String[0];
        String texto;
        int cont = -1;

        System.out.print("Introduce un texto (FIN para terminar): ");

        do
        {
            texto = teclado.next();
            texto = texto.toUpperCase();

            palabras = Arrays.copyOf(palabras, palabras.length + 1);
            cont++;

            for (int i = 0; i < texto.length(); i++)
            {
                if (palabras[cont] == null)
                    palabras[cont] = "";

                if (texto.charAt(i) != ' ')
                    palabras[cont] += texto.charAt(i);
                else
                {
                    palabras = Arrays.copyOf(palabras, palabras.length + 1);
                    cont++;
                }
            }
        }
        while (!texto.equals("FIN"));

        return palabras;
    }

    private static void BuscarPatron(String patron, String[] texto)
    {
        int iOcurrencia;
        String palabra;


        for (int i = 0; i < texto.length; i++)
        {
            palabra = "";
            iOcurrencia = 0;

            for (int j = 0; j < texto[i].length(); j++)
            {
                for (int k = 0; k < patron.length(); k++)
                {
                    if (texto[i].charAt(j) == patron.charAt(k) && j >= iOcurrencia)
                    {
                        iOcurrencia = j;
                        palabra += patron.charAt(k);
                    }
                }

                if (palabra.equals(patron))
                {
                    System.out.println(texto[i]);
                    break;
                }
            }
        }
    }
}
