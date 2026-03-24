package batalla;
import java.util.Scanner;
import java.util.Random;

public class Batalla {
    
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Random random = new Random(); 
        
        final int NUM_JUGADORES = 2;
        final int NUM_HEROES_POR_JUGADOR = 3;
        final int MAX_CURACIONES_POR_HEROE = 2;
        final int COSTO_MAGIA = 10;
        final int VIDA_RECUPERADA_CURA = 20;
        final int PROBABILIDAD_CRITICO = 20;

        String[][] nombres = new String[NUM_JUGADORES][NUM_HEROES_POR_JUGADOR];
        int[][] vida = new int[NUM_JUGADORES][NUM_HEROES_POR_JUGADOR];
        int[][] ataque = new int[NUM_JUGADORES][NUM_HEROES_POR_JUGADOR];
        int[][] magia = new int[NUM_JUGADORES][NUM_HEROES_POR_JUGADOR];
        int[][] energia = new int[NUM_JUGADORES][NUM_HEROES_POR_JUGADOR];
        boolean[][] vivo = new boolean[NUM_JUGADORES][NUM_HEROES_POR_JUGADOR];
        int[][] curaciones = new int[NUM_JUGADORES][NUM_HEROES_POR_JUGADOR];

        
        System.out.println("--- Inicio del Registro de Héroes ---");
        
        for (int j = 0; j < NUM_JUGADORES; j++) {
            System.out.println("\n--- Registro para Jugador " + (j + 1) + " ---");
            for (int i = 0; i < NUM_HEROES_POR_JUGADOR; i++) {
                System.out.println("Registrando Héroe #" + (i + 1) + " para Jugador " + (j + 1));
                
                System.out.print("Nombre del héroe: ");
                nombres[j][i] = leer.nextLine();
                
                vida[j][i] = solicitarEnteroPositivo("Vida inicial de " + nombres[j][i] + ": ", leer);
                
                ataque[j][i] = solicitarEnteroPositivo("Ataque de " + nombres[j][i] + ": ", leer);
                
                magia[j][i] = solicitarEnteroPositivo("Magia de " + nombres[j][i] + ": ", leer);
                
                energia[j][i] = solicitarEnteroPositivo("Energía inicial de " + nombres[j][i] + ": ", leer);
                
                vivo[j][i] = true; 
                
                curaciones[j][i] = 0;

                System.out.println("Héroe '" + nombres[j][i] + "' registrado.");
            }
        }
        
        System.out.println("\n--- ¡Comienza la Batalla! ---");

        int jugadorActual = 0;
        boolean[] jugadoresTienenVivos = {true, true};
        
        while (jugadoresTienenVivos[0] && jugadoresTienenVivos[1]) {
            
            int heroesVivosJugadorActual = contarHeroesVivos(vivo, jugadorActual);
            int heroesVivosOponente = contarHeroesVivos(vivo, 1 - jugadorActual);
            
            jugadoresTienenVivos[jugadorActual] = heroesVivosJugadorActual > 0;
            jugadoresTienenVivos[1 - jugadorActual] = heroesVivosOponente > 0;
            
            if (!jugadoresTienenVivos[1 - jugadorActual]) {
                break;
            }
            
            if (!jugadoresTienenVivos[jugadorActual]) {
                break;
            }


            System.out.println("\n--- Turno del Jugador " + (jugadorActual + 1) + " ---");
            
            int heroeElegido = seleccionarHeroe(nombres, vida, vivo, jugadorActual, leer);
            
            if (heroeElegido == -1) {
                System.out.println("¡Todas tus criaturas han sido derrotadas! No puedes continuar.");
                jugadoresTienenVivos[jugadorActual] = false;
                break; 
            }
            
            int opcionAccion = -1;
            boolean turnoTerminado = false;

            while (!turnoTerminado) {
                
                mostrarEstadoHeroe(nombres, vida, ataque, magia, energia, vivo, curaciones, jugadorActual, heroeElegido);
                mostrarMenuAcciones();
                
                opcionAccion = solicitarEnteroEntre(
                    "Selecciona una acción: ", leer, 1, 4
                );
                
                switch (opcionAccion) {
                    case 1: 
                        realizarAtaqueFisico(nombres, vida, ataque, vivo, curaciones, energia, magia,
                                             jugadorActual, heroeElegido, 1 - jugadorActual,
                                             random, PROBABILIDAD_CRITICO, jugadoresTienenVivos);
                        turnoTerminado = true; 
                        break;

                    case 2:
                        realizarAtaqueMagico(nombres, vida, ataque, magia, energia, vivo, curaciones,
                                             jugadorActual, heroeElegido, 1 - jugadorActual,
                                             COSTO_MAGIA, random, PROBABILIDAD_CRITICO, jugadoresTienenVivos);
                        turnoTerminado = true;
                        break;

                    case 3:
                        realizarCuracion(vida, curaciones, vivo, jugadorActual, heroeElegido,
                                         MAX_CURACIONES_POR_HEROE, VIDA_RECUPERADA_CURA);
                        
                        break;

                    case 4:
                        int nuevoHeroe = seleccionarHeroe(nombres, vida, vivo, jugadorActual, leer);
                        if (nuevoHeroe != -1) {
                            heroeElegido = nuevoHeroe;
                            System.out.println("Héroe cambiado a: " + nombres[jugadorActual][heroeElegido]);
                            
                        } else {
                            System.out.println("No puedes cambiar de héroe, todos tus otros héroes están muertos.");
                            
                        }
                        break;
                }
                
                if (turnoTerminado) {
                    
                    heroesVivosOponente = contarHeroesVivos(vivo, 1 - jugadorActual);
                    jugadoresTienenVivos[1 - jugadorActual] = heroesVivosOponente > 0;
                    
                    if (!jugadoresTienenVivos[1 - jugadorActual]) {
                        break;
                    }
                }
            }
            
            if (jugadoresTienenVivos[0] && jugadoresTienenVivos[1]) {
                jugadorActual = 1 - jugadorActual; 
            }

        } 
        
