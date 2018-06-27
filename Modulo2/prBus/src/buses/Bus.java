package buses;

public class Bus implements Comparable<Bus>
{
    private int codBus;
    private String matricula;
    private int codLinea;

    public Bus(int codBus, String matricula)
    {
        this.codBus = codBus;
        this.matricula = matricula;
        codLinea = 0;
    }

    public int getCodBus() { return codBus; }

    public String getMatricula() { return matricula; }

    public int getCodLinea() { return codLinea; }

    public void setCodLinea(int codLinea) { this.codLinea = codLinea; }

    @Override
    public boolean equals(Object obj)
    {
        boolean esBus = obj instanceof Bus;
        Bus bus;

        if (!esBus)
            return false;

        bus = (Bus)obj;

        if (this.getCodBus() == bus.getCodBus() && this.getMatricula().equalsIgnoreCase(bus.getMatricula()))
            return true;

        return false;
    }

    @Override
    public int hashCode()
    {
        return Integer.hashCode(codBus) + matricula.toUpperCase().hashCode();
    }

    @Override
    public String toString()
    {
        return String.format("Bus(%d, %s, %d)", getCodBus(), getMatricula(), getCodLinea());
    }

    @Override
    public int compareTo(Bus bus)
    {
        int res = Integer.compare(codBus, bus.codBus);

        if (res == 0)
            res = matricula.compareToIgnoreCase(bus.matricula);

        return res;
    }
}
