/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication35;
   import java.util.Scanner;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication35 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // solicitar número de pasajeros
        System.out.print("¿cuantos pasajeros se registraran?: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar el buffer después de leer un entero

        // crear los dos arrays solicitados
        String[] nombres = new String[n];
        String[] destinos = new String[n];

        // captura con ciclo for
        for (int i = 0; i < n; i++) {
            System.out.println("\n registro de pasajero #" + (i + 1) + "    ");
            
            System.out.print("nombre del pasajero: ");
            nombres[i] = sc.nextLine();

            // validar con while que el nombre no esté vacío
            // use .trim().isEmpty() para detectar si solo pusieron espacios
            while (nombres[i].trim().isEmpty()) {
                // mostrar error usando if
                if (nombres[i].trim().isEmpty()) {
                    System.err.println("el nombre no puede estar vacio.");
                    System.out.print("ingrese un nombre válido: ");
                    nombres[i] = sc.nextLine();
                }
            }

            System.out.print("destino (CDMX / Local / Otro): ");
            destinos[i] = sc.nextLine();
        }

        // procesamiento y contadores
        int cdmxCount = 0;
        int localCount = 0;
        int otrosCount = 0;

        System.out.println("\n lista completa de pasajeros  ");
        
        // usamos un for para relacionar nombres con destinos
        for (int i = 0; i < n; i++) {
            String tipoViaje = "";
            
            // logica de destinos y etiquetas de viaje
            if (destinos[i].equalsIgnoreCase("CDMX")) {
                tipoViaje = " = viaje largo";
                cdmxCount++;
            } else if (destinos[i].equalsIgnoreCase("Local")) {
                tipoViaje = " = viaje corto";
                localCount++;
            } else {
                tipoViaje = " =viaje estandar";
                otrosCount++;
            }

            // mostrar lista completa simulando comportamiento for-each para el reporte
            System.out.println("pasajero: " + nombres[i] + " | destino: " + destinos[i] + tipoViaje);
        }

        // determinar destino con más pasajeros
        String destinoPopular = "";
        if (cdmxCount >= localCount && cdmxCount >= otrosCount) {
            destinoPopular = "CDMX";
        } else if (localCount >= cdmxCount && localCount >= otrosCount) {
            destinoPopular = "Local";
        } else {
            destinoPopular = "otros destinos";
        }

        // mostrar resultados finales
        System.out.println("\n  resumen de logistica  ");
        System.out.println("pasajeros a CDMX: " + cdmxCount);
        System.out.println("pasajeros Locales: " + localCount);
        System.out.println("otros destinos: " + otrosCount);
        System.out.println("-----------------------------");
        System.out.println("destino con más pasajeros: " + destinoPopular);
        System.out.println("total pasajeros localizados: " + n);

        sc.close();
    }
}