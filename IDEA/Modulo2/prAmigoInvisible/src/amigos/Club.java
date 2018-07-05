package amigos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Club
{
    protected List<Persona> socios;

    public Club()
    {
        socios = new ArrayList<Persona>();
    }

    /**
     * Lee los nombre de socios desde un fichero.
     * Las nombres están separados por el delimitador delim
     */
    public void leerSocios(String file, String delim) throws FileNotFoundException
    {
        try (Scanner sc = new Scanner(new File(file)))
        {
            leerSocios(sc, delim);
        }
    }

    /**
     * Lee los nombre de socios desde un scanner.
     * Las nombres están separados por el delimitador delim
     */
    public void leerSocios(Scanner sc, String delim)
    {
        while (sc.hasNextLine())
        {
            try (Scanner scSocio = new Scanner(sc.nextLine()))
            {
                scSocio.useDelimiter(delim);

                while (scSocio.hasNext())
                    socios.add(new Persona(scSocio.next()));
            }
            catch (Exception e)
            {
                throw new AmigoException("Error en la lectura del fichero");
            }
        }
    }

    /**
     * Crea un socio a partir de su nombre y lo incluye en la lista de socios
     */
    public void crearSocioDesdeString(String nombreSocio)
    {
        socios.add(new Persona(nombreSocio));
    }

    /**
     * Asocia a cada persona de la lista de socios un amigo al que
     * regalar
     */
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
        while (hayCoincidencias(posAmigos));

        for (int i = 0; i < socios.size(); i++)
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
    }

    /**
     * Comprueba si la listaBarajada  tiene algún elemento que coincida
     * con su posición. (listaBarajada.get(i) == i)
     * <p>
     * Devuelve false si no hay tal elemento
     */
    private static boolean hayCoincidencias(List<Integer> listaBarajada)
    {
        for (int i = 0; i < listaBarajada.size(); i++)
            if (listaBarajada.get(i) == i)
                return true;

        return false;
    }

    /**
     * Guarda la lista de socios en el fichero dado, uno por línea
     *
     * @param salida nombre del fichero
     * @throws FileNotFoundException
     */
    public void presentarAmigos(String salida) throws FileNotFoundException
    {
        try (PrintWriter pw = new PrintWriter(salida))
        {
            presentarAmigos(pw);
        }
    }

    /**
     * Guarda la lista de socios en el printwriter dado, uno por línea
     */
    public void presentarAmigos(PrintWriter pw)
    {
        Collections.sort(socios);

        for (Persona p : socios)
            pw.println(p);
    }
}
