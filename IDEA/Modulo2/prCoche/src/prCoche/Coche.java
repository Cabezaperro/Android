package prCoche;

public class Coche
{
    String nombre;
    double precio;
    static double PIVA = 0.16;

    public Coche(String nombre, double precio)
    {
        this.nombre = nombre;
        this.precio = precio;
    }

    public static void setPiva(double iva)
    {
        PIVA = iva;
    }

    public double precioTotal()
    {
        return precio + precio * PIVA;
    }

    @Override
    public String toString()
    {
        return nombre + " --> " + precioTotal();
    }
}
