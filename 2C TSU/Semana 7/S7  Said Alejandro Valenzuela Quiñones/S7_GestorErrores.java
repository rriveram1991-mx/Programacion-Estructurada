package s7_gestorerrores;

import java.util.Scanner;

public class S7_GestorErrores {

    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
    String[][] juegos = new String[10][3];

    int opcion = 0;

    while (opcion != 7) {

    System.out.println("\n1. Registrar");
    System.out.println("2. Mostrar");
    System.out.println("3. Buscar");
    System.out.println("4. Estadisticas");
    System.out.println("7. Salir");
    System.out.print("Opcion: ");

    // No se validaba que fuera numero, se agrego validacion
    if (!leer.hasNextInt()) {
        System.out.println("Ingresa un numero valido");
        leer.next();
        continue;
    }

    opcion = leer.nextInt();
    leer.nextLine(); // Se agrego para limpiar buffer despues de nextInt

    switch(opcion) {
        case 1:
            int fila = -1;

            // Antes era <= juegos.length, causaba desbordamiento
            for (int i = 0; i < juegos.length; i++) {

                // Agregar break
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
            juegos[fila][0] = leer.nextLine();

            System.out.print("Genero: ");
            juegos[fila][1] = leer.nextLine();

            System.out.print("Horas: ");

            // Se agrego validación para los números
            if(!leer.hasNextInt()) {
                System.out.println("Horas invalidas");
                leer.next();
                break;
            }

            juegos[fila][2] = leer.next();
            break;

        case 2:
            boolean hayDatos = false;

            for(int i = 0; i < juegos.length; i++) {

                // Se agrego validacion
                if(juegos[i][0] != null) {
                    System.out.println(juegos[i][0] + " - " +
                                       juegos[i][1] + " - " +
                                       juegos[i][2]);
                    hayDatos = true;
                }
            }

            // Agregar mensaje cuando no hay videojuegos
            if(!hayDatos) {
                System.out.println("No hay videojuegos registrados");
            }
            break;

        case 3:
            System.out.print("Buscar: ");
            String buscar = leer.nextLine();
            boolean encontrado = false;

            for(int i = 0; i < juegos.length; i++) {

                //  Se usaba == en String, se cambio a equalsIgnoreCase
                if(juegos[i][0] != null &&
                    juegos[i][0].equalsIgnoreCase(buscar)) {

                    System.out.println("Encontrado: " +
                        juegos[i][0] + " - " +
                        juegos[i][1] + " - " +
                        juegos[i][2]);

                    encontrado = true;
                }
            }

            if(!encontrado) {
                System.out.println("No encontrado");
            }
            break;

        case 4:
            int suma = 0;
            int contador = 0;

            for(int i = 0; i < juegos.length; i++) {

                //  Se agrego validacion
                if (juegos[i][2] != null) {
                    suma += Integer.parseInt(juegos[i][2]);
                    contador++;
                }
            }

            // Dividia entre juegos.length, ahora usa contador real
            if(contador == 0) {
                System.out.println("No hay datos para calcular");
            } else {
                System.out.println("Promedio: " + (suma / contador));
            }
            break;

        case 7:
            System.out.println("Saliendo del sistema... ");
            break;

        default:
            System.out.println("Opcion invalida");
    }
}
    }
}