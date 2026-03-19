package errores18;
import java.util.Scanner;
public class Errores18 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    int fila = 0;

                    for (int i = 0; i < juegos.length; i++) { //Debe ser menor, no menor o igual
                        if (juegos[i][0] == null) {
                            fila = i;
                        }
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.next(); //Se cambia a "next" para que no se salte la linea

                    juegos[fila][0] = nombre;

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.next();//Se cambia a next

                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.next();//Se cambia a next

                    break;

                case 2:
                    for (int i = 1; i < juegos.length; i++) {
                        System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                    }
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.next(); //se pone next

                    for (int i = 0; i < juegos.length; i++) {
                        if (buscar.equals(juegos[i][0])) {//Se cambia a equals.
                            System.out.println("Encontrado");
                        }else{
                            System.out.println("No se ha encontrado.");
                        }
                    }
                    break;

                case 4:
                    int suma = 0;
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][2] != null){ //Se agrega para evitar leer valores vacios
                        suma = suma + Integer.parseInt(juegos[i][2]);
                        }
                    }

                    System.out.println("Promedio: " +(double)suma / juegos.length); //Se convierte a double
                    break;

                case 7:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Eliga una opcion."); //faltaba default
            }
        }
    }

    }
    

