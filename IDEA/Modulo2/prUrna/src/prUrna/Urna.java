package prUrna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna
{
    public enum ColorBola { Blanca, Negra };
    Random rnd = new Random();
    int negras;
    int blancas;

    public Urna(int negras, int blancas)
    {
        if (negras < 0 || blancas < 0)
            throw new IllegalArgumentException();

        this.negras = negras;
        this.blancas = blancas;
    }

    public int totalBolas()
    {
        return negras + blancas;
    }

    public ColorBola extraerBola()
    {
        if (totalBolas() == 0)
            throw new NoSuchElementException();

        if (rnd.nextInt(totalBolas()) + 1 <= blancas)
        {
            blancas--;
            return ColorBola.Blanca;
        }
        else
        {
            negras--;
            return ColorBola.Negra;
        }
    }

    public void ponerBlanca()
    {
        blancas++;
    }

    public void ponerNegra()
    {
        negras++;
    }

    @Override
    public String toString()
    {
        return "Blancas: " + blancas + "; Negras: " + negras;
    }
}
