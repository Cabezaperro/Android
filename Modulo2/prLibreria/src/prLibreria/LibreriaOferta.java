package prLibreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria
{
    private String[] autores;
    private double porDescuento;

    public LibreriaOferta(double pd, String[] autores)
    {
        this(TAM_DEFECTO, pd, autores);
    }

    public LibreriaOferta(int tam, double pd, String[] autores)
    {
        super(tam);
        setOferta(pd, autores);
    }

    public void setOferta(double pd, String[] autores)
    {
        porDescuento = pd;
        this.autores = autores;
    }

    public String[] getOferta()
    {
        return autores;
    }

    public double getDescuento()
    {
        return porDescuento;
    }

    @Override
    public void addLibro(String autor, String titulo, double pb)
    {
        Libro libro = null;

        if (esAutorEnOferta(autor))
            libro = new LibroEnOferta(autor, titulo, pb, porDescuento);
        else
            libro = new Libro(autor, titulo, pb);

        // ¿Cuál es el tipo estático y dinámico de Libro?
        addLibro(libro);
    }

    private boolean esAutorEnOferta(String autor)
    {
        int i = 0;

        while (i < autores.length && !autor.equalsIgnoreCase(autores[i]))
            i++;

        return i < autores.length;
    }

    @Override
    public String toString()
    {
        return porDescuento + "%" + Arrays.toString(autores) + super.toString();
    }
}
