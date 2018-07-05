package prLibreria;

public class OfertaPrecio implements OfertaFlex
{
    private double porDescuento;
    private double umbralPrecio;

    public OfertaPrecio(double pd, double umbral)
    {
        porDescuento = pd;
        umbralPrecio = umbral;
    }

    @Override
    public double getDescuento(Libro libro)
    {
        return libro.getPrecioBase() >= umbralPrecio ? porDescuento : 0;
    }

    @Override
    public String toString()
    {
        return porDescuento + "% (" + umbralPrecio + ")";
    }
}
