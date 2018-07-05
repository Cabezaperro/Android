import java.util.Scanner;

public class Ejercicio15
{
    public static void main(String[] args)
    {
        final int nBuscado = 12;
        int num, posIni = 0, posFin = 0, contador = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una secuencia de números (acabada en 0):");

        do
        {
            System.out.print("Introduce un número entero: ");
            num = teclado.nextInt();

            contador++;

            if (num == nBuscado && posIni == 0)
                posIni = contador;

            if (num == nBuscado && contador > posFin)
                posFin = contador;
        }
        while (num != 0);

        if (posIni == 0)
        {
            System.out.println("Número " + nBuscado + " no encontrado en la secuencia");
            return;
        }

        System.out.println("Posición de la primera ocurrencia del número " + nBuscado + ": " + posIni);
        System.out.println("Posición de la última ocurrencia del número " + nBuscado + ": " + posFin);
    }
}
