import java.util.Scanner;

public class Ejercicio3
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        String texto, principal = "", palabra = "", resultado = "";
        boolean prinCompleta = false;

        System.out.print("Introduce un texto acabado en \"FIN\": ");
        texto = teclado.next();

        do
        {
            for (int i = 0; i < texto.length(); i++)
            {
                if (!prinCompleta)
                {
                    if (texto.charAt(i) != ' ')
                        principal += texto.charAt(i);
                }
                else
                {
                    palabra = teclado.next();

                    for (int j = 0; j < principal.length(); j++)
                        if (principal.charAt(j) == palabra.charAt(0))
                        {
                            resultado += palabra + "\n";
                            break;
                        }
                }
            }
        }
        while (!palabra.equals("FIN"));

        System.out.print(resultado);
    }
}
