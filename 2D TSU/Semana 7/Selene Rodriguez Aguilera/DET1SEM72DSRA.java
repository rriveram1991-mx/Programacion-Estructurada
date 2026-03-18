/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg1sem7.pkg2d.sra;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class DET1SEM72DSRA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    

   



  

       
        Scanner sc = new Scanner(System.in);

        // Arreglo bidimensional para guardar: nombre, genero, horas
        String[][] juegos = new String[10][3];

        // Variable para controlar el menú
        int opcion = 0;

        // Ciclo principal del programa
        while (opcion != 7) {

            // Menú de opciones
            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");

            // Leer opción
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el buffer y esto me sirve para que el menu no se repita edad nombre osea que se mezcle

            switch (opcion) {

                case 1:
                    // Variable para guardar la posición disponible
                    int fila = -1;

                    // Buscar un espacio vacío en el arreglo
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break; // detener al encontrar el primero
                        }
                    }

                    // Verificar si hay espacio disponible
                    if (fila != -1) {

                       
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        juegos[fila][0] = nombre;

                    
                        System.out.print("Genero: ");
                        juegos[fila][1] = sc.nextLine();

                    
                        System.out.print("Horas: ");
                        juegos[fila][2] = sc.nextLine();

                    } else {
                      
                        System.out.println("No hay espacio");
                    }

                    break;

                case 2:
                    // Variable para saber si hay datos
                    boolean hayDatos = false;

                    // Recorrer el arreglo
                    for (int i = 0; i < juegos.length; i++) {
                        // Mostrar solo si hay información
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            hayDatos = true;
                        }
                    }

                    // Si no hay datos registrados
                    if (!hayDatos) {
                        System.out.println("No hay videojuegos");
                    }

                    break;

                case 3:
                    // Pedir nombre a buscar
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    // Recorrer el arreglo
                    for (int i = 0; i < juegos.length; i++) {
                        // Comparar correctamente Strings y evitar null
                        if (juegos[i][0] != null && juegos[i][0].equals(buscar)) {
                            System.out.println("Encontrado");
                        }
                    }

                    break;

                case 4:
                    // Variables para suma y conteo
                    int suma = 0;
                    int contador = 0;

                    // Recorrer el arreglo
                    for (int i = 0; i < juegos.length; i++) {
                        // Solo sumar si hay datos
                        if (juegos[i][2] != null) {
                            suma = suma + Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }

                    // Calcular promedio si hay datos
                    if (contador > 0) {
                        System.out.println("Promedio: " + suma / contador);
                    } else {
                        System.out.println("No hay datos");
                    }

                    break;

                case 7:
                    
                    System.out.println("Adios");
                    break;
            }
        }
    }//En este programa se presentaban distintos tipos de errores que afectaban su 
    //funcionamiento. Principalmente había errores lógicos, como el uso incorrecto de == para comparar cadenas, 
    //lo que impedía que la búsqueda funcionara correctamente. También había errores de ejecución, como el riesgo 
    //de NullPointerException al intentar usar valores null y problemas al convertir datos con Integer.parseInt() sin validar.
}

    
