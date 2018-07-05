import java.util.Scanner;

public class Ejercicio2
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        String str;

        try
        {
            System.out.print("Introduce un número: ");
            str = teclado.next();

            System.out.println(Integer.parseInt(str));
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
