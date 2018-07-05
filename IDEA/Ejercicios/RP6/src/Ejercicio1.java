import java.util.Scanner;

public class Ejercicio1
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        String str;

        try
        {
            System.out.print("Introduce una cadena de texto: ");
            str = teclado.next();

            System.out.println(DesplazarASCII(str));
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static String DesplazarASCII(String str)
    {
        String resultado = "";

        for (int i = 0; i < str.length(); i++)
            resultado += (char)((int)str.charAt(i) + 1);

        return resultado;
    }
}
