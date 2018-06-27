package buses;

import java.io.*;
import java.util.*;

public class Servicio
{
    private String ciudad;
    private Set<Bus> buses;

    public Servicio(String ciudad)
    {
        this.ciudad = ciudad;
        buses = new HashSet<>();
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public Set<Bus> getBuses()
    {
        return buses;
    }

    public void leeBuses(String file) throws FileNotFoundException
    {
        try (Scanner sc = new Scanner(new File(file)))
        {
            leeBuses(sc);
        }
    }

    public void leeBuses(Scanner sc)
    {
        while (sc.hasNextLine())
        {
            String linea = sc.nextLine();

            try (Scanner scBus = new Scanner(linea))
            {
                scBus.useDelimiter("[,]");

                int codBus = scBus.nextInt();
                String matricula = scBus.next();
                int codLinea = scBus.nextInt();

                Bus bus = new Bus(codBus, matricula);

                bus.setCodLinea(codLinea);
                buses.add(bus);
            }
            catch (InputMismatchException e)
            {
                System.err.println("Error en dato entero en línea: " + linea);
            }
            catch (NoSuchElementException e)
            {
                System.err.println("Error: faltan datos en línea: " + linea);
            }
        }
    }

    public Set<Bus> filtra(Criterio criterio)
    {
        Set<Bus> seleccion = new HashSet<>();

        for (Bus bus : buses)
            if (criterio.esSeleccionable(bus))
                seleccion.add(bus);

        return seleccion;
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException
    {
        try (PrintWriter pw = new PrintWriter(file))
        {
            guarda(pw, criterio);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio)
    {
        Set<Bus> sel = filtra(criterio);

        for (Bus bus : sel)
            pw.println(bus);
    }
}
