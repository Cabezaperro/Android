package amigos;

class Persona implements Comparable<Persona>
{
    private String nombre;
    private Persona amigo;

    public Persona(String nombre)
    {
        this.nombre = nombre;
        amigo = null;
    }

    public String getNombre()
    {
        return nombre;
    }

    public Persona getAmigo()
    {
        return amigo;
    }

    public void setAmigo(Persona amigo)
    {
        this.amigo = amigo;
    }

    /**
     * Dos personas son iguales si lo son sus nombres independientemente
     * de la tipografía
     */
    @Override
    public boolean equals(Object o)
    {
        Persona p = (Persona)o;

        if (getNombre().equalsIgnoreCase(p.getNombre()))
            return true;

        return false;
    }

    @Override
    public int hashCode()
    {
        return getNombre().toUpperCase().hashCode();
    }

    /**
     * una persona es menos que otra si los es su nombre independientemente
     * de su tipografía
     */
    @Override
    public int compareTo(Persona p)
    {
        return getNombre().compareToIgnoreCase(p.getNombre());
    }

    @Override
    public String toString()
    {
        if (amigo == null)
            return String.format("%s --> sin amigo", nombre);

        return String.format("%s --> %s", getNombre(), getAmigo().getNombre());
    }

}
