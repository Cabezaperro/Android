package amigos;

class Pareja
{
    private Persona uno, otro;

    public Pareja(Persona uno, Persona otro)
    {
        this.uno = uno;
        this.otro = otro;
    }

    @Override
    public String toString()
    {
        return String.format("%s, %s", uno.getNombre(), otro.getNombre());
    }

    /**
     * Dos parejas son iguales si las personas que la forman son iguales.
     * Puede ser igual la primera con la primera y la segunda con la segunda
     * o la primera con la segunda y la segunda con la primera
     */
    @Override
    public boolean equals(Object o)
    {
        Pareja p = (Pareja)o;

        if (uno.getNombre().equalsIgnoreCase(p.uno.getNombre()) && otro.getNombre().equalsIgnoreCase(p.otro.getNombre()))
            return true;
        else if (uno.getNombre().equalsIgnoreCase(p.otro.getNombre()) && otro.getNombre().equalsIgnoreCase(p.uno.getNombre()))
            return true;

        return false;
    }

    @Override
    public int hashCode()
    {
        return uno.getNombre().toUpperCase().hashCode() + otro.getNombre().toUpperCase().hashCode();
    }
}

