import java.util.Scanner;

public class Eje1gestordevideojuego {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] juegos = new String[10][3];
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            // validar para que no corra con letras
            if (!sc.hasNextInt()) {
                System.out.println("Error: Introduce un numero.");
                sc.next(); 
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine(); //quite el espacio para que los nextLine de abajo funcionen

            switch (opcion) {

                case 1:
                    int fila = -1; // tiene que iniciar en -1 para saber si encontramos espacio

                    // quitar el = para evitar error de indice
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break; //  elbreak detiene ciclo al hallar el primer espacio libre
                        }
                    }

                    if (fila != -1) {
                        System.out.print("Nombre: ");
                        juegos[fila][0] = sc.nextLine();

                        System.out.print("Genero: ");
                        juegos[fila][1] = sc.nextLine();

                        System.out.print("Horas: ");
                        juegos[fila][2] = sc.nextLine();
                        System.out.println("Juego registrado en la posicion " + fila);
                    } else {
                        System.out.println("No hay espacio disponible.");
                    }
                    break;

                case 2:
                    boolean hayDatos = false;
                    for (int i = 0; i < juegos.length; i++) {
                        // solo imprime si la fila no está vacia
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            hayDatos = true;
                        }
                    }
                    if (!hayDatos) System.out.println("La lista esta vacia.");
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {
                        // aqui usamos .equals() para comparar texto y evitar nulos
                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                            System.out.println("Encontrado en la fila: " + i);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("No se encontro el juego.");
                    break;

                case 4:
                    int suma = 0;
                    int juegosRegistrados = 0;

                    for (int i = 0; i < juegos.length; i++) {
                        // Validamos que no sea null antes de convertir a un numero
                        if (juegos[i][2] != null) {
                            suma = suma + Integer.parseInt(juegos[i][2]);
                            juegosRegistrados++;
                        }
                    }

                    if (juegosRegistrados > 0) {
                        // el promedio real basado en juegos ingresado
                        System.out.println("Promedio de horas: " + (double) suma / juegosRegistrados);
                    } else {
                        System.out.println("No hay juegos para calcular promedio.");
                    }
                    break;

                case 7:
                    System.out.println("Adios");
                    break;
                
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        sc.close();
    }
}