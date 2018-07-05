package prCoche;

public class CocheImportado extends Coche
{
    double homologacion;

    public CocheImportado(String nombre, double precio, double homologacion)
    {
        super(nombre, precio);
        this.homologacion = homologacion;
    }

    public double precioTotal()
    {
        return super.precioTotal() + homologacion;
    }
}
