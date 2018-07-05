import buses.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        /*
        Bus b1 = new Bus(34, "4567FGH");
        Bus b2 = new Bus(34, "4567FGH");
        Set <Bus> buses = new HashSet<>();

        buses.add(b1);
        buses.add(b2);

        System.out.print(buses);
        */

        try
        {
            Servicio emt = new Servicio("Malaga");
            emt.leeBuses("prBus/buses.txt");

            // emt.guarda("prBus/los21.txt", new PorLinea(21));
            // emt.guarda("prBus/conAT.txt", new EnMatricula("AT"));
            emt.guarda(new PrintWriter(System.out, true), new EnMatricula("A"));
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Fichero no encontrado: " + e.getMessage());
        }
    }
}