        System.out.println("\n--- Fin de la Batalla ---");
        if (!jugadoresTienenVivos[0]) { 
            System.out.println("¡El Jugador 2 ha ganado la batalla!");
        } else if (!jugadoresTienenVivos[1]) { 
            System.out.println("¡El Jugador 1 ha ganado la batalla!");
        } else {
            System.out.println("La batalla ha terminado.");
        }
    }

    public static int solicitarEnteroPositivo(String mensaje, Scanner scanner) {
        int valor = -1;
        while (valor < 0) {
            System.out.print(mensaje);
            try {
                valor = scanner.nextInt();
                if (valor < 0) {
                    System.out.println("El valor no puede ser negativo. Inténtalo de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                valor = -1; 
            }
            scanner.nextLine();
        }
        return valor;
    }
    
    public static int solicitarEnteroEntre(String mensaje, Scanner scanner, int min, int max) {
        int valor = min - 1; 
        while (valor < min || valor > max) {
            System.out.print(mensaje);
            try {
                valor = scanner.nextInt();
                if (valor < min || valor > max) {
                    System.out.println("Por favor, ingresa un número entre " + min + " y " + max + ".");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                valor = min - 1;
            }
            scanner.nextLine();
        }
        return valor;
    }
    
    public static void mostrarMenuAcciones() {
        System.out.println("\n--- Acciones Disponibles ---");
        System.out.println("1. Ataque Físico");
        System.out.println("2. Ataque Mágico");
        System.out.println("3. Curarse");
        System.out.println("4. Cambiar Héroe");
    }
    
    public static void mostrarEstadoHeroe(String[][] nombres, int[][] vida, int[][] ataque, int[][] magia, int[][] energia,
                                           boolean[][] vivo, int[][] curaciones, int jugadorIndex, int heroeIndex) {
        System.out.println("\n--- Estado de tu Héroe ---");
        System.out.println("Nombre: " + nombres[jugadorIndex][heroeIndex]);
        System.out.println("Vida: " + vida[jugadorIndex][heroeIndex] + " HP");
        System.out.println("Ataque: " + ataque[jugadorIndex][heroeIndex]);
        System.out.println("Magia: " + magia[jugadorIndex][heroeIndex]);
        System.out.println("Energía: " + energia[jugadorIndex][heroeIndex]);
        int MAX_CURACIONES_POR_HEROE = 0;
        System.out.println("Curaciones restantes: " + (MAX_CURACIONES_POR_HEROE - curaciones[jugadorIndex][heroeIndex]));
        System.out.println("Estado: " + (vivo[jugadorIndex][heroeIndex] ? "Vivo" : "Derrotado"));
    }
    
    public static int contarHeroesVivos(boolean[][] vivo, int jugadorIndex) {
        int contador = 0;
        for (int i = 0; i < vivo[jugadorIndex].length; i++) {
            if (vivo[jugadorIndex][i]) {
                contador++;
            }
        }
        return contador;
    }
    
    public static int seleccionarHeroe(String[][] nombres, int[][] vida, boolean[][] vivo, int jugadorIndex, Scanner scanner) {
        System.out.println("Selecciona tu héroe (solo los vivos):");
        
        int[] indicesHeroesVivos = new int[nombres[jugadorIndex].length];
        int contadorVivos = 0;
        
        for (int i = 0; i < nombres[jugadorIndex].length; i++) {
            if (vivo[jugadorIndex][i]) {
                System.out.println("  " + (contadorVivos + 1) + ". " + nombres[jugadorIndex][i] +
                                   " (HP: " + vida[jugadorIndex][i] + ")");
                indicesHeroesVivos[contadorVivos] = i;
                contadorVivos++;
            }
        }
        
        if (contadorVivos == 0) {
            System.out.println("¡Todas tus criaturas han sido derrotadas!");
            return -1;
        }

        int eleccion = solicitarEnteroEntre("Ingresa el número de tu héroe: ", scanner, 1, contadorVivos);

        return indicesHeroesVivos[eleccion - 1];
    }
    
public static void realizarAtaqueFisico(String[][] nombres, int[][] vida, int[][] ataque, boolean[][] vivo, int[][] curaciones, int[][] energia, int[][] magia, int jugadorAtacanteIndex, int defensorJugadorIndex, int heroeDefensorIndex) {
}

    private static void realizarAtaqueFisico(String[][] nombres, int[][] vida, int[][] ataque, boolean[][] vivo, int[][] curaciones, int[][] energia, int[][] magia, int jugadorActual, int heroeElegido, int i, Random random, int PROBABILIDAD_CRITICO, boolean[] jugadoresTienenVivos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void realizarAtaqueMagico(String[][] nombres, int[][] vida, int[][] ataque, int[][] magia, int[][] energia, boolean[][] vivo, int[][] curaciones, int jugadorActual, int heroeElegido, int i, int COSTO_MAGIA, Random random, int PROBABILIDAD_CRITICO, boolean[] jugadoresTienenVivos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void realizarCuracion(int[][] vida, int[][] curaciones, boolean[][] vivo, int jugadorActual, int heroeElegido, int MAX_CURACIONES_POR_HEROE, int VIDA_RECUPERADA_CURA) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    }
