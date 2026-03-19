/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s7.pokemon;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class S7Pokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 

        // scanner para leer datos
        Scanner leer = new Scanner(System.in);

        // matrices para guardar datos de los pokemon
        String[][] nombres = new String[2][3]; // guarda nombres [jugador][pokemon]
        int[][] vida = new int[2][3]; // guarda vida actual
        int[][] vidaBase = new int[2][3]; // guarda vida maxima
        int[][] ataque = new int[2][3]; // guarda ataque

        // REGISTRO DE POKEMONES
        for (int j = 0; j < 2; j++) { // recorre los 2 jugadores
            System.out.println("Jugador " + (j + 1));

            for (int i = 0; i < 3; i++) {  // cada jugador registra solo 3 pokemon

                System.out.print("Nombre del Pokemon " + (i + 1) + ": ");
                nombres[j][i] = leer.next(); // guarda el nombre

                System.out.print("Vida: ");
                while (!leer.hasNextInt()) { // valida que sea numero
                    System.out.println("Error: Ingresa un numero");
                    leer.next();  // limpia dato incorrecto
                }
                vida[j][i] = leer.nextInt(); // guarda vida actual
                vidaBase[j][i] = vida[j][i];// guarda vida maxima

                System.out.print("Ataque: ");
                while (!leer.hasNextInt()) { //valida numero
                    System.out.println("Error: Ingresa un numero");
                    leer.next();
                }
                ataque[j][i] = leer.nextInt(); //guarda el ataque
            }
        }

        // items para cada cjugador
        int[] pociones = {2, 2}; //cada jugador tiene solo 2 pociones
        int[] boost = {2, 2}; // cada jugador solo tiene 2 aumentos de ataque

        // guarda el pokemon actual que usa cada jugador
        int[] actual = new int[2];

        // contadores de derrotas de cada jugador
        int[] muertos = {0, 0};

        // SELECCION de POKEMONES
        for (int j = 0; j < 2; j++) {

            System.out.println("\nJugador " + (j + 1) + " elige:");

            for (int i = 0; i < 3; i++) {
                // muestra los pokemon disponibles
                System.out.println((i + 1) + ". " + nombres[j][i] + " HP:" + vida[j][i]);
            }

            // validar que sea numero
            while (!leer.hasNextInt()) {
                System.out.println("Error: Ingresa un numero");
                leer.next();
            }

            int eleccion = leer.nextInt() - 1;

            // valida que este en rango y que no este muerto
            while (eleccion < 0 || eleccion > 2 || vida[j][eleccion] == 0) {
                System.out.println("Elige un Pokemon valido");

                while (!leer.hasNextInt()) {
                    leer.next();
                }

                eleccion = leer.nextInt() - 1;
            }

            actual[j] = eleccion; // guarda pokemon seleccionado
        }

        int turno = 0; //controlador de turnos 

        // Inicio de COMBATEs
        while (true) {

            int jugador = turno % 2; // alterna entre jugador 0 y 1

            int enemigo;
            if (jugador == 0) { // si es jugador 1
                enemigo = 1; // el enemigo es jugador 2
            } else {
                enemigo = 0;  // si no, el enemigo es jugador 1
            }

            //muestra informacion del turno
            System.out.println("\nTurno Jugador " + (jugador + 1));
            System.out.println("Pokemon: " + nombres[jugador][actual[jugador]]);
            System.out.println("Vida: " + vida[jugador][actual[jugador]]);
            
            //menu de acciones
            System.out.println("1. Atacar");
            System.out.println("2. Pocion");
            System.out.println("3. Subir ataque");

            // validar numero
            while (!leer.hasNextInt()) {
                System.out.println("Error: Ingresa un numero");
                leer.next();
            }

            int opcion = leer.nextInt();

            // validar rango
            while (opcion < 1 || opcion > 3) {
                System.out.println("Error: opcion invalida (1-3)");

                while (!leer.hasNextInt()) {
                    leer.next();
                }

                opcion = leer.nextInt();
            }

            // ATAQUE
            if (opcion == 1) {

                int dano = ataque[jugador][actual[jugador]]; // obtiene daño

                vida[enemigo][actual[enemigo]] -= dano; // resta vida

                if (vida[enemigo][actual[enemigo]] < 0) {
                    vida[enemigo][actual[enemigo]] = 0;
                }

                //muestra resultados del ataque
                System.out.println("Atacaste");
                System.out.println("Daño: " + dano);
                System.out.println("Vida restante de " + nombres[enemigo][actual[enemigo]] + ": " +  vida[enemigo][actual[enemigo]]);
            }

            // POCION
            else if (opcion == 2) {

                if (pociones[jugador] > 0) {//verifica si se tiene pociones

                    vida[jugador][actual[jugador]] += 20;//suma la vida del pokemon actual

                    //condicion oara no tener mas vida que la vida base o maxima del pokemon
                    if (vida[jugador][actual[jugador]] > vidaBase[jugador][actual[jugador]]) {
                        vida[jugador][actual[jugador]] = vidaBase[jugador][actual[jugador]];
                    }

                    pociones[jugador]--; // se resta una pocion despues de su uso
                    System.out.println("Usaste pocion +20HP");

                } else {
                    System.out.println("No tienes pociones");
                }
            }

            // BOOST
            else if (opcion == 3) {

                if (boost[jugador] > 0) { //verifica que si se tiene mejoras de ataque 
                    ataque[jugador][actual[jugador]] += 5;//aumenta el ataque 
                    boost[jugador]--;
                    System.out.println("Ataque aumentado +5");
                } else {
                    System.out.println("No tienes mejoras");
                }
            }

            // SI MUERE UN POKEMON
            if (vida[enemigo][actual[enemigo]] == 0) {

                System.out.println("Pokemon derrotado");

                muertos[enemigo]++; //suma pokemon muerto

                // condicion para si ya murieron todos
                if (muertos[enemigo] == 3) {
                    System.out.println("Jugador " + (jugador + 1) + " gano la batalla");
                    break; // se termina la batalla
                }

                // elegir otro pokemon
                System.out.println("Elige otro Pokemon:");

                for (int i = 0; i < 3; i++) {
                    if (vida[enemigo][i] > 0) { //solo muestra los pokemon vivos
                        System.out.println((i + 1) + ". " + nombres[enemigo][i]);
                    }
                }

                // validar numero
                while (!leer.hasNextInt()) {
                    leer.next();
                }

                int otro = leer.nextInt() - 1;

                // validar que este vivo
                // no puede elegir un pokemon debilitado
                // solo acepta opcion entre los pokemones disponibles
                while (otro < 0 || otro > 2 || vida[enemigo][otro] == 0) {
                    System.out.println("Elige uno valido");

                    while (!leer.hasNextInt()) {
                        leer.next();
                    }
                    otro = leer.nextInt() - 1;
                }
                actual[enemigo] = otro;//cambia a otro pokemon
            }
            turno++; // cambio de turno 
        }
    }
}