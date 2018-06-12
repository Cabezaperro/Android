import java.util.Scanner;

public class Ejercicio9
{
    public static void main(String[] args)
    {
        int dia, mes, ano;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un día: ");
        dia = teclado.nextInt();

        System.out.print("Introduce un mes: ");
        mes = teclado.nextInt();

        System.out.print("Introduce un año: ");
        ano = teclado.nextInt();

        if (dia < 1 || mes < 1 || ano < 1)
            System.out.println("Ningún valor puede ser menor que 1");
        else if (dia > 31)
                System.out.println("Un mes no puede tener más de 31 días");
        else if (mes > 12)
                System.out.println("Un año no puede tener más de 12 meses");
        else
        {
            System.out.println("Día: " + dia);
            System.out.println("Mes: " + MesALetras(mes));
            System.out.println("Año: " + ano);
        }
    }

    private static String MesALetras(int mes)
    {
        switch (mes)
        {
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
        }

        return null;
    }
}
