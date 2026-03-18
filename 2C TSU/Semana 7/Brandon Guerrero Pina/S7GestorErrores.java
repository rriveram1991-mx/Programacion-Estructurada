/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s7.gestorerrores;
import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class S7GestorErrores {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // se crea una matriz de 10 filas y 3 columnas
        // cada fila guarda un videojuego: nombre, genero y horas
        String[][] juegos = new String[10][3];

        // variable que guarda la opcion del menu
        int opcion = 0;

        // ciclo que se repite hasta que el usuario elia salir
        while (opcion != 7) {

            System.out.println("\n1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");

            // ERROR 
            // Tipo: Ejecución
            // Problema: Si el usuario escribe texto, el programa truena
            // Corrección: Validar con hasNextInt()
            
            if (!sc.hasNextInt()) {
                System.out.println("Error: Ingresa un número válido");
                sc.next();
                continue;
                // se valida que el usuario ingrese un numero
                // si no es numero se limpia el dato y se repite el ciclo
            }

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    int fila = -1;

                    // Eroor
                    // Tipo: Ejecucion
                    // Problema: Se usaba <= y provocaba ArrayIndexOutOfBounds
                    // Correccimn: usar <
                    for (int i = 0; i < juegos.length; i++) {

                        // Error3
                        // Tipo: Logico
                        // Problema: No se detenia en la primera posicion vacia
                        // Correccion: agregar break
                        if (juegos[i][0] == null) {
                            fila = i;
                            break;
                            // si encuentra una posicion vacia la guarda
                            // break detiene el ciclo en la primera encontrada
                        }
                    }

                    // Error
                    // Tipo: Logico
                    // Problema: No validaba si el arreglo estaba lleno
                    // Correccion:
                    if (fila == -1) {
                        System.out.println("No hay espacio disponible");
                        break;
                        // si no hay espacio disponible se muestra mensaje y sale
                    }

                    // ERror 
                    // Tipo: Lpgico
                    // Problema: nextInt deja un ENTER en buffer
                    // Correccion:
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.nextLine();

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");

                    // error
                    // Tipo: Ejecucon
                    // Problema: Puede ingresar texto en lugar de numero
                    // Correccionpara validar numero
                    while (!sc.hasNextInt()) {
                        System.out.println("Ingresa un número válido:");
                        sc.next();
                    }

                   // guarda las horas como texto
                    juegos[fila][2] = String.valueOf(sc.nextInt());
                    break;
                case 2:
                    // variable para saber si hay datos registrados
                    boolean hayDatos = false;

                    for (int i = 0; i < juegos.length; i++) {

                        // Errror
                        // Tipo: logico
                        // Problema: Imprimiia valores null
                        // Correccion:
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            hayDatos = true;
                        }
                    }
                    // Mensaje cuando no hay videojuegos
                    if (!hayDatos) {
                        System.out.println("No hay videojuegos registrados");
                    }

                    break;

                case 3:
                    sc.nextLine();

                    System.out.print("Busca: ");
                    String buscar = sc.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {

                        // error
                        // Tipo: Logico
                        // Problema: Se usaba == para comparar Strings
                        // Correccion: usar equalsIgnoreCase
                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                            System.out.println("Encontrado: " + juegos[i][0]);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No encontrado");
                    }

                    break;

                case 4:
                    int suma = 0;
                    int contador = 0;

                    for (int i = 0; i < juegos.length; i++) {

                        // rror
                        // Tipo: Ejecucion
                        // Problema: Puede ser null → NullPointerException
                        // Correccipn:
                        if (juegos[i][2] != null) {
                            suma += Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }

                    // Eerror
                    // Tipo: Logico
                    // Problema: ividia entre el total del arreglo
                    // Correccion: dividir entre contador
                    if (contador > 0) {
                        System.out.println("Promedio: " + (suma / contador));
                    } else {
                        System.out.println("No hay datos para calcular");
                    }

                    break;

                case 7:
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}
