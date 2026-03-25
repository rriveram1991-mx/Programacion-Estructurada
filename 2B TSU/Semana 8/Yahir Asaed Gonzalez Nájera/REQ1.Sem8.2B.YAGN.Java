/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosingricardo57;

import java.util.Scanner;

/**
 *
 * @author yahir
 */
public class EjerciciosIngRicardo57 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        
        
        int[] estadosAnimo = new int[7];
        String[][] actividades = new String[7][3]; 
        
        String[] nombresEstados = {"", "Muy mal", "Mal", "Neutral", "Bien", "Excelente"};

        int opcion = 0;
        int diaActual = 0; 

        while (opcion != 5) {
            System.out.println("Bienvenido a MindBalance");
            System.out.println("1. Registrar estado de animo");
            System.out.println("2. Registrar actividades saludables");
            System.out.println("3. Ver resumen de bienestar");
            System.out.println("4. Ver recomendaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    if (diaActual < 7) {
                        System.out.println("\nRegistro del dia " + (diaActual + 1));
                        System.out.println("Valores: 1-Muy mal, 2-Mal, 3-Neutral, 4-Bien, 5-Excelente");
                        System.out.print("Ingrese su estado: ");
                        int valor = leer.nextInt();

                        if (valor >= 1 && valor <= 5) {
                            estadosAnimo[diaActual] = valor;
                            System.out.println("Estado guardado: " + nombresEstados[valor]);
                        } else {
                            System.out.println("Error: Ingrese un valor valido entre 1 y 5.");
                        }
                    } else {
                        System.out.println("Registro semanal completo.");
                    }
                    break;

                case 2:
                    if (diaActual < 7 && estadosAnimo[diaActual] != 0) {
                        System.out.println("Ingrese 3 actividades saludables para hoy:");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Actividad " + (i + 1) + ": ");
                            actividades[diaActual][i] = leer.next();
                        }
                        diaActual++; 
                        System.out.println("Actividades registradas correctamente.");
                    } else if (diaActual < 7 && estadosAnimo[diaActual] == 0) {
                        System.out.println("Primero debe registrar el estado de animo de hoy.");
                    } else {
                        System.out.println("Ya se han completado los 7 dias.");
                    }
                    break;

                case 3:
                    if (diaActual == 0) {
                        System.out.println("No hay datos registrados aun.");
                    } else {
                        double suma = 0;
                        for (int i = 0; i < diaActual; i++) {
                            suma += estadosAnimo[i];
                        }
                        double promedio = suma / diaActual;

                        int totalAct = 0;
                        
                        for (String[] fila : actividades) {
                            for (String act : fila) {
                                if (act != null) {
                                    totalAct++;
                                }
                            }
                        }

                        System.out.println("\n--- RESUMEN DE BIENESTAR ---");
                        System.out.println("Dias completados: " + diaActual);
                        System.out.println("Promedio de animo: " + promedio);
                        System.out.println("Total de actividades realizadas: " + totalAct);

                        if (promedio < 3) System.out.println("Nivel de bienestar: BAJO");
                        else if (promedio < 4) System.out.println("Nivel de bienestar: MEDIO");
                        else System.out.println("Nivel de bienestar: ALTO");
                    }
                    break;

                case 4:
                    double sumaRec = 0;
                    for (int i = 0; i < diaActual; i++) sumaRec += estadosAnimo[i];
                    double promRec = (diaActual > 0) ? sumaRec / diaActual : 0;

                    if (diaActual == 0) {
                        System.out.println("Registre datos para recibir una recomendacion.");
                    } else if (promRec < 3) {
                        System.out.println("Recomendacion: Se sugiere descanso y meditación.");
                    } else if (promRec < 4) {
                        System.out.println("Recomendacion: Buen progreso, se sugiere realizar mas ejercicio.");
                    } else {
                        System.out.println("Felicidades por mantener un excelente nivel de bienestar.");
                    }
                    break;
            }
        }
        System.out.println("Sistema finalizado.");
    }
}