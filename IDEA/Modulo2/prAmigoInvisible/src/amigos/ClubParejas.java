package amigos;

import java.io.*;
import java.util.*;

public class ClubParejas extends Club
{
    private Set<Pareja> parejas;

    public ClubParejas()
    {
        super();
        parejas = new HashSet<>();
    }

    /**
     * Lee los nombre de socios desde un scanner.
     * Las nombres están separados por el delimitador delim
     */
    @Override
    public void leerSocios(Scanner sc, String delim)
    {
        while (sc.hasNextLine())
        {
            try (Scanner scSocio = new Scanner(sc.nextLine()))
            {
                scSocio.useDelimiter(delim);

                while (scSocio.hasNext())
                    crearSocioDesdeString(scSocio.next());
            }
            catch (Exception e)
            {
                throw new AmigoException("Error en la lectura del fichero");
            }
        }
    }

    /**
     * Cada dato puede ser el nombre de un socio o los
     * nombres de una pareja separados por guion.
     */
    @Override
    public void crearSocioDesdeString(String nombreSocioOPareja)
    {
        if (!nombreSocioOPareja.contains("-"))
            socios.add(new Persona(nombreSocioOPareja));
        else
        {
            Persona p1;
            Persona p2;

            p1 = new Persona(nombreSocioOPareja.substring(0, nombreSocioOPareja.indexOf('-')));
            p2 = new Persona(nombreSocioOPareja.substring(nombreSocioOPareja.indexOf('-') + 1));

            socios.add(p1);
            socios.add(p2);
            parejas.add(new Pareja(p1, p2));
        }
    }

    /**
     * Se hace amigos como en la clase club y se comprueba que cada
     * socio y la persona a regalar no forman pareja.
     * Si alguno forma pareja, se repite el proceso
     */
    @Override
    public void hacerAmigos()
    {
        // Solo se puede encontrar una solucion cuando el numero de socios es > 2
        if (socios.size() <= 2)
            throw new AmigoException("No hay suficientes socios");

        // El algoritmo consiste en crear una lista de números de 0 a socios.size()-1
        // y mientras haya un elemento i que cumpla que posAmigos.get(i)==i
        // 			se baraja la lista (Collections.shuffle(posAmigos))
        // Cuando ya no ocurra lo anterior, al socio de la posicion i se le
        // asigna como amigo al que regalar el socio de la posicion posAmigos.get(i)
        List<Integer> posAmigos = new ArrayList<>();

        for (int i = 0; i < socios.size(); i++)
            posAmigos.add(i);

        do Collections.shuffle(posAmigos);
        while (hayCoincidenciasOSonPareja(posAmigos));

        for (int i = 0; i < socios.size(); i++)
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
    }

    /**
     * Comprueba si la listaBarajada  tiene algún elemento que coincida
     * con su posición. (listaBarajada.get(i) == i),
     * o si existe alguna persona que haya sido asignada a su pareja
     * <p>
     * Devuelve false si no hay tal elemento
     */
    private boolean hayCoincidenciasOSonPareja(List<Integer> listaBarajada)
    {
        Pareja pareja;

        for (int i = 0; i < listaBarajada.size(); i++)
        {
            if (listaBarajada.get(i) == i)
                return true;

            pareja = new Pareja(socios.get(i), socios.get(listaBarajada.get(i)));

            for (Pareja p : parejas)
                if (pareja.equals(p))
                    return true;
        }

        return false;
    }
}
