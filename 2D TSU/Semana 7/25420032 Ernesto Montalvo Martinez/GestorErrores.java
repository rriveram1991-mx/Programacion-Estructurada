/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana7;

/**
 *
 * @author Ernesto Montalvo
 */
import java.util.Scanner;

public class GestorErrores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\n1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("5. Salir");
            //Correccion del 7 por el 5
            System.out.print("Opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("Ingresa un número válido");
                sc.next();
                continue;
            }
//Validacion de numero

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar

            switch (opcion) {

                case 1:
                    int fila = -1;

                    for (int i = 0; i < juegos.length; i++) {
                        //eliminacion de "<"
                        if (juegos[i][0] == null) {
                            fila = i;
                            break;
                        }
                    }

                    if (fila == -1) {
                        System.out.println("No hay espacio disponible");
                        break;
                    }

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.nextLine();
//se cambio la variable, y se puso el arreglo para que lo tome de manera adecuada
                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();
//se cambio la variable, y se puso el arreglo para que lo tome de manera adecuada
                    System.out.print("Horas: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Ingresa un número válido");
                        sc.next();
                    }
                    //validacion de numero con while
                    juegos[fila][2] = String.valueOf(sc.nextInt());
                    sc.nextLine();

                    break;

                case 2:
                    boolean Datos = false;
//booleano de datos
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            Datos = true;
                        }
                    }
//Datos igual a verdadero
                    if (!Datos) {
                        System.out.println("No hay videojuegos registrados");
                    }
//Si no hay datos, mostrara mensaje de que no hay datos
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    boolean encontrado = false;
//añadir booleano
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null &&
                            juegos[i][0].equalsIgnoreCase(buscar)) {
//Un equals para buscar
                            System.out.println("Encontrado: " +
                                juegos[i][0] + " - " +
                                juegos[i][1] + " - " +
                                juegos[i][2]);
//Se muestra el mensaje para los datos que se tomaron anteriormente uno por uno
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No encontrado");
                    }
//Si no se encuentra, mostrara mensaje de no encontrado
                    break;

                case 4:
                    int suma = 0;
                    int contador = 0;
//Añadir contador
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][2] != null) {
                            suma += Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }
//Añadir if
                    if (contador > 0) {
                        System.out.println("Promedio: " + (suma / contador));
                    } else {
                        System.out.println("No hay datos para calcular");
                    }
/*Si el contador es mayor a 0, se calculara el promedio, si no, 
                    entonces no habrá nada que calcular ya que no hay datos que calcular*/
                    break;

                case 5:
                    System.out.println("Adios");
                    break;
//Correccion del 7 por el 5
                default:
                    System.out.println("Opción inválida");
                    //Añadir el default
            }
        }
    }
}