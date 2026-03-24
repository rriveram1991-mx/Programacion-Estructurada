/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s8.rpg;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class S8RPG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
    // MATRICES
    // Se crean arreglos bidimensionales (2 jugadores x 3 personajes)
    String[][] nombres = new String[2][3];   // Guarda nombres de los pokemon es
    int[][] vida = new int[2][3];            // Vida de cada personaje
    int[][] ataque = new int[2][3];          // Ataque fisico
    int[][] magia = new int[2][3];           // Ataque magico
    int[][] energia = new int[2][3];         // Energía disponible para magia
    boolean[][] vivo = new boolean[2][3];    // Estado del personaje (true = vivo, false = muerto)
    int[][] curaciones = new int[2][3];      // Cantidad veces se ha curado cada personaje

    // Registro de personajes
    // Bucle que recorre a los 2 jugadores (j = 0 y j = 1)
    for (int j = 0; j < 2; j++) {

        System.out.println("Jugador " + (j + 1)); // Se muestra el numero de jugador

        // Bucle que permite crear 3 personajes por jugador
        for (int i = 0; i < 3; i++) {

            System.out.println("------Crea tu personaje------");

            System.out.print("Nombre: ");
            nombres[j][i] = leer.next(); // Se guarda el nombre en la matriz

            System.out.print("Vida: ");
            vida[j][i] = leer.nextInt(); // Se guarda la vida inicial

            System.out.print("Ataque: ");
            ataque[j][i] = leer.nextInt(); // Se guarda el daño fsico

            System.out.print("Magia: ");
            magia[j][i] = leer.nextInt(); // Se guarda el daño magico

            System.out.print("Energia: ");
            energia[j][i] = leer.nextInt(); // Energia para usar ataques magicos

            vivo[j][i] = true;  
            // Se marca como vivo porque todos los personajes estan vivos

            curaciones[j][i] = 0;  
            // Inicializa el contador de curaciones en 0
        }
    }

    // Personaje Usado
    // Arreglo que indica que personaje esta activo por cada jugador
    int[] actual = new int[2]; // posicion 0 = jugador 1, posicion 1 = jugador 2

    // Seleciion de personajes
    // Cada jugadordebe elegir algun personaje para comenzar
    for (int j = 0; j < 2; j++) {

        System.out.println("\nJugador " + (j + 1) + " elige su personaje inicial:");

        // Mostrar los personajes disponibles
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + nombres[j][i] + " (Vida: " + vida[j][i] + ")");
        }

        int eleccion = leer.nextInt() - 1; 
        // Se resta 1 porque el usuario elige 1,2,3 pero el arreglo usa 0,1,2

        // VALIDACION
        // Se repite mientras
        // el numero sea menor que 0 
        // o mayor que 2 
        while (eleccion < 0 || eleccion > 2) {
            System.out.println("Elige un personaje valido:");
            eleccion = leer.nextInt() - 1;
        }

        actual[j] = eleccion; 
        // Se guarda el personnaje seleccionado como el activo
    }

    // CONTROL DEL JUEGO
    boolean juego = true; // Controla si el ciclo sigue
    int turno = 0;        // Cuenta los turnos

    // COMBATE
    // Se ejecuta mientras el juego siga activo
    while (juego) {

        int jugador = turno % 2; 
        // Alterna turnos:
        // turno par = jugador 1
        // turno impar = jugador 2

        int enemigo = (jugador == 0) ? 1 : 0; 
      
        // Si jugador es 1 → enemigo es 2
        // Si jugador es 2 → enemigo es 1

        // Mostrar informacin del personaje actual
        System.out.println("\nTurno Jugador " + (jugador + 1));
        System.out.println("Heroe: " + nombres[jugador][actual[jugador]]);
        System.out.println("Vida: " + vida[jugador][actual[jugador]]);
        System.out.println("Energia: " + energia[jugador][actual[jugador]]);

        // MENU DE OPCIONES
        System.out.println("1. Ataque fisico");
        System.out.println("2. Ataque magico");
        System.out.println("3. Curarse");
        System.out.println("4. Cambiar heroe");

        int opcion = leer.nextInt(); 

        // ================= ATAQUE FsSICO =================
        if (opcion == 1) {

            int dano = ataque[jugador][actual[jugador]]; 
            // Se obtiene el daño base del personaje actual

            int prob = (int)(Math.random() * 100); 
            // Numero aleatorio entre 0 y 99

            if (prob < 20) { 
                // 20% de probabilidad de critico
                dano *= 2; // Duplica el daño
                System.out.println("Golpe critico!!!!!");
            }

            vida[enemigo][actual[enemigo]] -= dano; 
            // Se resta el daño a la vida del enemigo

            if (vida[enemigo][actual[enemigo]] <= 0) {
                // Si la vida baja a 0 o menos  muere
                vida[enemigo][actual[enemigo]] = 0; 
                // Evita numeros negativos
                vivo[enemigo][actual[enemigo]] = false; 
                // Se marca como muerto
            }

            System.out.println("Daño: " + dano);
        }

        // ================= ATAQUE MAGICO =================
        else if (opcion == 2) {

            if (energia[jugador][actual[jugador]] >= 10) {
            // CONDICION:
            // Solo puede usar magia si tiene al menos 10 de energía

                int dano = magia[jugador][actual[jugador]];

                int prob = (int)(Math.random() * 100);

                if (prob < 20) {
                    // 20% critico
                    dano *= 2;
                    System.out.println("Golpe critico!!!");
                }

                vida[enemigo][actual[enemigo]] -= dano;
                energia[jugador][actual[jugador]] -= 10; 
                // Se consume energia

                if (vida[enemigo][actual[enemigo]] <= 0) {
                    vida[enemigo][actual[enemigo]] = 0;
                    vivo[enemigo][actual[enemigo]] = false;
                }

                System.out.println("Daño magico: " + dano);

            } else {
                System.out.println("No tienes energia suficiente");
                continue; 
                // IMPORTANTE:
                // "continue" hace que el turno NO se pierda
                // vuelve a empezar el turno del mismo jugador
            }
        }

        // ================= CURARSE =================
        else if (opcion == 3) {

            if (curaciones[jugador][actual[jugador]] < 2) {
            // CONDICION:
            // Solo puede curarse si ha usado menos de 2 curaciones

                vida[jugador][actual[jugador]] += 20; 
                // Recupera 20 de vida

                curaciones[jugador][actual[jugador]]++; 
                // Aumenta el contador de curaciones

                System.out.println("Te curaste +20");

            } else {
                System.out.println("Ya usaste tus 2 curaciones");
                continue; 
                // No pierde turno
            }
        }

        // ================= CMBIAR HEROE =================
        else if (opcion == 4) {

            System.out.println("Elige heroe:");

            for (int i = 0; i < 3; i++) {
                if (vivo[jugador][i]) {
                // Solo muestra ´personajes vivos
                    System.out.println((i + 1) + ". " + nombres[jugador][i]);
                }
            }

            int cambio = leer.nextInt() - 1;

            while (cambio < 0 || cambio > 2 || !vivo[jugador][cambio]) {
            // CONDICION:
            // Fuera de rango
            // O personaje muerto
                System.out.println("Elige uno valido");
                cambio = leer.nextInt() - 1;
            }

            actual[jugador] = cambio; // Se cambia el personajes activo
            continue; // No pierde turno
        }

        // Mostrar vida del enemigo
        System.out.println("Vida enemigo: " + vida[enemigo][actual[enemigo]]);

        // ================= MUERTE =================
        if (!vivo[enemigo][actual[enemigo]]) {
        // Si el personaje enemigo esta muerto

            System.out.println("Personaje derrotado!");

            boolean todosMuertos = true;

            for (int i = 0; i < 3; i++) {
                if (vivo[enemigo][i]) {
                    todosMuertos = false;
                }
            }

            if (todosMuertos) {
            // Si TODOS muertos = fin del juego
                System.out.println("Jugador " + (jugador + 1) + " gana");
                break;
            }

            System.out.println("Elige otro personaje:");

            for (int i = 0; i < 3; i++) {
                if (vivo[enemigo][i]) {
                    System.out.println((i + 1) + ". " + nombres[enemigo][i]);
                }
            }

            int otro = leer.nextInt() - 1;

            while (otro < 0 || otro > 2 || !vivo[enemigo][otro]) {
                System.out.println("Elige valido");
                otro = leer.nextInt() - 1;
            }

            actual[enemigo] = otro; // Nuevo personaje activo
        }

        turno++; // Cambia al siguiente turno
    } 
    }
}