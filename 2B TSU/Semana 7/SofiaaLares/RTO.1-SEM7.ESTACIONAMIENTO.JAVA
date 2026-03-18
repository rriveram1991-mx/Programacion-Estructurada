import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ESTACIONAMIENTO_LIBRE 
{
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        String[] espacios = new String[10];

        
        for (int i = 0; i < espacios.length; i++) 
        {
            espacios[i] = "LIBRE";
        }

        int opcion = 0;

        while (opcion != 5) 
        {
            System.out.println("\n--- MENU ESTACIONAMIENTO ---");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir y Guardar Reporte");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) 
            {
                case 1:
                    for (int i = 0; i < espacios.length; i++) 
                    {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;
                case 2:
                    System.out.print("Numero de espacio (1-10): ");
                    int e = leer.nextInt() - 1;
                    if (e >= 0 && e < 10) {
                        if (espacios[e].equals("LIBRE")) 
                        {
                            espacios[e] = "OCUPADO";
                            System.out.println("¡Logrado! Auto estacionado.");
                        } else {
                            System.out.println("Error: El espacio ya esta ocupado.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Numero de espacio (1-10): ");
                    int r = leer.nextInt() - 1;
                    if (r >= 0 && r < 10) {
                        if (espacios[r].equals("OCUPADO")) {
                            espacios[r] = "LIBRE";
                            System.out.println("Auto retirado.");
                        } else {
                            System.out.println("El espacio ya esta libre.");
                        }
                    }
                    break;
                case 4:
                    int ocupados = 0;
                    for (String s : espacios) 
                    {
                        if (s.equals("OCUPADO")) ocupados++;
                    }
                    System.out.println("Total de autos: " + ocupados);
                    break;
                case 5:
                    System.out.println("Generando reporte final en MI_INFO.txt...");
                    generarArchivoConReporte(espacios); // Pasamos el arreglo al archivo
                    break;
            }
        }
        leer.close();
    }

    public static void generarArchivoConReporte(String[] espacios) {
        try {
            FileWriter escribir = new FileWriter("REPORTE.txt");
            
            
            escribir.write("===== REPORTE DEL ESTACIONAMIENTO =====\n");
            int total = 0;
            for (int i = 0; i < espacios.length; i++) {
                escribir.write("Espacio " + (i + 1) + ": " + espacios[i] + "\n");
                if (espacios[i].equals("OCUPADO")) total++;
            }
            escribir.write("\nTOTAL DE AUTOS AL SALIR: " + total + "\n");
            escribir.write("======================================\n");
            
            escribir.close();
            System.out.println("¡Reporte y datos guardados con éxito en MI_INFO.txt!");

        } 
        catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
            e.printStackTrace();
        }
    }
}