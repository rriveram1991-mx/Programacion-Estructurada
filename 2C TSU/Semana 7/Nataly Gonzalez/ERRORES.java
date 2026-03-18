/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package errores;
import java.util.Scanner;

/**
 *
 * @author LABTICS
 */
public class ERRORES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        String[][] juegos = new String[10][3]; 
       
        int opcion = 0;

        while (opcion != 7) {

            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");

            if (!sc.hasNextInt()) { 
                // ERROR: si el usuario escribe texto en vez de número, el programa se rompe
                // POR ESO: se valida antes de leer para evitar que truene
                System.out.println("Entrada invalida");
                sc.next(); 
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine(); 
            // ERROR: nextInt deja un salto de línea pendiente
            // POR ESO: se limpia para que nextLine funcione bien después

            switch (opcion) {

                case 1:
                    int fila = -1; 
                    // ERROR: antes no se sabía si estaba lleno
                    // POR ESO: usamos -1 para detectar si no hay espacio

                    for (int i = 0; i < juegos.length; i++) { 
                        // ERROR: antes se usaba <= y eso causaba que se saliera del arreglo
                        // POR ESO: usamos < para no provocar error

                        if (juegos[i][0] == null) {
                            fila = i;
                            break; 
                            // ERROR: antes recorría todo y tomaba el último espacio
                            // POR ESO: usamos break para tomar el primero disponible
                        }
                    }

                    if (fila == -1) {
                        // ERROR: no se validaba si ya estaba lleno
                        // POR ESO: se muestra mensaje en lugar de fallar
                        System.out.println("Lista llena");
                        break;
                    }

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.nextLine();
                    // ERROR: antes se saltaba este dato
                    // POR ESO: ya limpiamos buffer antes

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");

                    while (!sc.hasNextInt()) {
                        // ERROR: si ponen letras en horas, truena el programa
                        // POR ESO: se valida que sea número
                        System.out.println("Ingrese un numero valido");
                        sc.next();
                    }

                    juegos[fila][2] = String.valueOf(sc.nextInt());
                    sc.nextLine(); 
                    // ERROR: queda basura después de nextInt
                    // POR ESO: se limpia otra vez

                    break;

                case 2:
                    boolean hayDatos = false;

                    for (int i = 0; i < juegos.length; i++) {

                        if (juegos[i][0] != null) {
                            // ERROR: antes imprimía null
                            // POR ESO: solo muestra los que sí tienen datos
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            hayDatos = true;
                        }
                    }

                    if (!hayDatos) {
                        // ERROR: no avisaba cuando estaba vacío
                        // POR ESO: se agrega mensaje
                        System.out.println("No hay videojuegos registrados");
                    }

                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {

                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                            // ERROR: antes usaba == para comparar textos
                            // ESO ESTÁ MAL porque compara direcciones de memoria
                            // POR ESO: se usa equalsIgnoreCase para comparar contenido
                            System.out.println("Encontrado: " + juegos[i][0]);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        // ERROR: no decía nada si no encontraba
                        // POR ESO: se agrega mensaje
                        System.out.println("No encontrado");
                    }

                    break;

                case 4:
                    int suma = 0;
                    int contador = 0;

                    for (int i = 0; i < juegos.length; i++) {

                        if (juegos[i][2] != null) {
                            // ERROR: antes intentaba convertir null a número
                            // ESO provoca error
                            // POR ESO: se valida antes
                            suma += Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }

                    if (contador == 0) {
                        // ERROR: podía dividir entre 0
                        // POR ESO: se valida antes de calcular
                        System.out.println("No hay datos para calcular");
                    } else {
                        // ERROR: antes dividía entre todos los espacios (aunque estuvieran vacíos)
                        // POR ESO: ahora divide solo entre los que sí tienen datos
                        System.out.println("Promedio: " + (suma / contador));
                    }

                    break;

                case 7:
                    System.out.println("Adios");
                    break;

                default:
                    // ERROR: no controlaba opciones inválidas
                    // POR ESO: se agrega este mensaje
                    System.out.println("Opcion invalida");
            }
        }
    }
}
   
