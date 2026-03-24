/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem8.pkg2d.ezco;

import java.util.Scanner;

/**
 *
 * @author Zoé
 */
public class REQ1SEM82DEZCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int estadosanimo[] = new int[7];       // Array para guardar estado de ánimo 7 días
        String actividades[][] = new String[7][3]; // Array bidimensional: filas=días, columnas=actividades
        int diaactual = 0;  // Controla en qué día estamos
        boolean continuar = true;  // Controla el menú
        int estado;   // Variable para el estado de ánimo

        while (continuar) {

            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int resp = leer.nextInt();

            switch (resp) {
                // --- CASE 1: Registrar estado de ánimo ---
                case 1:
                    if (diaactual < 7) {
                        do {
                            System.out.println("INGRESE SU ESTADO DE ÁNIMO"); 
                            System.out.println("1= Muy mal");
                            System.out.println("2= Mal");
                            System.out.println("3= Neutral");
                            System.out.println("4= Bien");
                            System.out.println("5= Excelente");

                            estado = leer.nextInt();

                            if (estado < 1 || estado > 5){
                                System.out.println("Valor inválido, por favor ingrese un valor correcto");
                            }

                        } while (estado < 1 || estado > 5);

                        estadosanimo[diaactual] = estado; // Guardamos el estado
                        System.out.println("Estado guardado correctamente");

                    } else {
                        System.out.println("Ya registraste los 7 días"); 
                    }
                    break;

                // --- CASE 2: Registrar actividades ---
                case 2:
                    if (diaactual < 7) { // Solo podemos registrar actividades si hay días disponibles
                        leer.nextLine(); // Limpiamos el buffer para leer Strings

                        for (int i = 0; i < 3; i++) {
                            System.out.print("Ingrese la actividad " + (i + 1) + ": ");
                            actividades[diaactual][i] = leer.nextLine(); // Guardamos la actividad
                        }

                        System.out.println("Actividades registradas para el día " + (diaactual + 1));
                        diaactual++; // Avanzamos al siguiente día

                    } else {
                        System.out.println("Ya registraste actividades para los 7 días");
                    }
                    break;

                // --- CASE 3: Ver resumen ---
                case 3:
                    // Contamos cuántos días tienen estado de ánimo registrado
                    int diasConDatos = 0;
                    int suma = 0;
                    for (int i = 0; i < estadosanimo.length; i++) {
                        if (estadosanimo[i] != 0) { // Si ya se ingresó un estado
                            suma += estadosanimo[i];
                            diasConDatos++;
                        }
                    }

                    if (diasConDatos == 0) {
                        System.out.println("No hay datos para mostrar aún.");
                        break;
                    }

                    double promedio = (double) suma / diasConDatos;
                    System.out.println("Promedio de estado de ánimo: " + promedio);

                    // Contamos el total de actividades realizadas
                    int totalActividades = 0;
                    for (int i = 0; i < actividades.length; i++) {
                        for (int j = 0; j < actividades[i].length; j++) {
                            if (actividades[i][j] != null && !actividades[i][j].isEmpty()) {
                                totalActividades++;
                            }
                        }
                    }
                    System.out.println("Total de actividades saludables: " + totalActividades);

                    // Determinamos el nivel de bienestar
                    if (promedio < 3) {
                        System.out.println("Bienestar: Bajo");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar: Medio");
                    } else {
                        System.out.println("Bienestar: Alto");
                    }
                    break;

                // --- CASE 4: Recomendación automática ---
                case 4:
                    // Recalculamos promedio considerando solo días con estado de ánimo
                    int sumaRec = 0;
                    int diasConEstado = 0;
                    for (int i = 0; i < estadosanimo.length; i++) {
                        if (estadosanimo[i] != 0) {
                            sumaRec += estadosanimo[i];
                            diasConEstado++;
                        }
                    }

                    if (diasConEstado == 0) {
                        System.out.println("No hay datos para recomendar.");
                        break;
                    }

                    double promedioRec = (double) sumaRec / diasConEstado;

                    if (promedioRec < 3) {
                        System.out.println("Recomendación: Descansa y medita.");
                    } else if (promedioRec < 4) {
                        System.out.println("Recomendación: Haz ejercicio.");
                    } else {
                        System.out.println("¡Excelente! Sigue así.");
                    }
                    break;

                // --- CASE 5: Salir ---
                case 5:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        leer.close();
    }
}