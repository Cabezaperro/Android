public class Ejercicio4
{
    public static void main(String[] args)
    {
        double[] estaturas = { 1.55, 1.76, 1.63, 1.64, 1.58, 1.74, 1.67, 1.83, 1.57, 1.77, 1.85, 1.65 };

        try
        {
            System.out.println("La media de las estaturas de la clase es: " + Media(estaturas));
            System.out.println("\nEl número de alumnos de estatura mayor que la media es: " + MayorQueMedia(estaturas));
            System.out.println("El número de alumnos de estatura menor que la media es: " + MenorQueMedia(estaturas));
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static double Media(double[] estaturas)
    {
        double resultado = 0;

        for (double est : estaturas)
            resultado += est;

        return resultado / estaturas.length;
    }

    private static int MayorQueMedia(double[] estaturas)
    {
        int contador = 0;

        for (double est : estaturas)
            if (est > Media(estaturas))
                contador++;

        return contador;
    }

    private static int MenorQueMedia(double[] estaturas)
    {
        int contador = 0;

        for (double est : estaturas)
            if (est < Media(estaturas))
                contador++;

        return contador;
    }
}
