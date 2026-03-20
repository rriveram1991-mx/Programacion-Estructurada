import java.util.Scanner;

public class Pokemon 
{
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);

        String[] entrenadores = new String[2];
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        for (int jugador = 0; jugador < 2; jugador++) 
        {
            System.out.println("\n¿Cual es tu nombre, Entrenador " + (jugador + 1) + "?");
            entrenadores[jugador] = leer.next();

            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~REGISTRO DE " + entrenadores[jugador].toUpperCase() + "~~~~~~~~~~~~~~~~~~~~");
            
            for (int pokemon = 0; pokemon < 3; pokemon++) 
            {
                System.out.println("______________________________________________________________");
                System.out.println("Nombre del pokemon " + (pokemon + 1) + ":"); 
                nombres[jugador][pokemon] = leer.next();
                
                System.out.println("______________________________________________________________");
                System.out.println("Vida (HP) de tu pokemonsito " + nombres[jugador][pokemon] + ":");
                vida[jugador][pokemon] = leer.nextInt();
                
                System.out.println("______________________________________________________________");
                System.out.println("Ataque del pokemonsito " + nombres[jugador][pokemon] + ": ");
                ataque[jugador][pokemon] = leer.nextInt();
                System.out.println("______________________________________________________________");
            }
        }

        int derrotasj1 = 0;
        int derrotasj2 = 0;
        
        System.out.println("\n ¡Te han desafiado!, Que comience la batallaaa!!!");

        while (derrotasj1 < 3 && derrotasj2 < 3) 
        {

            int turnopokemonj1 = -1;
            int turnopokemonj2 = -1;

            while (turnopokemonj1 < 0 || turnopokemonj1 > 2 || vida[0][turnopokemonj1] <= 0) 
            {
                System.out.println("\n" + entrenadores[0] + ", elige tu puchamon (1-3):");
                
                for (int i = 0; i < 3; i++) 
                {
                    System.out.println((i + 1) + ". " + nombres[0][i] + " HP: " + vida[0][i]);
                }

                turnopokemonj1 = leer.nextInt() - 1;
            }

            while (turnopokemonj2 < 0 || turnopokemonj2 > 2 || vida[1][turnopokemonj2] <= 0) 
            {
                System.out.println("\n" + entrenadores[1] + ", elige tu puchamon (1-3):");
                
                for (int i = 0; i < 3; i++) 
                {
                    System.out.println((i + 1) + ". " + nombres[1][i] + " HP: " + vida[1][i]);
                }

                turnopokemonj2 = leer.nextInt() - 1;
            }

            System.out.println("\n EL ENFRENTAMIENTO SERA: " + nombres[0][turnopokemonj1] + " vs " + nombres[1][turnopokemonj2]);

            while (vida[0][turnopokemonj1] > 0 && vida[1][turnopokemonj2] > 0) {
                

                int atk1 = ataque[0][turnopokemonj1];
                if (vida[0][turnopokemonj1] < 20) 
                {
                    System.out.println("¡" + nombres[0][turnopokemonj1] + " SE ENFURECE! (Daño x2)");
                    atk1 *= 2;
                }

                int dañoReal1 = (int)(atk1 * (0.8 + Math.random() * 0.4));
                
                System.out.println(nombres[0][turnopokemonj1] + " Lanza un ataque!!");
                vida[1][turnopokemonj2] -= dañoReal1;
                System.out.println(nombres[1][turnopokemonj2] + " HP: " + Math.max(0, vida[1][turnopokemonj2]));
                
                if (vida[1][turnopokemonj2] <= 0) 
                {
                    System.out.println("¡K.O.! " + nombres[1][turnopokemonj2] + " Ha sido derrotado...haha!!");
                    derrotasj2++;
                } 
                else 
                {
 
                    int atk2 = ataque[1][turnopokemonj2];
                    if (vida[1][turnopokemonj2] < 20) 
                    {
                        System.out.println("¡" + nombres[1][turnopokemonj2] + " ENTRA EN RAGE! (Daño x2)");
                        atk2 *= 2;
                    }

                    int dañoReal2 = (int)(atk2 * (0.8 + Math.random() * 0.4));

                    System.out.println(nombres[1][turnopokemonj2] + " Contraatacaa!");
                    vida[0][turnopokemonj1] -= dañoReal2;
                    System.out.println(nombres[0][turnopokemonj1] + " HP: " + Math.max(0, vida[0][turnopokemonj1]));
                    
                    if (vida[0][turnopokemonj1] <= 0) {
                        System.out.println("¡K.O.! " + nombres[0][turnopokemonj1] + " Ha sido derrotadooo...haha!");
                        derrotasj1++;
                    }
                }
                System.out.println("______________________________________________________________");
            }
        }
        
        // --- RESULTADO FINAL ---
        System.out.println("\n_____________________________________________________________________________");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~¡EL TORNEO HA TERMINADO!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        System.out.println("_______________________________________________________________________________");
        
        if (derrotasj1 == 3) {
            System.out.println("¡EL GANADOR ES: " + entrenadores[1].toUpperCase() + "!");
            System.out.println(entrenadores[0] + " se ha quedado sin criaturas.");
        } else {
            System.out.println("¡EL GANADOR ES: " + entrenadores[0].toUpperCase() + "!");
            System.out.println(entrenadores[1] + " se ha quedado sin criaturas.");
        }
        System.out.println("______________________________________________________________________________");
        
        leer.close();
    }
}