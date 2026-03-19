/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exa.pokemon;
 import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author LABTICS
 */
public class EXAPokemon {
 static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
        System.out.println("=====================================");
        System.out.println("     SIMULADOR POKEMON PRO           ");
        System.out.println("=====================================\n");
        
        // ARRAYS COMPLETOS
        String[][] nombres = new String[2][3];
        int[][] vidaMax = new int[2][3];
        int[][] vidaActual = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] defensa = new int[2][3];
        int[][] tipoPokemon = new int[2][3];  // 0=FUEGO,1=AGUA,2=PLANTA,3=ELECTRICO,4=NORMAL
        
        int[] criaturasActivas = {0, 0};
        int[] criaturasVivas = {3, 3};
        
        // REGISTRO CON TIPOS
        registrarPokemonCompleto(nombres, vidaMax, vidaActual, ataque, defensa, tipoPokemon);
        
        System.out.println("\n¡BATALLA INICIADA!\n");
        
        // BATALLA CON MENU Y CALCULOS PRO
        int turno = 0;
        while (criaturasVivas[0] > 0 && criaturasVivas[1] > 0) {
            
            // CAMBIAR POKEMON SI MUERTO
            if (vidaActual[turno][criaturasActivas[turno]] <= 0) {
                System.out.println("\n¡POKEMON DERROTADO! ELIGE NUEVO:");
                mostrarPokemonDisponibles(nombres, vidaActual, turno);
                System.out.print("Elegir (0-2): ");
                criaturasActivas[turno] = scanner.nextInt();
                scanner.nextLine();
            }
            
            int actual = turno;
            int enemigo = 1 - turno;
            
            // ESTADISTICAS COMPLETAS
            mostrarEstadisticasCompletas(nombres, vidaActual, vidaMax, ataque, defensa, tipoPokemon, actual, enemigo, criaturasActivas);
            
            // MENU DE ACCIONES
            System.out.println("OPCIONES:");
            System.out.println("1. ATACAR");
            System.out.println("2. CAMBIAR POKEMON");
            System.out.print("Elije accion: ");
            int accion = scanner.nextInt();
            scanner.nextLine();
            
            if (accion == 1) {
                // ATAQUE CON CALCULO PRO
                atacarConVentajaTipo(actual, enemigo, nombres, vidaActual, ataque, defensa, tipoPokemon, criaturasActivas);
            } else if (accion == 2) {
                System.out.println("¡Cambias de POKEMON!");
                mostrarPokemonDisponibles(nombres, vidaActual, actual);
                System.out.print("Elegir (0-2): ");
                criaturasActivas[actual] = scanner.nextInt();
                scanner.nextLine();
            }
            
            // VERIFICAR DERROTAS
            if (vidaActual[enemigo][criaturasActivas[enemigo]] <= 0) {
                System.out.println("\n¡" + nombres[enemigo][criaturasActivas[enemigo]] + " DERROTADO!");
                criaturasVivas[enemigo]--;
                if (criaturasVivas[enemigo] == 0) {
                    System.out.println("¡JUGADOR " + (enemigo+1) + " SIN POKEMON!");
                    break;
                }
            }
            
            turno = 1 - turno;
            System.out.println("\n" + "=".repeat(45) + "\n");
        }
        
        // GANADOR
        if (criaturasVivas[0] > 0) {
            System.out.println("¡JUGADOR 1 GANA LA BATALLA!");
        } else {
            System.out.println("¡JUGADOR 2 GANA LA BATALLA!");
        }
        
        scanner.close();
    }
    
    // REGISTRO CON TIPOS
    static void registrarPokemonCompleto(String[][] nombres, int[][] vidaMax, int[][] vidaActual,
                                       int[][] ataque, int[][] defensa, int[][] tipoPokemon) {
        String[] nombresTipos = {"FUEGO", "AGUA", "PLANTA", "ELECTRICO", "NORMAL"};
        
        for (int j = 0; j < 2; j++) {
            System.out.println("=== JUGADOR " + (j+1) + " ===");
            for (int i = 0; i < 3; i++) {
                System.out.print("Nombre POKEMON " + (i+1) + ": ");
                nombres[j][i] = scanner.nextLine();
                System.out.print("Vida maxima: ");
                vidaMax[j][i] = vidaActual[j][i] = scanner.nextInt();
                System.out.print("Ataque: ");
                ataque[j][i] = scanner.nextInt();
                System.out.print("Defensa: ");
                defensa[j][i] = scanner.nextInt();
                System.out.print("Tipo (0=FUEGO,1=AGUA,2=PLANTA,3=ELECTRICO,4=NORMAL): ");
                tipoPokemon[j][i] = scanner.nextInt();
                scanner.nextLine();
                System.out.println("  Tipo: " + nombresTipos[tipoPokemon[j][i]] + "\n");
            }
        }
    }
    
    // ESTADISTICAS COMPLETAS
    static void mostrarEstadisticasCompletas(String[][] nombres, int[][] vidaActual, int[][] vidaMax,
                                           int[][] ataque, int[][] defensa, int[][] tipoPokemon,
                                           int actual, int enemigo, int[] criaturasActivas) {
        String[] nombresTipos = {"FUEGO", "AGUA", "PLANTA", "ELECTRICO", "NORMAL"};
        
        System.out.println("JUGADOR " + (actual+1) + ": " + nombres[actual][criaturasActivas[actual]]);
        System.out.printf("HP: %d/%d | ATK:%d | DEF:%d | TIPO:%s\n",
            vidaActual[actual][criaturasActivas[actual]], vidaMax[actual][criaturasActivas[actual]],
            ataque[actual][criaturasActivas[actual]], defensa[actual][criaturasActivas[actual]],
            nombresTipos[tipoPokemon[actual][criaturasActivas[actual]]]);
        
        System.out.println("VS");
        
        System.out.println("JUGADOR " + (enemigo+1) + ": " + nombres[enemigo][criaturasActivas[enemigo]]);
        System.out.printf("HP: %d/%d | ATK:%d | DEF:%d | TIPO:%s\n",
            vidaActual[enemigo][criaturasActivas[enemigo]], vidaMax[enemigo][criaturasActivas[enemigo]],
            ataque[enemigo][criaturasActivas[enemigo]], defensa[enemigo][criaturasActivas[enemigo]],
            nombresTipos[tipoPokemon[enemigo][criaturasActivas[enemigo]]]);
        System.out.println();
    }
    
    // ATAQUE CON VENTAJA DE TIPO Y CALCULO PRO
    static void atacarConVentajaTipo(int actual, int enemigo, String[][] nombres, int[][] vidaActual,
                                   int[][] ataque, int[][] defensa, int[][] tipoPokemon, int[] criaturasActivas) {
        
        // 1. CALCULO BASE
        int danoBase = ataque[actual][criaturasActivas[actual]];
        
        // 2. VENTAJA DE TIPO
        float ventajaTipo = calcularVentajaTipo(tipoPokemon[actual][criaturasActivas[actual]],
                                               tipoPokemon[enemigo][criaturasActivas[enemigo]]);
        
        // 3. REDUCCION POR DEFENSA
        int danoDefensa = Math.max(1, danoBase - defensa[enemigo][criaturasActivas[enemigo]] / 3);
        
        // 4. ALEATORIEDAD (80-120%)
        int danoFinal = (int)(danoDefensa * ventajaTipo * (0.8 + random.nextDouble() * 0.4));
        
        vidaActual[enemigo][criaturasActivas[enemigo]] -= danoFinal;
        if (vidaActual[enemigo][criaturasActivas[enemigo]] < 0) {
            vidaActual[enemigo][criaturasActivas[enemigo]] = 0;
        }
        
        // MOSTRAR DETALLES DEL CALCULO
        String[] nombresTipos = {"FUEGO", "AGUA", "PLANTA", "ELECTRICO", "NORMAL"};
        System.out.println("\n*** " + nombres[actual][criaturasActivas[actual]] + " ATACA! ***");
        System.out.println("Daño base: " + danoBase);
        System.out.println("Ventaja tipo: x" + String.format("%.1f", ventajaTipo) + 
                          " (" + nombresTipos[tipoPokemon[actual][criaturasActivas[actual]]] + 
                          " vs " + nombresTipos[tipoPokemon[enemigo][criaturasActivas[enemigo]] + ")"));
        System.out.println("Daño final: " + danoFinal);
        System.out.println(nombres[enemigo][criaturasActivas[enemigo]] + " recibe " + danoFinal + " daño!");
    }
    
    // SISTEMA DE TIPOS COMPLETO
    static float calcularVentajaTipo(int tipoAtacante, int tipoDefensor) {
        // FUERTE x2
        if (tipoAtacante == 0 && tipoDefensor == 2) return 2.0f; // FUEGO > PLANTA
        if (tipoAtacante == 1 && tipoDefensor == 0) return 2.0f; // AGUA > FUEGO
        if (tipoAtacante == 2 && tipoDefensor == 1) return 2.0f; // PLANTA > AGUA
        if (tipoAtacante == 3 && tipoDefensor == 0) return 2.0f; // ELECTRICO > FUEGO
        
        // DEBIL x0.5
        if (tipoDefensor == 3) return 0.5f; // TODO debil vs ELECTRICO
        
        return 1.0f; // NORMAL
    }
    
    // MOSTRAR POKEMON DISPONIBLES
    static void mostrarPokemonDisponibles(String[][] nombres, int[][] vida, int jugador) {
        System.out.println("TUS POKEMON:");
        for (int i = 0; i < 3; i++) {
            if (vida[jugador][i] > 0) {
                System.out.println(" " + i + " - " + nombres[jugador][i] + " (HP: " + vida[jugador][i] + ")");
            }
        }
    }
}
   
