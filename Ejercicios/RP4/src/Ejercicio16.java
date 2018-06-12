import java.util.Random;
import java.util.Scanner;

public class Ejercicio16
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int limInf, limSup, nBuscado, num, respuesta;
        Random rnd = new Random();

        System.out.print("Introduce un límite inferior: ");
        limInf = teclado.nextInt();

        System.out.print("Introduce un límite superior: ");
        limSup = teclado.nextInt();

        System.out.print("Introduce el número a buscar: ");
        nBuscado = teclado.nextInt();

        do
        {
            num = rnd.nextInt(limSup) + limInf;
            System.out.println(limInf + " - " + limSup);
            System.out.print("¿Es " + num + " el número?: ");
            respuesta = teclado.nextInt();

            if (respuesta != -1 && respuesta != 0 && respuesta != 1)
                continue;

            if (respuesta == -1)
                limSup = num;

            if (respuesta == 1)
                limInf = num + 1;
        }
        while (respuesta != 0);

        System.out.println("Ya era hora, Sherlock");
    }
}
