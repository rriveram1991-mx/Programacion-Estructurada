/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1_sem7_2c_aafl_gestorerrores;
import java.util.Scanner; // importar scanner para entrada de datos
/**
 *
 * @author aleja
 */



public class DET1_SEM7_2C_AAFL_GestorErrores { // clase principal

    public static void main(String[] args) { // metodo principal donde inicia el programa

        Scanner sc = new Scanner(System.in); // crear objeto scanner

        String[][] usuarios = new String[10][2]; // matriz de usuarios [usuario, password]
        int totalUsuarios = 0; // contador de usuarios registrados

        String[][] juegos = new String[50][4]; // matriz de juegos [usuario, juego, genero, horas]

        String usuarioActual = ""; // guarda el usuario que inicia sesion

        while (true) { // ciclo infinito principal del sistema

            System.out.println("\n=== LOGIN ==="); // mostrar titulo
            System.out.println("1 registrar"); // opcion 1
            System.out.println("2 login"); // opcion 2
            System.out.println("3 salir"); // opcion 3
            System.out.print("opcion: "); // pedir opcion

            int opcion; // variable para opcion

            // validacion: verificar que el usuario escriba un numero
            if (!sc.hasNextInt()) { // si no es numero
                System.out.println("numero invalido"); // mensaje error
                sc.next(); // limpiar entrada incorrecta
                continue; // volver a pedir opcion
            }

            opcion = sc.nextInt(); // leer opcion
            sc.nextLine(); // limpiar buffer

            if (opcion == 3) { // si elige salir
                System.out.println("adios"); // mensaje
                break; // terminar programa
            }

            if (opcion == 1) { // registrar usuario

                String user; // variable usuario

                while (true) { // validar usuario
                    System.out.print("usuario: "); // pedir
                    user = sc.nextLine(); // leer

                    // expresion regular: solo letras y numeros
                    if (user.matches("[a-zA-Z0-9]+")) { // valida formato
                        break; // correcto
                    } else {
                        System.out.println("solo letras y numeros"); // error
                    }
                }

                boolean existe = false; // bandera

                for (int i = 0; i < totalUsuarios; i++) { // recorrer usuarios
                    if (usuarios[i][0].equalsIgnoreCase(user)) { // comparar
                        existe = true; // ya existe
                    }
                }

                if (existe) { // si ya existe
                    System.out.println("ya existe"); // mensaje
                    continue; // regresar al menu
                }

                System.out.print("password: "); // pedir password
                String pass = sc.nextLine(); // leer

                usuarios[totalUsuarios][0] = user; // guardar usuario
                usuarios[totalUsuarios][1] = pass; // guardar password

                totalUsuarios++; // aumentar contador

                System.out.println("registrado"); // mensaje
                continue; // volver al login
            }

            // -------- LOGIN --------
            System.out.print("usuario: "); // pedir usuario
            String user = sc.nextLine(); // leer

            System.out.print("password: "); // pedir password
            String pass = sc.nextLine(); // leer

            boolean loginCorrecto = false; // bandera login

            for (int i = 0; i < totalUsuarios; i++) { // recorrer usuarios
                if (usuarios[i][0].equals(user) && usuarios[i][1].equals(pass)) {
                    loginCorrecto = true; // login correcto
                }
            }

            if (!loginCorrecto) { // si falla login
                System.out.println("error login"); // mensaje
                continue; // regresar al login
            }

            usuarioActual = user; // guardar usuario logueado

            System.out.println("bienvenido " + usuarioActual); // mensaje

            int op = 0; // opcion menu usuario

            while (op != 5) { // ciclo menu usuario

                System.out.println("\n1 agregar juego");
                System.out.println("2 ver juegos");
                System.out.println("3 top juego");
                System.out.println("4 ranking");
                System.out.println("5 logout");
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

                        int fila = -1; // buscar espacio libre

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

                        String nombre; // nombre del juego

                        while (true) { // validar nombre
                            System.out.print("juego: ");
                            nombre = sc.nextLine();

                            // solo letras y espacios
                            if (nombre.matches("[a-zA-Z ]+")) {
                                break;
                            } else {
                                System.out.println("solo letras");
                            }
                        }

                        String genero; // genero

                        while (true) { // validar genero
                            System.out.print("genero: ");
                            genero = sc.nextLine();

                            if (genero.matches("[a-zA-Z ]+")) { // solo letras
                                break;
                            } else {
                                System.out.println("solo letras");
                            }
                        }

                        int horas; // horas jugadas

                        while (true) { // validar horas
                            System.out.print("horas: ");

                            if (sc.hasNextInt()) { // validar entero
                                horas = sc.nextInt();

                                if (horas >= 0) break; // validar positivo
                                else System.out.println("numero positivo");
                            } else {
                                System.out.println("solo enteros sin decimal"); // evita decimales
                                sc.next();
                            }
                        }

                        sc.nextLine(); // limpiar buffer

                        juegos[fila][0] = usuarioActual; // guardar usuario
                        juegos[fila][1] = nombre; // guardar juego
                        juegos[fila][2] = genero; // guardar genero
                        juegos[fila][3] = String.valueOf(horas); // guardar horas

                        break;

                    case 2: // ver juegos

                        boolean hay = false; // bandera

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

                        if (!hay) {
                            System.out.println("sin juegos");
                        }

                        break;

                    case 3: // top juego

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

                        if (max == -1) {
                            System.out.println("sin datos");
                        } else {
                            System.out.println("top: " + top + " con " + max);
                        }

                        break;

                    case 4: // ranking personal

                        for (int i = 0; i < juegos.length; i++) {
                            if (juegos[i][0] != null && juegos[i][0].equals(usuarioActual)) {

                                System.out.println(
                                    juegos[i][1] + " -> " + juegos[i][3]
                                );
                            }
                        }

                        break;

                    case 5: // logout
                        System.out.println("cerrando sesion");
                        break;

                    default:
                        System.out.println("opcion invalida");
                }
            }
        }

      
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