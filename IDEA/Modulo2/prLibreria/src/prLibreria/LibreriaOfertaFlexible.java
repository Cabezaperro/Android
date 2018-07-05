package prLibreria;

public class LibreriaOfertaFlexible extends Libreria
{
    private OfertaFlex ofertaFlexible;

    public LibreriaOfertaFlexible(OfertaFlex of)
    {
        this(TAM_DEFECTO, of);
    }

    public LibreriaOfertaFlexible(int tam, OfertaFlex of)
    {
        super(tam);
        ofertaFlexible = of;
    }

    public OfertaFlex getOfertaFlexible()
    {
        return ofertaFlexible;
    }

    public void setOfertaFlexible(OfertaFlex ofertaFlexible)
    {
        this.ofertaFlexible = ofertaFlexible;
    }

    @Override
    public void addLibro(String autor, String titulo, double precio)
    {
        Libro libro = new Libro(autor, titulo, precio);
        double pd = ofertaFlexible.getDescuento(libro);

        if (pd != 0)
            libro = new LibroEnOferta(autor, titulo, precio, pd);

        addLibro(libro);
    }
}
