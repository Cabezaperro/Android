public class Ejercicio5
{
    public static void main(String[] args)
    {
        int[] numeros = { 4, 567, 3, 54, 32, 34, 76, 325, 3, 78, 8 };

        System.out.println("Array original: " + ArrayAString(numeros));
        System.out.println("Array invertido: " + ArrayAString(InvertirArray(numeros)));
    }

    private static int[] InvertirArray(int[] a)
    {
        int[] b = new int[a.length];
        int contador = 0;

        for (int i = a.length - 1; i >= 0; i--)
            b[contador++] = a[i];

        return b;
    }

    private static String ArrayAString(int[] a)
    {
        String array = "";

        for (int n : a)
            array += String.format("%d ", n);

        return array;
    }
}
