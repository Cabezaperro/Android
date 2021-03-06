package prLibreria;

public class OfertaAutor implements OfertaFlex
{
    private String[] autores;
    private double porDescuento;

    public OfertaAutor(double pd, String[] autores)
    {
        porDescuento = pd;
        this.autores = autores;
    }

    @Override
    public double getDescuento(Libro libro)
    {
        int i = 0;

        while (i < autores.length && !libro.getAutor().equalsIgnoreCase(autores[i]))
            i++;

        return i < autores.length ? porDescuento : 0;
    }
}
