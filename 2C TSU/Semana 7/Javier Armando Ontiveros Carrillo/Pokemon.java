package pokemon;
import java.util.Scanner;

public class Pokemon {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        final int NUM_CRIATURAS_POR_JUGADOR = 3;
        
        String[][][] criaturas = new String[2][NUM_CRIATURAS_POR_JUGADOR][3];
        
        int[] criaturasVivas = {NUM_CRIATURAS_POR_JUGADOR, NUM_CRIATURAS_POR_JUGADOR};
        
        System.out.println("--- Registro de Criaturas ---");
        
        for (int jugadorActual = 0; jugadorActual < 2; jugadorActual++) {
            System.out.println("\n--- Jugador " + (jugadorActual + 1) + " ---");
            for (int i = 0; i < NUM_CRIATURAS_POR_JUGADOR; i++) {
                System.out.println("Registrando Criatura #" + (i + 1) + " para Jugador " + (jugadorActual + 1));
                
                System.out.print("Nombre de la criatura: ");
                criaturas[jugadorActual][i][0] = leer.nextLine();
                
                int vida = -1;
                while (vida < 0) {
                    System.out.print("Vida (HP) de " + criaturas[jugadorActual][i][0] + ": ");
                    try {
                        vida = leer.nextInt();
                        if (vida < 0) {
                            System.out.println("La vida no puede ser negativa. Inténtalo de nuevo.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, ingresa un número entero para la vida.");
                        vida = -1;
                    }
                    leer.nextLine(); 
                }
                criaturas[jugadorActual][i][1] = String.valueOf(vida);
                
                int ataque = -1;
                while (ataque < 0) {
                    System.out.print("Ataque de " + criaturas[jugadorActual][i][0] + ": ");
                    try {
                        ataque = leer.nextInt();
                        if (ataque < 0) {
                            System.out.println("El ataque no puede ser negativo. Inténtalo de nuevo.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, ingresa un número entero para el ataque.");
                        ataque = -1;
                    }
                    leer.nextLine();
                }
                criaturas[jugadorActual][i][2] = String.valueOf(ataque);
            }
        }
        
        System.out.println("\n--- ¡Comienza la Batalla! ---");
        
        while (criaturasVivas[0] > 0 && criaturasVivas[1] > 0) {
            
            System.out.println("\n--- Turno del Jugador 1 ---");
            
            int criaturaJugador1 = elegirCriatura(leer, criaturas, 0, criaturasVivas);
            
            if (criaturaJugador1 == -1) {
                break; 
            }
            
            int criaturaObjetivoJugador2 = elegirCriaturaObjetivo(leer, criaturas, 1, criaturasVivas);
            if (criaturaObjetivoJugador2 == -1) {
                break; 
            }
            
            atacar(criaturas, 0, criaturaJugador1, 1, criaturaObjetivoJugador2, criaturasVivas);
            
            if (criaturasVivas[1] == 0) {
                break; 
            }
            
            System.out.println("\n--- Turno del Jugador 2 ---");
            
            int criaturaJugador2 = elegirCriatura(leer, criaturas, 1, criaturasVivas);
            if (criaturaJugador2 == -1) {
                break;
            }
            
            int criaturaObjetivoJugador1 = elegirCriaturaObjetivo(leer, criaturas, 0, criaturasVivas);
            if (criaturaObjetivoJugador1 == -1) {
                break;
            }
            
            atacar(criaturas, 1, criaturaJugador2, 0, criaturaObjetivoJugador1, criaturasVivas);
            
            if (criaturasVivas[0] == 0) {
                break;
            }
        }
        
        System.out.println("\n--- Fin de la Batalla ---");
        if (criaturasVivas[0] == 0) {
            System.out.println("¡El Jugador 2 ha ganado la batalla!");
        } else if (criaturasVivas[1] == 0) {
            System.out.println("¡El Jugador 1 ha ganado la batalla!");
        } else {
            
            System.out.println("La batalla ha terminado de forma inesperada.");
        }
        
    }

    public static int elegirCriatura(Scanner scanner, String[][][] criaturas, int jugadorIndex, int[] criaturasVivas) {
        System.out.println("Criaturas disponibles para el Jugador " + (jugadorIndex + 1) + ":");
        int jugadorActual = 0;
        int[] indicesCriaturasVivas = new int[criaturasVivas[jugadorActual]]; 
        int contadorVivas = 0;
        
        for (int i = 0; i < criaturas[jugadorActual].length; i++) {
            
            if (Integer.parseInt(criaturas[jugadorActual][i][1]) > 0) {
                System.out.println("  " + (contadorVivas + 1) + ". " + criaturas[jugadorActual][i][0] +
                                   " (HP: " + criaturas[jugadorActual][i][1] + ", Ataque: " + criaturas[jugadorActual][i][2] + ")");
                indicesCriaturasVivas[contadorVivas] = i; 
                contadorVivas++;
            }
        }
        
        if (contadorVivas == 0) {
            System.out.println("¡Todas tus criaturas han sido derrotadas!");
            return -1;
        }

        int eleccion = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Elige una criatura para atacar (ingresa el número): ");
            try {
                eleccion = scanner.nextInt();
                scanner.nextLine();
                
                if (eleccion >= 1 && eleccion <= contadorVivas) {
                    entradaValida = true;
                } else {
                    System.out.println("Selección inválida. Por favor, elige un número entre 1 y " + contadorVivas + ".");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
            }
        }
        
        return indicesCriaturasVivas[eleccion - 1];
    }
    
    public static int elegirCriaturaObjetivo(Scanner scanner, String[][][] criaturas, int jugadorOponenteIndex, int[] criaturasVivas) {
        System.out.println("Criaturas del Jugador " + (jugadorOponenteIndex + 1) + " para atacar:");
        int[] indicesCriaturasVivasOponente = new int[criaturasVivas[jugadorOponenteIndex]];
        int contadorVivasOponente = 0;
        
        for (int i = 0; i < criaturas[jugadorOponenteIndex].length; i++) {
            if (Integer.parseInt(criaturas[jugadorOponenteIndex][i][1]) > 0) {
                System.out.println("  " + (contadorVivasOponente + 1) + ". " + criaturas[jugadorOponenteIndex][i][0] +
                                   " (HP: " + criaturas[jugadorOponenteIndex][i][1] + ")");
                indicesCriaturasVivasOponente[contadorVivasOponente] = i;
                contadorVivasOponente++;
            }
        }
        
        if (contadorVivasOponente == 0) {
            return -1; 
        }

        int eleccion = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Elige a qué criatura del oponente atacar (ingresa el número): ");
            try {
                eleccion = scanner.nextInt();
                scanner.nextLine(); 

                if (eleccion >= 1 && eleccion <= contadorVivasOponente) {
                    entradaValida = true;
                } else {
                    System.out.println("Selección inválida. Por favor, elige un número entre 1 y " + contadorVivasOponente + ".");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine(); 
            }
        }
        return indicesCriaturasVivasOponente[eleccion - 1];
    }
    
    public static void atacar(String[][][] criaturas, int atacanteJugadorIndex, int atacanteCriaturaIndex,
                             int defensorJugadorIndex, int defensorCriaturaIndex, int[] criaturasVivas) {
        
        String nombreAtacante = criaturas[atacanteJugadorIndex][atacanteCriaturaIndex][0];
        int ataqueAtacante = Integer.parseInt(criaturas[atacanteJugadorIndex][atacanteCriaturaIndex][2]);
        String nombreDefensor = criaturas[defensorJugadorIndex][defensorCriaturaIndex][0];
        int vidaDefensorActual = Integer.parseInt(criaturas[defensorJugadorIndex][defensorCriaturaIndex][1]);
        
        int danio = ataqueAtacante; 
        
        vidaDefensorActual -= danio;
        
        System.out.println(nombreAtacante + " ataca a " + nombreDefensor + "!");
        System.out.println("Inflige " + danio + " puntos de daño.");
        System.out.println("Vida restante de " + nombreDefensor + ": " + vidaDefensorActual);
        
        criaturas[defensorJugadorIndex][defensorCriaturaIndex][1] = String.valueOf(vidaDefensorActual);
        
        if (vidaDefensorActual <= 0) {
            System.out.println(nombreDefensor + " ha sido derrotado!");
            
            criaturasVivas[defensorJugadorIndex]--;
        }
    }
}
