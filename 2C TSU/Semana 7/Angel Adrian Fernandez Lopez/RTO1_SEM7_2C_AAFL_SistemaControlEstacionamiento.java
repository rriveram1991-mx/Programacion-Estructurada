/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto1_sem7_2c_aafl_sistemacontrolestacionamiento;

/**
 *
 * @author LABTICS
 */
import java.util.Scanner; // Importa la clase Scanner para leer datos del usuario
import java.io.FileWriter; // Importa FileWriter para escribir archivos
import java.io.IOException; // Importa IOException para manejar errores de archivo

public class RTO1_SEM7_2C_AAFL_SistemaControlEstacionamiento { 

    public static void main(String[] args) { 

        Scanner Leer= new Scanner(System.in); // Crea un objeto Scanner para leer entrada

        String[] espacios = new String[10]; // Crea un arreglo de 10 espacios

        for (int i = 0; i < espacios.length; i++) { // Recorre el arreglo
            espacios[i] = "LIBRE"; // Inicializa cada espacio como LIBRE
        }

        String opcion = ""; // Variable para guardar la opcion del usuario

        while (!opcion.equalsIgnoreCase("Salir")) { // Ciclo que se repite hasta escribir "Salir"

            System.out.println("\n--- MENU ESTACIONAMIENTO ---"); // Muestra el titulo del menu
            System.out.println("1. Ver estacionamiento"); // Opcion 1
            System.out.println("2. Estacionar auto"); // Opcion 2
            System.out.println("3. Retirar auto"); // Opcion 3
            System.out.println("4. Contar espacios ocupados"); // Opcion 4
            System.out.println("5. Mostrar porcentaje de ocupacion"); // Opcion 5
            System.out.println("6. Guardar en archivo TXT"); // Opcion 6
            System.out.println("Escribe 'Salir' para terminar"); // Instruccion para salir
            System.out.print("Opcion: "); // Solicita opcion

            opcion = Leer.nextLine(); // Lee la opcion como texto

            switch (opcion) { // Evalua la opcion elegida

                case "1": // Caso para ver el estacionamiento
                    for (int i = 0; i < espacios.length; i++) { // Recorre todos los espacios
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]); // Muestra estado del espacio
                    }
                    break; // Termina el caso

                case "2": // Caso para estacionar auto
                    try { // Intenta ejecutar el codigo
                        System.out.print("Ingrese numero de espacio (1-10): "); // Solicita numero
                        int lugar = Integer.parseInt(Leer.nextLine()); // Convierte a entero

                        if (lugar >= 1 && lugar <= 10) { // Verifica rango valido
                            if (espacios[lugar - 1].equals("LIBRE")) { // Verifica si esta libre
                                espacios[lugar - 1] = "OCUPADO"; // Marca como ocupado
                                System.out.println("Auto estacionado."); // Mensaje de exito
                            } else {
                                System.out.println("Ese espacio ya esta ocupado."); // Mensaje si esta ocupado
                            }
                        } else {
                            System.out.println("Numero fuera de rango."); // Mensaje si no es valido
                        }

                    } catch (Exception e) { // Captura errores
                        System.out.println("Error: debes ingresar un numero entero."); // Mensaje de error
                    }
                    break; // Termina el caso

                case "3": // Caso para retirar auto
                    try { // Intenta ejecutar
                        System.out.print("Ingrese numero de espacio (1-10): "); // Solicita numero
                        int retirar = Integer.parseInt(Leer.nextLine()); // Convierte a entero

                        if (retirar >= 1 && retirar <= 10) { // Verifica rango
                            if (espacios[retirar - 1].equals("OCUPADO")) { // Verifica si esta ocupado
                                espacios[retirar - 1] = "LIBRE"; // Libera el espacio
                                System.out.println("Auto retirado."); // Mensaje de exito
                            } else {
                                System.out.println("Ese espacio ya esta libre."); // Mensaje si ya estaba libre
                            }
                        } else {
                            System.out.println("Numero fuera de rango."); // Mensaje si no es valido
                        }

                    } catch (Exception e) { // Manejo de error
                        System.out.println("Error: debes ingresar un numero entero."); // Mensaje de error
                    }
                    break; // Termina el caso

                case "4": // Caso para contar espacios ocupados
                    int contador = 0; // Inicializa contador
                    for (String espacio : espacios) { // Recorre con for-each
                        if (espacio.equals("OCUPADO")) { // Si esta ocupado
                            contador++; // Incrementa contador
                        }
                    }
                    System.out.println("Espacios ocupados: " + contador); // Muestra total
                    break; // Termina el caso

                case "5": // Caso para calcular porcentaje
                    int ocupados = 0; // Inicializa contador
                    for (String espacio : espacios) { // Recorre arreglo
                        if (espacio.equals("OCUPADO")) { // Si esta ocupado
                            ocupados++; // Incrementa contador
                        }
                    }

                    double porcentaje = (ocupados * 100.0) / espacios.length; // Calcula porcentaje
                    System.out.println("Ocupacion: " + porcentaje + "%"); // Muestra resultado
                    break; // Termina el caso

                case "6": // Caso para guardar en archivo
                    try { // Intenta guardar
                        FileWriter archivo = new FileWriter("estacionamiento.txt"); // Crea archivo

                        for (int i = 0; i < espacios.length; i++) { // Recorre espacios
                            archivo.write("Espacio " + (i + 1) + ": " + espacios[i] + "\n"); // Escribe linea
                        }

                        archivo.close(); // Cierra archivo
                        System.out.println("Datos guardados en estacionamiento.txt"); // Mensaje de exito

                    } catch (IOException e) { // Maneja errores de archivo
                        System.out.println("Error al guardar el archivo."); // Mensaje de error
                    }
                    break; // Termina el caso

                case "Salir": // Caso salir
                case "salir": // Caso salir en minusculas
                    System.out.println("Saliendo del sistema..."); // Mensaje de salida
                    break; // Termina el caso

                default: // Caso por defecto
                    System.out.println("Opcion invalida."); // Mensaje de error
            }
        }

    }
}