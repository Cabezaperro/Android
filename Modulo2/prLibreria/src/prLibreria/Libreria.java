package prLibreria;

import java.util.Arrays;

public class Libreria
{
    private Libro[] libros;
    private int numLibros;
    protected static final int TAM_DEFECTO = 10;

    public Libreria() { this(TAM_DEFECTO); }

    public Libreria(int tam)
    {
        libros = new Libro[tam];
        numLibros = 0;
    }

    public void addLibro(String autor, String titulo, double pb)
    {
        Libro libro = new Libro(autor, titulo, pb);
        int pos = posicionLibro(autor, titulo);

        if (pos < 0)
            addLibro(libro);
        else
            libros[pos] = libro;
    }

    protected void addLibro(Libro libro)
    {
        aseguraQueCabe();
        libros[numLibros++] = libro;
    }

    private void aseguraQueCabe()
    {
        if (numLibros == libros.length)
            libros = Arrays.copyOf(libros, libros.length * 2);
    }

    private int posicionLibro(String autor, String titulo)
    {
        for (int i = 0; i < numLibros; i++)
        {
            if (autor.equalsIgnoreCase(libros[i].getAutor()))
                if (titulo.equalsIgnoreCase(libros[i].getTitulo()))
                    return i;
        }

        return -1;
    }

    public void remLibro(String autor, String titulo)
    {
        int pos = posicionLibro(autor, titulo);

        if (pos >= 0)
        {
            for (int i = 0; i < numLibros - 1; i++)
                libros[i] = libros[i + 1];

            libros[--numLibros] = null;
        }
    }

    public double getPrecioBase(String autor, String titulo)
    {
        int pos = posicionLibro(autor, titulo);

        return pos < 0 ? 0 : libros[pos].getPrecioBase();
    }

    public double getPrecioFinal(String autor, String titulo)
    {
        int pos = posicionLibro(autor, titulo);

        return pos < 0 ? 0 : libros[pos].getPrecioFinal();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < numLibros; i++)
        {
            sb.append(libros[i]);

            if (i < numLibros - 1)
                sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }
}
