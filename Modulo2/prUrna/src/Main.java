import prUrna.Urna;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            int nn = Integer.parseInt(args[0]);
            int nb = Integer.parseInt(args[1]);
            Urna u = new Urna(nn, nb);

            while (u.totalBolas() > 1)
            {
                Urna.ColorBola b1 = u.extraerBola();
                Urna.ColorBola b2 = u.extraerBola();

                if (b1 == b2)
                    u.ponerBlanca();
                else
                    u.ponerNegra();
            }

            System.out.println(u.extraerBola());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Uso: Main numeroBlancas numeroNegras");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Los argumentos deben ser numéricos");
        }
    }
}
