/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s8.mindbalance;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class S8MindBalance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        // Se declara un arreglo de enteros para guardar el estado de ánimo de 7 días
        int [] estadoAnimo=  new int [7];
        // Se declara una matriz (array bidimensional) para guardar 3 actividades por cada uno de los 7 días
        String[][] actividades = new String[7][3];
        // Variable que indica el día actual (empieza en 0 porque los arreglos inician en índice 0)
        int diaActual = 0;
        // Variable que almacenará la opción del menú elegida por el usuario
        int menu;
        // Estructura do-while para repetir el menu hasta que el usuario decida salir
        do{
            // Se muestra el menu de opciones al usuario
            System.out.println("Menu del sistema");  
            System.out.println("Registro del estado de animo");
            System.out.println("Registro de las actividades");
            System.out.println("Ver Resumen");
            System.out.println("Ver Recomendacion");
            System.out.println("Salir...");
            // Se pide al usuario elegir una opcion
            System.out.println("Elige la opcion que desee");
            // Se guarda la opcion ingresada
            menu = leer.nextInt();
            
            // Estructura switch para ejecutar diferentes acciones segun la opcion elegida
            switch(menu){
                case 1 :
                    // Se verifica que aun no se hayan registrado los 7 dias
                    if(diaActual < 7){
                        System.out.println("Estado de animo");
                        System.out.println("1.- Muy mal");
                        System.out.println("2.- Mal");
                        System.out.println("3.- Neutral");
                        System.out.println("4.- Bien");
                        System.out.println("5.- Excelente");
                        System.out.println("Como se siente?");// Se pide al usuario su estado de animo

                        // Se guarda el valor en el arreglo en la posicion del dia actual
                        estadoAnimo[diaActual] = leer.nextInt();
                        // Se confirma que el dato fue guardado
                        System.out.println("Guardado en el dia "+(diaActual+1));
                    }
                    
                    else {
                        // Mensaje si ya se llenaron los 7 dias
                        System.out.println("Ya registraste los 7 dias de la semana");
                    }
                    break;
                    
                case 2:
                    // Verifica que aun haya dias disponibles
                    if (diaActual < 7) {

                        leer.nextLine(); 

                        // Mensaje para ingresar actividades
                        System.out.println("Ingrese las 3 actividades saludables:");

                        // Ciclo for para pedir 3 actividades
                        for (int i = 0; i < 3; i++) {
                            // Muestra el numero de actividad
                            System.out.print("Actividad " + (i + 1));
                            // Guarda la actividad en la matriz (doa actual, actividad i)
                            actividades[diaActual][i] = leer.nextLine();
                        }

                        System.out.println("Actividades guardadas del dia " + (diaActual + 1));

                        // Avanza al siugiente dia despues de registrar las actividades
                        diaActual++;

                    } else {
                        //Un aviso donde se indique que ya se lleno toda la semana
                        System.out.println("Ya registraste toda la semana.");
                    }
                    break;
                    
                case 3:
                    // Seleecion de resumen

                    int suma = 0; //Variable para acumular la suma de los estados dde animo
                    int contadorDias = 0; //contador de dias con datos aceptados

                    //recorre el arreglo de estado de animo
                    for (int i = 0; i < estadoAnimo.length; i++) {
                        //verifica que el valor no sea 0
                        if (estadoAnimo[i] != 0) {
                            //suma los valores
                            suma += estadoAnimo[i];
                            contadorDias++; //cuenta los dias validos
                        }
                    }

                    // si no hay datos se muestra un mensaje y termina el case
                    if (contadorDias == 0) {
                        System.out.println("No hay datos aún.");
                        break;
                    }

                    
                    //calculamos el promedio
                    double promedio = (double) suma / contadorDias;

                    System.out.println("\nPromedio de estado de animo: " + promedio);

                    // CONTAR ACTIVIDADES (for-each)
                    int totalActividades = 0;

                    // for-each para recorrer la matriz de actividades
                    for (String[] dia : actividades) {
                        // Recorre cada actividad del día
                        for (String act : dia) {
                            if (act != null && !act.isEmpty()) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("Total de actividades realizadas: " + totalActividades);

                    // CLASIFICACIÓN
                    if (promedio < 3) {
                        System.out.println("Bienestar: BAJO");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar: MEDIO");
                    } else {
                        System.out.println("Bienestar: ALTO");
                    }

                    break;

         case 4:
            // SECCIsN DE RECOMENDACIONES

            int sumaRec = 0; // suma de estados de animo
            int diasRec = 0; // contador de dias

            // Recorre el arreglo
            for (int i = 0; i < estadoAnimo.length; i++) {

                // Verifica datos válidos
                if (estadoAnimo[i] != 0) {

                    sumaRec += estadoAnimo[i];
                    diasRec++;
                }
            }

            // Si no hay datos, no se puede recomendar
            if (diasRec == 0) {
                System.out.println("No hay datos para recomendar");
                break;
            }

            // Calcula promedio
            double promedioRec = (double) sumaRec / diasRec;

            // Genera recomendacion segun el promedio
            if (promedioRec < 3) {
                System.out.println("Recomendacion Descansa y prueba meditacion");
            } else if (promedioRec < 4) {
                System.out.println("Recomendacion Realiza ejercicio");
            } else {
                System.out.println("Felicidades!");
            }

            break;

        case 5:
            // Opcion para salir del programa
            System.out.println("Saliendo del sistema...");
            break;

        default:
            // Mensaje si el usuario ingresa una opcion invwlida
            System.out.println("Opcion invalida.");
    }

// El ciclo se repite hasta que el usuario elija la opcin 5 (salir)
} while (menu != 5);
    }
}
