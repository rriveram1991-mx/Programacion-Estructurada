/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuidado.de.salud.mental;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class CuidadoDeSaludMental {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int[] estadosAnimo = new int[7];          // Guarda el estado de ánimo por día
        int[][] actividades = new int[7][5];      // 7 días x 5 actividades
        int contadorDias = 0;                     // Cuántos días se han registrado

        int opcion;

        do {
            System.out.println("\n===== MIND BALANCE =====");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = read.nextInt();

            switch (opcion) {

                case 1:
                    if (contadorDias < 7) {
                        System.out.println("\nEstado de ánimo del día " + (contadorDias + 1));
                        System.out.println("1. Muy mal ");
                        System.out.println("2. Mal ");
                        System.out.println("3. Neutral ");
                        System.out.println("4. Bien ");
                        System.out.println("5. Excelente ");
                        System.out.print("Ingresa tu estado: ");
                        int estado = read.nextInt();

                             if (estado >= 1 && estado <= 5) {
                            estadosAnimo[contadorDias] = estado;
                            contadorDias++;
                            System.out.println("Estado registrado correctamente.");
                        } else {
                            System.out.println("Valor inválido.");
                        }
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 2:
                    if (contadorDias == 0) {
                        System.out.println("Primero registra al menos un estado de ánimo.");
                        break;
                    }
                     int dia = contadorDias - 1; // Registrar actividades del último día ingresado

                    System.out.println("\nActividades del día " + (dia + 1));
                    System.out.println("Ingresa 1 si realizaste la actividad, 0 si no:");

                    System.out.println("1. Meditación");
                    actividades[dia][0] = read.nextInt();

                    System.out.println("2. Ejercicio");
                    actividades[dia][1] = read.nextInt();

                    System.out.println("3. Lectura");
                    actividades[dia][2] = read.nextInt();

                    System.out.println("4. Hidratación");
                    actividades[dia][3] = read.nextInt();

                    System.out.println("5. Tiempo al aire libre");
                    actividades[dia][4] = read.nextInt();

                    System.out.println("Actividades registradas.");
                    break;

 case 3:
                    if (contadorDias == 0) {
                        System.out.println("No hay datos registrados.");
                        break;
                    }

                    // Calcular promedio
                    double suma = 0;
                    for (int i = 0; i < contadorDias; i++) {
                        suma += estadosAnimo[i];
                    }
                    double promedio = suma / contadorDias;

                    // Contar actividades
                    int totalActividades = 0;
                    for (int[] diaActs : actividades) {
                        for (int act : diaActs) {
                            if (act == 1) totalActividades++;
                        }
                    }
System.out.println("\n===== RESUMEN =====");
                    System.out.println("Promedio de estado de ánimo: " + promedio);
                    System.out.println("Total de actividades saludables realizadas: " + totalActividades);

                    // Nivel de bienestar
                    if (promedio < 3) {
                        System.out.println("Bienestar: BAJO");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar: MEDIO");
                    } else {
                        System.out.println("Bienestar: ALTO");
                    }

                    break;
 case 4:
                    if (contadorDias == 0) {
                        System.out.println("No hay datos registrados.");
                        break;
                    }

                    // Calcular promedio otra vez
                    double suma2 = 0;
                    for (int i = 0; i < contadorDias; i++) {
                        suma2 += estadosAnimo[i];
                    }
                    double promedio2 = suma2 / contadorDias;

                    System.out.println("\n===== RECOMENDACIÓN =====");

                    if (promedio2 < 3) {
                        System.out.println("Tu promedio es bajo. Te recomiendo descanso y meditación.");
                    } else if (promedio2 < 4) {
                        System.out.println("Tu promedio es medio. Te recomiendo hacer ejercicio.");
                    } else {
                        System.out.println("¡Excelente! Sigue así, tu bienestar es alto.");
                    }

                    break;
                    



    }
    
}
