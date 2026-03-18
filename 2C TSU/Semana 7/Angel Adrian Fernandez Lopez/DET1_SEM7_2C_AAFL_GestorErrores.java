/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1_sem7_2c_aafl_gestorerrores;
import java.util.Scanner; // importar scanner para leer datos del teclado

public class DET1_SEM7_2C_AAFL_GestorErrores { // clase principal del sistema

    public static void main(String[] args) { // metodo principal

        Scanner sc = new Scanner(System.in); // crear scanner para entrada

        String[][] usuarios = new String[10][2]; // matriz usuarios [usuario, password]
        int totalUsuarios = 0; // contador de usuarios

        String[][] juegos = new String[50][4]; // matriz juegos [usuario, nombre, genero, horas]

        String usuarioActual = ""; // guarda el usuario logueado

        while (true) { // ciclo infinito principal

            System.out.println("\n=== LOGIN ==="); // titulo
            System.out.println("1 registrar"); // opcion registrar
            System.out.println("2 login"); // opcion login
            System.out.println("3 salir"); // opcion salir
            System.out.print("opcion: "); // pedir opcion

            if (!sc.hasNextInt()) { // validar que sea numero
                System.out.println("numero invalido"); // error
                sc.next(); // limpiar
                continue; // repetir
            }

            int opcion = sc.nextInt(); // leer opcion
            sc.nextLine(); // limpiar buffer

            if (opcion == 3) { // salir
                System.out.println("adios"); // mensaje
                break; // terminar
            }

            if (opcion == 1) { // registrar usuario

                String user; // variable usuario

                while (true) { // validar usuario
                    System.out.print("usuario: "); // pedir
                    user = sc.nextLine(); // leer

                    if (user.matches("[a-zA-Z0-9]+")) break; // solo letras y numeros
                    else System.out.println("solo letras y numeros"); // error
                }

                boolean existe = false; // bandera

                for (int i = 0; i < totalUsuarios; i++) { // recorrer usuarios
                    if (usuarios[i][0].equalsIgnoreCase(user)) { // comparar
                        existe = true; // ya existe
                    }
                }

                if (existe) { // si existe
                    System.out.println("ya existe"); // mensaje
                    continue; // regresar
                }

                System.out.print("password: "); // pedir password
                String pass = sc.nextLine(); // leer

                usuarios[totalUsuarios][0] = user; // guardar usuario
                usuarios[totalUsuarios][1] = pass; // guardar password
                totalUsuarios++; // aumentar contador

                System.out.println("registrado"); // confirmacion
                continue; // volver al login
            }

            // login
            System.out.print("usuario: "); // pedir usuario
            String user = sc.nextLine(); // leer

            System.out.print("password: "); // pedir password
            String pass = sc.nextLine(); // leer

            boolean loginCorrecto = false; // bandera login

            for (int i = 0; i < totalUsuarios; i++) { // recorrer usuarios
                if (usuarios[i][0].equals(user) && usuarios[i][1].equals(pass)) {
                    loginCorrecto = true; // correcto
                }
            }

            if (!loginCorrecto) { // si falla
                System.out.println("error login"); // mensaje
                continue; // volver
            }

            usuarioActual = user; // guardar usuario activo

            int op = 0; // opcion menu usuario

            while (op != 6) { // ciclo menu usuario

                System.out.println("\n1 agregar juego");
                System.out.println("2 ver juegos");
                System.out.println("3 buscar juego");
                System.out.println("4 top juego");
                System.out.println("5 promedio por juego");
                System.out.println("6 logout");
                System.out.print("opcion: ");

                if (!sc.hasNextInt()) { // validar numero
                    System.out.println("numero invalido");
                    sc.next();
                    continue;
                }

                op = sc.nextInt(); // leer opcion
                sc.nextLine(); // limpiar buffer

                switch (op) {

                    case 1: // agregar juego

                        String nombre;

                        while (true) { // validar nombre
                            System.out.print("juego: ");
                            nombre = sc.nextLine();

                            if (nombre.matches("[a-zA-Z ]+")) break; // solo letras
                            else System.out.println("solo letras");
                        }

                        String genero;

                        while (true) { // validar genero
                            System.out.print("genero: ");
                            genero = sc.nextLine();

                            if (genero.matches("[a-zA-Z ]+")) break; // solo letras
                            else System.out.println("solo letras");
                        }

                        int horas;

                        while (true) { // validar horas
                            System.out.print("horas: ");

                            if (sc.hasNextInt()) { // validar entero
                                horas = sc.nextInt();

                                if (horas >= 0) break; // positivo
                                else System.out.println("positivo");
                            } else {
                                System.out.println("solo enteros"); // no decimales
                                sc.next();
                            }
                        }

                        sc.nextLine(); // limpiar buffer

                        boolean existeJuego = false; // bandera

                        for (int i = 0; i < juegos.length; i++) {

                            if (juegos[i][0] != null &&
                                juegos[i][0].equals(usuarioActual) &&
                                juegos[i][1].equalsIgnoreCase(nombre)) {

                                int hActual = Integer.parseInt(juegos[i][3]); // horas actuales
                                juegos[i][3] = String.valueOf(hActual + horas); // sumar horas

                                existeJuego = true; // marcar
                                System.out.println("horas sumadas"); // mensaje
                                break;
                            }
                        }

                        if (!existeJuego) { // si no existe

                            int fila = -1; // buscar espacio

                            for (int i = 0; i < juegos.length; i++) {
                                if (juegos[i][0] == null) {
                                    fila = i;
                                    break;
                                }
                            }

                            if (fila == -1) {
                                System.out.println("lleno");
                                break;
                            }

                            juegos[fila][0] = usuarioActual;
                            juegos[fila][1] = nombre;
                            juegos[fila][2] = genero;
                            juegos[fila][3] = String.valueOf(horas);
                        }

                        break;

                    case 2: // ver juegos

                        boolean hay = false;

                        for (int i = 0; i < juegos.length; i++) {
                            if (juegos[i][0] != null && juegos[i][0].equals(usuarioActual)) {

                                System.out.println(
                                    juegos[i][1] + " - " +
                                    juegos[i][2] + " - " +
                                    juegos[i][3] + " hrs"
                                );

                                hay = true;
                            }
                        }

                        if (!hay) System.out.println("sin juegos");

                        break;

                    case 3: // buscar

                        System.out.print("buscar juego: ");
                        String buscar = sc.nextLine();

                        boolean encontrado = false;

                        for (int i = 0; i < juegos.length; i++) {
                            if (juegos[i][1] != null &&
                                juegos[i][1].equalsIgnoreCase(buscar) &&
                                juegos[i][0].equals(usuarioActual)) {

                                System.out.println(
                                    juegos[i][1] + " - " +
                                    juegos[i][2] + " - " +
                                    juegos[i][3]
                                );

                                encontrado = true;
                            }
                        }

                        if (!encontrado) System.out.println("no encontrado");

                        break;

                    case 4: // top juego

                        int max = -1;
                        String top = "";

                        for (int i = 0; i < juegos.length; i++) {
                            if (juegos[i][3] != null) {

                                int h = Integer.parseInt(juegos[i][3]);

                                if (h > max) {
                                    max = h;
                                    top = juegos[i][1];
                                }
                            }
                        }

                        if (max == -1) System.out.println("sin datos");
                        else System.out.println("top: " + top + " con " + max);

                        break;

                    case 5: // promedio por juego corregido

                        boolean hayProm = false;

                        for (int i = 0; i < juegos.length; i++) {

                            if (juegos[i][0] != null &&
                                juegos[i][0].equals(usuarioActual)) {

                                String juegoActual = juegos[i][1];
                                int suma = 0;
                                int contador = 0;

                                for (int j = 0; j < juegos.length; j++) {
                                    if (juegos[j][0] != null &&
                                        juegos[j][0].equals(usuarioActual) &&
                                        juegos[j][1].equalsIgnoreCase(juegoActual)) {

                                        suma += Integer.parseInt(juegos[j][3]);
                                        contador++;
                                    }
                                }

                                boolean yaMostrado = false;

                                for (int k = 0; k < i; k++) {
                                    if (juegos[k][1] != null &&
                                        juegos[k][1].equalsIgnoreCase(juegoActual) &&
                                        juegos[k][0].equals(usuarioActual)) {

                                        yaMostrado = true;
                                    }
                                }

                                if (!yaMostrado) {

                                    int promedio = 0;

                                    if (contador > 0) {
                                        promedio = suma / contador; // division correcta
                                    }

                                    System.out.println(
                                        juegoActual +
                                        " total: " + suma +
                                        " promedio: " + promedio
                                    );

                                    hayProm = true;
                                }
                            }
                        }

                        if (!hayProm) System.out.println("sin juegos");

                        break;

                    case 6: // logout
                        System.out.println("cerrando sesion");
                        break;

                    default:
                        System.out.println("opcion invalida");
                }
            }
        }

        sc.close(); // cerrar scanner
    }
}
/**
 
 
 Codigo Original con los Errores Señalados... =)

import java.util.Scanner;

public class GestorErrores {

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
            // ERROR 1 - linea aprox 20
            // Tipo: ejecucion
            // Explicacion: no valida si el usuario mete texto, puede tronar el programa

            switch (opcion) {

                case 1:
                    int fila = 0;

                    for (int i = 0; i <= juegos.length; i++) {
                        // ERROR 2 - linea aprox 28
                        // Tipo: ejecucion (ArrayIndexOutOfBounds)
                        // Explicacion: usa <= y se sale del limite del arreglo

                        if (juegos[i][0] == null) {
                            fila = i;
                        }
                        // ERROR 3 - linea aprox 32
                        // Tipo: logico
                        // Explicacion: no hace break, se queda con la ultima posicion vacia, no la primera
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    // ERROR 4 - linea aprox 38
                    // Tipo: logico / ejecucion
                    // Explicacion: nextInt deja salto de linea y nextLine lo captura vacio

                    juegos[fila][0] = nombre;

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.nextLine();
                    // ERROR 5 - linea aprox 46
                    // Tipo: logico
                    // Explicacion: horas deberia ser numero pero se guarda como texto sin validar

                    break;

                case 2:
                    for (int i = 0; i < juegos.length; i++) {
                        System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                        // ERROR 6 - linea aprox 54
                        // Tipo: logico
                        // Explicacion: imprime null cuando no hay datos, no valida si esta vacio
                    }
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();
                    // ERROR 7 - linea aprox 61
                    // Tipo: logico
                    // Explicacion: mismo problema de nextLine vacio despues de nextInt

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == buscar) {
                            // ERROR 8 - linea aprox 65
                            // Tipo: logico
                            // Explicacion: usa == en lugar de equals para comparar strings

                            System.out.println("Encontrado");
                        }
                    }
                    break;

                case 4:
                    int suma = 0;

                    for (int i = 0; i < juegos.length; i++) {
                        suma = suma + Integer.parseInt(juegos[i][2]);
                        // ERROR 9 - linea aprox 76
                        // Tipo: ejecucion
                        // Explicacion: puede hacer parseInt a null y tronar (NumberFormatException)
                    }

                    System.out.println("Promedio: " + suma / juegos.length);
                    // ERROR 10 - linea aprox 80
                    // Tipo: logico
                    // Explicacion: divide entre total del arreglo, no entre registros validos

                    break;

                case 7:
                    System.out.println("Adios");
                    break;
            }
        }
    }
}

*/