/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg1sem72caadsm.pkg2e.agfl;

/**
 *
 * @author gl873
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
            System.out.println("4. Promedio");
            System.out.println("7. Salir");

            opcion = sc.nextInt();
           

            switch (opcion) {

                case 1:
                    int fila = -1;  //1. es -1 sino no agarraba las filas correctas (lógico)

                    // 2. antes estaba <= y fallaba desde un inicio (sintaxis)
                    for (int i = 0; i < 10; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break; // 3. sin break tomaba las demás filas, o sea que fallaba. (ejecución)
                        }
                    }

                    if (fila == -1) { //4.  if para que cuando se llenen las filas (Ejecución)
                        System.out.println("Lleno");
                        break;
                    }

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.next();// 5. se quita el line para que lea y no salte linea. (Ejecución)

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.next(); // 6. se quita el line para que lea y no salte linea. (Ejecución)

                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.next();// 7.  se quita el line para que lea y no salte linea. (Ejecución)

                    break;

                case 2:
                    boolean hay = false;

                    for (int i = 0; i < 10; i++) {

                        // 8. antes imprimia null, se quito el == y se puso el ! (sintaxis)
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            hay = true;
                        }
                    }

                    // 9. faltaba mensaje si no hay datos (ejecución)
                    if (hay == false) {
                        System.out.println("No hay juegos");
                    }

                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < 10; i++) {

                        // 10. == no compara texto (sintaxis)
                        if (juegos[i][0] != null && juegos[i][0].equals(buscar)) {
                            System.out.println("Encontrado");
                            encontrado = true;
                        }
                    }

                    // 11. faltaba mensaje si no lo encuentra (ejecución)
                    if (encontrado == false) {
                        System.out.println("No encontrado");
                    }

                    break;

                case 4:
                    int suma = 0;
                    int cont = 0;

                    for (int i = 0; i < 10; i++) {

                        // 12. podia ser null y truena (sintaxis)
                        if (juegos[i][2] != null) {
                            suma = suma + Integer.parseInt(juegos[i][2]);
                            cont++;
                        }
                    }

                    if (cont > 0) {
                        System.out.println("Promedio: " + (suma / cont));
                    } else {
                        System.out.println("No hay datos");
                    }

                    break;

                case 7:
                    System.out.println("Adios");
                    break;
            }
        }
    }
}