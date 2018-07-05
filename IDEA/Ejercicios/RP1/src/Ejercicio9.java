import java.util.Scanner;

public class Ejercicio9
{
    public static void main(String[] args)
    {
        // Creación de variables: lector por teclado, valores numéricos a emplear, y variable auxiliar
        Scanner teclado = new Scanner(System.in);
        int a = 6, b = 14;
        int auxiliar;

        // Impresión de los valores iniciales de a y b
        System.out.println("a vale " + a + " y b vale "+ b);

        // Intercambio de los valores de a y b mediante el uso de la variable auxiliar
        // 1. Asignación a la variable auxiliar del valor de a
        auxiliar = a;
        // 2. Transferencia del valor de a a b
        a = b;
        // 3. Asignación a b del antiguo valor de a
        b = auxiliar;

        // Impresión de los valores intercambiados de a y b
        System.out.println("a vale " + a + " y b vale "+ b);
        teclado.close();

        // El proceso anterior es análogo al siguiente:
        // Se suma a a el valor de b
        // a += b;
        // Como ahora a es igual a a + b, hallaremos el nuevo valor de b restando su valor original al nuevo valor de a
        // b = a - b
        // Por último, hallaremos el valor final de a restándole el valor de b
        // a = a - b
    }
}