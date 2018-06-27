package buses;

public class EnMatricula implements Criterio
{
    private String dato;

    public EnMatricula(String dato)
    {
        this.dato = dato;
    }

    @Override
    public boolean esSeleccionable(Bus bus)
    {
        return bus.getMatricula().toUpperCase().contains(dato.toUpperCase());
    }

    @Override
    public String toString()
    {
        return "Autobuses cuya matrícula contiene " + dato;
    }
}
