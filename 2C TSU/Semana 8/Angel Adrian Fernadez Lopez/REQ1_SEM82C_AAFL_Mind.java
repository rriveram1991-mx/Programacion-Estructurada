/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1_sem8_2c_aafl_mind;
import java.util.Scanner; // Importa la clase Scanner para poder leer datos del usuario

public class REQ1_SEM82C_AAFL_Mind { // Declaracion de la clase principal

    public static void main(String[] args) { // Metodo principal donde inicia el programa

        Scanner sc = new Scanner(System.in); // Creamos objeto Scanner para entrada por teclado

        int[] estadoAnimo = new int[7]; // Array para guardar el estado de animo de 7 dias
        int[][] actividades = new int[7][3]; // Matriz: filas = dias, columnas = actividades

        String[] nombresActividades = {"Ejercicio", "Lectura", "Meditacion"}; // Nombres de actividades

        int diaActual = 0; // Variable que indica en que dia estamos registrando
        int opcion = 0; // Variable para el menu

        do { // Inicio del bucle principal del programa

            System.out.println("\n=============================="); // Linea visual
            System.out.println("   SISTEMA MINDBALANCE"); // Titulo
            System.out.println("=============================="); // Linea visual
            System.out.println("1. Registrar estado de animo"); // Opcion 1
            System.out.println("2. Registrar actividades"); // Opcion 2
            System.out.println("3. Ver resumen"); // Opcion 3
            System.out.println("4. Ver recomendacion"); // Opcion 4
            System.out.println("5. Salir"); // Opcion 5
            System.out.print("Seleccione una opcion: "); // Solicita opcion

            try {
                opcion = sc.nextInt(); // Lee la opcion ingresada
            } catch (Exception e) {
                System.out.println("Error: debes ingresar un numero."); // Mensaje de error
                sc.nextLine(); // Limpia el buffer
                continue; // Regresa al inicio del menu
            }

            switch (opcion) { // Estructura de seleccion

                case 1: // Caso 1: registrar estado de animo

                    if (diaActual < 7) { // Verifica que no se pasen los 7 dias

                        int estado = 0; // Variable temporal para guardar estado

                        while (true) { // Bucle hasta que el dato sea valido

                            System.out.println("\nSelecciona tu estado de animo:"); // Mensaje
                            System.out.println("1. Muy mal"); // Opcion 1
                            System.out.println("2. Mal"); // Opcion 2
                            System.out.println("3. Neutral"); // Opcion 3
                            System.out.println("4. Bien"); // Opcion 4
                            System.out.println("5. Excelente"); // Opcion 5
                            System.out.print("Opcion: "); // Solicita opcion

                            try {
                                estado = sc.nextInt(); // Lee valor

                                if (estado >= 1 && estado <= 5) { // Valida rango

                                    estadoAnimo[diaActual] = estado; // Guarda en el array
                                    System.out.println("Estado registrado para el dia " + (diaActual + 1)); // Confirmacion

                                    if (estado <= 2) { // Si el estado es bajo
                                        System.out.println("Consejo: descansa y relajate."); // Mensaje
                                    } else if (estado == 3) { // Si es neutral
                                        System.out.println("Consejo: intenta mejorar tu dia."); // Mensaje
                                    } else { // Si es bueno o excelente
                                        System.out.println("Buen trabajo, sigue asi."); // Mensaje
                                    }

                                    break; // Sale del while

                                } else {
                                    System.out.println("Error: solo valores del 1 al 5."); // Error
                                }

                            } catch (Exception e) {
                                System.out.println("Error: debes ingresar numero."); // Error
                                sc.nextLine(); // Limpia buffer
                            }
                        }

                    } else {
                        System.out.println("Ya registraste los 7 dias."); // Limite alcanzado
                    }

                    break; // Fin del caso 1

                case 2: // Caso 2: registrar actividades

                    if (diaActual < 7) { // Verifica limite

                        System.out.println("\nRegistro del dia " + (diaActual + 1)); // Muestra dia

                        for (int i = 0; i < actividades[diaActual].length; i++) { // Recorre actividades

                            while (true) { // Validacion

                                System.out.print(nombresActividades[i] + " (1=Si, 0=No): "); // Muestra actividad

                                try {
                                    int valor = sc.nextInt(); // Lee valor

                                    if (valor == 0 || valor == 1) { // Valida

                                        actividades[diaActual][i] = valor; // Guarda en matriz
                                        break; // Sale del while

                                    } else {
                                        System.out.println("Error: solo 1 o 0."); // Error
                                    }

                                } catch (Exception e) {
                                    System.out.println("Error: numero invalido."); // Error
                                    sc.nextLine(); // Limpia buffer
                                }
                            }
                        }

                        diaActual++; // Avanza al siguiente dia
                        System.out.println("Actividades guardadas."); // Confirmacion

                    } else {
                        System.out.println("Ya completaste los 7 dias."); // Limite
                    }

                    break; // Fin caso 2

                case 3: // Caso 3: resumen

                    int suma = 0; // Acumulador
                    int contador = 0; // Contador de dias

                    for (int i = 0; i < estadoAnimo.length; i++) { // Recorre array
                        if (estadoAnimo[i] != 0) { // Solo dias registrados
                            suma += estadoAnimo[i]; // Suma
                            contador++; // Cuenta
                        }
                    }

                    if (contador > 0) { // Verifica datos

                        double promedio = (double) suma / contador; // Calcula promedio
                        System.out.println("Promedio: " + promedio); // Muestra

                        int totalActividades = 0; // Contador

                        for (int[] dia : actividades) { // Recorre filas
                            for (int act : dia) { // Recorre columnas
                                if (act == 1) { // Si realizo actividad
                                    totalActividades++; // Suma
                                }
                            }
                        }

                        System.out.println("Total actividades: " + totalActividades); // Muestra

                        if (promedio < 3) { // Clasificacion
                            System.out.println("Bienestar: Bajo");
                        } else if (promedio < 4) {
                            System.out.println("Bienestar: Medio");
                        } else {
                            System.out.println("Bienestar: Alto");
                        }

                    } else {
                        System.out.println("No hay datos."); // Sin datos
                    }

                    break; // Fin caso 3

                case 4: // Caso 4: recomendacion

                    int sumaRec = 0; // Acumulador
                    int dias = 0; // Contador

                    for (int i = 0; i < estadoAnimo.length; i++) { // Recorre
                        if (estadoAnimo[i] != 0) {
                            sumaRec += estadoAnimo[i]; // Suma
                            dias++; // Cuenta
                        }
                    }

                    if (dias > 0) { // Verifica datos

                        double promedio = (double) sumaRec / dias; // Promedio

                        if (promedio < 3) {
                            System.out.println("Descansa y medita.");
                        } else if (promedio < 4) {
                            System.out.println("Haz ejercicio.");
                        } else {
                            System.out.println("Excelente, sigue asi.");
                        }

                    } else {
                        System.out.println("No hay datos."); // Sin datos
                    }

                    break; // Fin caso 4

                case 5: // Caso salir
                    System.out.println("Saliendo del sistema..."); // Mensaje
                    break;

                default:
                    System.out.println("Opcion invalida."); // Error

            }

        } while (opcion != 5); // Repite hasta salir
    }
}