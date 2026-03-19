/* Luis Manuel Aguilera Montoya
Simulador de Batalla Pokémon (Consola)

Crear un programa en Java que simule una batalla básica entre 2 jugadores usando criaturas tipo Pokémon.

IMPORTANTE:
*Agregue la estadistica de VELOCIDAD: Sirve para que el pokemon más rápido ataca primero (Modifica el orden de turnos)
*Agregue la modificador de CRITICOS Y EVASION: Si sale un 1 el pokemon enemigo evade el ataque, si sale 9 el pokemon atacante daña por 1.5 del ataque
*Agregue la opcion de que el jugador pueda cambiar al pokemon que quiera despues de ser derrotado o derrotar a un pokemon */


import java.util.Scanner;
import java.util.Random;

public class RTO2_SEM7_2C_Pokemon
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        int [][] Jugador = new int[3][4];
        int [][] Rival = new int[3][4];
        String [] nombrePokemonJugador = new String[3];
        String [] nombrePokemonRival = new String[3];

        double daño;
        int num_pokemonRival = 0;              

        System.out.println("##### Simulador de Batalla Pokémon #####\n");
        System.out.println("----- Equipo pokemon del JUGADOR -----");
        for (int i = 0; i < Jugador.length; i++)
        {
            System.out.print("Pokemon: ");
            nombrePokemonJugador[i] = entrada.nextLine();
            Jugador[i][0] = i + 1; //1 , 2 , 3 

            System.out.print("Vida: ");
            Jugador[i][1] = entrada.nextInt();

            System.out.print("Ataque: ");
            Jugador[i][2] = entrada.nextInt();

            System.out.print("Velocidad: ");
            Jugador[i][3] = entrada.nextInt();

            entrada.nextLine(); //Limpiar buffer
            System.out.println();
        }

        System.out.println("\n----- Equipo pokemon del RIVAL -----");
        for (int i = 0; i < Rival.length; i++)
        {
            System.out.print("Pokemon: ");
            nombrePokemonRival[i] = entrada.nextLine();
            Rival[i][0] = i + 1; //1 , 2 , 3 

            System.out.print("Vida: ");
            Rival[i][1] = entrada.nextInt();

            System.out.print("Ataque: ");
            Rival[i][2] = entrada.nextInt();

            System.out.print("Velocidad: ");
            Rival[i][3] = entrada.nextInt();

            entrada.nextLine(); //Limpiar buffer
            System.out.println();
        
        }
        
        System.out.println("Preparate para un combate contra tu RIVAL...");
        
        //ELEGIR POKEMON
        while (true)
        {
            int opcion = 0;
            
            while (true)
            {
                System.out.println("Que pokemon quieres sacar? Escribe el numero... 1)" + nombrePokemonJugador[0] + " 2)" + nombrePokemonJugador[1] + " 3)" + nombrePokemonJugador[2]);  
                opcion = entrada.nextInt();

                if (Jugador[opcion - 1][1] <= 0) //Si el pokemon esta debilitado
                {
                    System.out.println("Ese pokemon esta debilitado... Escoja otro");
                }
                else
                {
                    break;
                }
            }
            
            //Eleccion de pokemon
            System.out.println("\nSacas a " + nombrePokemonJugador[opcion - 1]);
            System.out.println("El rival saca a " + nombrePokemonRival[0] + "\n");
            
            //---------------------------- COMBATE -------------------------------
            Random random_ = new Random();
            int critico;

            if (Jugador[opcion - 1][3] >= Rival[num_pokemonRival][3])
            {
                while (true)
                {
                    //TURNO DE JUGADOR
                    System.out.println("\n" + nombrePokemonJugador[opcion - 1] + " ataca!");
                    daño = Jugador[opcion - 1][2];
                        
                    //Criticos
                    critico = random_.nextInt(10);
                    if (critico == 9) 
                    {
                        daño = daño * 1.5;
                        System.out.println("Fue un golpe critico!");    
                    }
                    if (critico == 0)
                    {
                        daño = 0;
                        System.out.println("El pokemon enemigo evito el ataque...");
                    }

                    //Verificar si el pokemon fue debilitado
                    System.out.println(nombrePokemonRival[num_pokemonRival] + " pierde " + daño + " de vida");
                    Rival[num_pokemonRival][1] -= (int) daño; //Convertir de decimal a entero
                    if (Rival[num_pokemonRival][1] > 0)
                        System.out.println("Vida restante: " + Rival[num_pokemonRival][1]);
                    else
                    {
                        System.out.println("El pokemon del rival ha sido debilitado");
                        num_pokemonRival++;
                        break;
                    }

                    //TURNO RIVAL
                    System.out.println("\n" + nombrePokemonRival[num_pokemonRival] + " ataca!");
                    daño = Rival[num_pokemonRival][2]; 
                    
                    //Criticos
                    critico = random_.nextInt(10);
                    if (critico == 9) 
                    {
                        daño = daño * 1.5;
                        System.out.println("Fue un golpe critico!");    
                    }
                    if (critico == 0)
                    {
                        daño = 0;
                        System.out.println("El pokemon enemigo evito el ataque...");
                    }

                    //Verificar si el pokemon fue debilitado
                    System.out.println(nombrePokemonJugador[opcion-1] + " pierde " + daño + " de vida");
                    Jugador[opcion-1][1] -= (int) daño;
                    if (Jugador[opcion-1][1] > 0)
                        System.out.println("Vida restante: " + Jugador[opcion-1][1]);
                    else
                    {
                        System.out.println("Tu pokemon ha sido debilitado");
                        break;
                    }
                }
            }
            else
            {
                while (true)
                {
                    //TURNO RIVAL
                    System.out.println("\n" + nombrePokemonRival[num_pokemonRival] + " ataca!");
                    daño = Rival[num_pokemonRival][2]; 
                    
                    //Criticos    
                    critico = random_.nextInt(10);
                    if (critico == 9) 
                    {
                        daño = daño * 1.5;
                        System.out.println("Fue un golpe critico!");    
                    }
                    if (critico == 0)
                    {
                        daño = 0;
                        System.out.println("El pokemon enemigo evito el ataque...");
                    }

                    //Verificar si el pokemon fue debilitado
                    System.out.println(nombrePokemonJugador[opcion - 1] + " pierde " + daño + " de vida");
                    Jugador[opcion-1][1] -= (int) daño;
                    if (Jugador[opcion-1][1] >= 0)
                        System.out.println("Vida restante: " + Jugador[opcion - 1][1]);
                    else
                    {
                        System.out.println("Tu pokemon ha sido debilitado");
                        break;
                    }
                        
                    //TURNO DEL JUGADOR
                    System.out.println("\n" + nombrePokemonJugador[opcion - 1] + " ataca!");
                    daño = Jugador[opcion - 1][2];
                        
                    //Criticos    
                    critico = random_.nextInt(10);
                    if (critico == 9) 
                    {
                        daño = daño * 1.5;
                        System.out.println("Fue un golpe critico!");    
                    }
                    if (critico == 0)
                    {
                        daño = 0;
                        System.out.println("El pokemon enemigo evito el ataque...");
                    }
                    
                    //Verificar si el pokemon fue debilitado
                    System.out.println(nombrePokemonRival[num_pokemonRival] + " pierde " + daño + " de vida");
                    Rival[num_pokemonRival][1] -= (int) daño;
                    if (Rival[num_pokemonRival][1] > 0)
                        System.out.println("Vida restante: " + Rival[num_pokemonRival][1]);
                    else
                    {
                        System.out.println("El pokemon del rival ha sido debilitado");
                        num_pokemonRival++;
                        break;
                    }
                }
            }

            //RESULTADOS DE COMBATE: Si ya fueron debilitados los pokemon de alguien acaba el combate
            if((Jugador[0][1] <= 0) && (Jugador[1][1] <= 0 ) && (Jugador[2][1] <= 0)) //Si la suma de la vida de los pokemon del jugador es 0 o menor esta fuera
            {
                System.out.println("El JUGADOR ha perdido el combate...");
                break;
            }
            if ((Rival[0][1] <= 0) && (Rival[1][1] <= 0 ) && (Rival[2][1] <= 0))
            {
                System.out.println("El JUGADOR ha ganado el combate!");
                break;
            }
        }
    }
}
