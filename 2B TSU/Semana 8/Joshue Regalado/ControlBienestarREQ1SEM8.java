/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control.bienestar.req.pkg1.sem8;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class ControlBienestarREQ1SEM8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
        int[] estadoAnimo = new int[7];
        int[][] actividades = new int[7][3];

        int opcion = 0;
        int dia = 0;

        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.next();

        while (opcion != 5) {
            
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar estado de animo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendacion");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            if ((opcion == 3 || opcion == 4) && dia == 0) {
                System.out.println("No hay datos aun. Registra al menos un dia.");
                continue;
            }
            
            switch (opcion) {

                case 1:
                    if (dia < 7) {
                        int valor;
                        do {
                            System.out.println("\nDia " + (dia + 1));
                            System.out.println("1. Muy mal");
                            System.out.println("2. Mal");
                            System.out.println("3. Neutral");
                            System.out.println("4. Bien");
                            System.out.println("5. Excelente");
                            System.out.print("Ingresa tu estado: ");
                            valor = sc.nextInt();
                        } while (valor < 1 || valor > 5);

                        estadoAnimo[dia] = valor;
                        dia++;
                    } else {
                        System.out.println("Ya registraste los 7 dias.");
                    }
                    break;

                case 2:
                    System.out.print("Ingresa el dia (1-7): ");
                    int d = sc.nextInt() - 1;

                    if (d >= 0 && d < 7) {
                        System.out.println("Realizaste ejercicio? (1=Si, 0=No)");
                        actividades[d][0] = sc.nextInt();

                        System.out.println("Meditacion? (1=Si, 0=No)");
                        actividades[d][1] = sc.nextInt();

                        System.out.println("Lectura? (1=Si, 0=No)");
                        actividades[d][2] = sc.nextInt();
                    } else {
                        System.out.println("Dia invalido.");
                    }
                    break;

                case 3:
                    int[] contador = new int[6];
                    System.out.println("Resumen de bienestar de " + nombre);
                    for (int i = 0; i < dia; i++) {
                        int valor = estadoAnimo[i];
                        if (valor >= 1 && valor <= 5) {
                            contador[valor]++;
                        }
                    }

                    int moda = 1;
                    for (int i = 2; i <= 5; i++) {
                        if (contador[i] > contador[moda]) {
                            moda = i;
                        }
                    }

                    String estadoTexto = "";
                    switch (moda) {
                        case 1: 
                            estadoTexto = "Muy mal"; 
                            break;
                        case 2: 
                            estadoTexto = "Mal";
                            break;
                        case 3: 
                            estadoTexto = "Neutral";
                            break;
                        case 4: 
                            estadoTexto = "Bien";
                            break;
                        case 5: 
                            estadoTexto = "Excelente";
                            break;
                    }

                    System.out.println("Estado de animo mas frecuente: " + estadoTexto);

                    int peor = 6;
                    int diaPeor = -1;

                    for (int i = 0; i < dia; i++) {
                        if (estadoAnimo[i] < peor) {
                            peor = estadoAnimo[i];
                            diaPeor = i + 1;
                        }
                    }

                    if (diaPeor != -1) {
                        System.out.println("Peor dia: Dia " + diaPeor);
                    }

                    int totalActividades = 0;
                    for (int[] fila : actividades) {
                        for (int act : fila) {
                            if (act == 1) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("Actividades realizadas: " + totalActividades);

                    if (moda == 1 || moda == 2) {
                        System.out.println("Bienestar: Bajo");
                    } else if (moda == 3) {
                        System.out.println("Bienestar: Medio");
                    } else {
                        System.out.println("Bienestar: Alto");
                    }

                    break;

                case 4:
                    int[] contador2 = new int[6];

                    for (int i = 0; i < estadoAnimo.length; i++) {
                        int valor = estadoAnimo[i];
                        if (valor >= 1 && valor <= 5) {
                            contador2[valor]++;
                        }
                    }

                    int moda2 = 1;
                    for (int i = 2; i <= 5; i++) {
                        if (contador2[i] > contador2[moda2]) {
                            moda2 = i;
                        }
                    }

                    if (moda2 == 1 || moda2 == 2) {
                        System.out.println("Recomendacion: Descansa y medita");
                    } else if (moda2 == 3) {
                        System.out.println("Recomendacion: Haz ejercicio");
                    } else {
                        System.out.println("Excelente! Sigue asi");
                    }

                    break;

                case 5:
                    System.out.println("Saliendo... ADIOS, "+nombre);
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }
}