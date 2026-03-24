/* Luis Manuel Aguilera Montoya
Desarrollar un sistema de batalla por turnos entre dos jugadores con múltiples opciones de combate.

REQUERIMIENTOS FUNCIONALES
Registro de héroes (MATRICES)
Crear las siguientes matrices:
String[][] nombres = new String[2][3];
int[][] vida = new int[2][3];
int[][] ataque = new int[2][3];
int[][] magia = new int[2][3];
int[][] energia = new int[2][3];
boolean[][] vivo = new boolean[2][3];
int[][] curaciones = new int[2][3];
Cada jugador debe tener 3 héroes.

Datos obligatorios por héroe
Cada héroe debe tener:
• Nombre
• Vida
• Ataque
• Magia
• Energia inicial
• Estado (vivo = true)
• Contador de curaciones (inicia en 0)
*/

import java.util.Scanner;


public class RTO1_SEM8_2C_BatallaRPG
{

    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        
        //Registro de héroes (MATRICES)
        int [] heroe_seleccionado = new int[2];
        int gasto_de_energia = 10; //El gasto de mana por hechizo
        int valor_curacion = 30;

        String[][] nombre = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        
        boolean jugadorVivo1 = true, jugadorVivo2 = true;
        int j1 = 0, j2 = 1;


        System.out.println("##### Simulador de Batalla Pokémon #####\n");

        //ASIGNACION DE ESTADISTICAS
        for (int i = 0; i < 2; i++)
        {
            System.out.println("\n----- Equipo de héroes del JUGADOR " + (i + 1) + " -----");
            for (int j = 0; j < 3; j++)
            {
                System.out.print("Nombre: ");
                nombre[i][j] = entrada.nextLine();

                System.out.print("Vida: ");
                vida[i][j] = entrada.nextInt();

                System.out.print("Ataque: ");
                ataque[i][j] = entrada.nextInt();

                System.out.print("Magia: ");
                magia[i][j] = entrada.nextInt();

                System.out.print("Energia inicial (Mana máximo): ");
                energia[i][j] = entrada.nextInt();

                curaciones[i][j] = 2;
                vivo[i][j] = true;

                entrada.nextLine(); //Limpiar buffer
                System.out.println();
            }
        }


        // PRIMERA SELECCION DE PERSONAJES
        for (int i = 0; i < 2; i++) //int turno = 0; //0 = Jugador1 , 1 = Jugador2;
        {
            System.out.println("----- Seleccion de héroes 'Jugador " + (i + 1) + " -----");
            System.out.println("Que héroe quieres seleccionar? Escribe el numero... 1)" + nombre[i][0] + " 2)" + nombre[i][1] + " 3)" + nombre[i][2]);  
            heroe_seleccionado[i] = entrada.nextInt();
            heroe_seleccionado[i] -= 1; //Para que me de la posición del heroe, que el usuario ingresa del 1 al 3, y las posiciones van del 0 al 2
        }
                
        //Mostrar héroes seleccionados
        System.out.println("\nEl jugador 1 selecciona a " + nombre[0][heroe_seleccionado[0]]);
        System.out.println("El jugador 2 selecciona a " + nombre[1][heroe_seleccionado[1]] + "\n");


        //##### COMIENZA LA BATALLA ######
        while (jugadorVivo1 == true && jugadorVivo2 == true)
        {
            int [] movimiento = new int[2];


            //Si un heroe ha sido derrotado cambiar J1
            if (vida[j1][heroe_seleccionado[j1]] <= 0)
            {
                System.out.println("\n----- Seleccion de héroes 'Jugador " + (j1 + 1) + " -----");
                System.out.println("Tu héroe fue derrotado, selecciona otro: Escribe el numero... 1)" + nombre[j1][0] + " 2)" + nombre[j1][1] + " 3)" + nombre[j1][2]);  
                heroe_seleccionado[j1] = entrada.nextInt();
                heroe_seleccionado[j1] -= 1; //Para que me de la posición del heroe, que el usuario ingresa del 1 al 3, y las posiciones van del 0 al 2
            }

            //Si un heroe ha sido derrotado cambiar J2
            if (vida[j2][heroe_seleccionado[j2]] <= 0)
            {
                System.out.println("\n----- Seleccion de héroes 'Jugador " + (j2 + 1) + " -----");
                System.out.println("Tu héroe fue derrotado, selecciona otro: Escribe el numero... 1)" + nombre[j2][0] + " 2)" + nombre[j2][1] + " 3)" + nombre[j2][2]);  
                heroe_seleccionado[j2] = entrada.nextInt();
                heroe_seleccionado[j2] -= 1; //Para que me de la posición del heroe, que el usuario ingresa del 1 al 3, y las posiciones van del 0 al 2
            }

            //SELECCION DE MOVIMIENTOS
            for (int i = 0; i < 2; i++)   
            {
                boolean accion_terminada = false;
                
                //Switch y while para controlar exepciones y opciones
                while(accion_terminada == false)
                {    
                    System.out.println("----- Menu de opciones JUGADOR" + (i +  1) + "  -----");
                    System.out.println("1. Ataque fisico \n2. Ataque mágico \n3. Curarse \n4. Cambiar héroe");
                    movimiento[i] = entrada.nextInt();

                    switch (movimiento[i])
                    {
                        case 1 -> //Ataque fisico
                        {
                            accion_terminada = true;                            
                        }
                        case 2 -> //Ataque mágico
                        {
                            if (energia[i][heroe_seleccionado[i]] >= 10)
                            {  
                                accion_terminada = true;
                            }
                            else
                            {
                                System.out.println("No tienes suficiente energia para el ataque...");
                            }
                        }
                        case 3 -> //Curarse
                        {
                            if(curaciones[i][heroe_seleccionado[i]] > 0)
                            {
                                accion_terminada = true;
                            }
                            else
                            {
                                System.out.println("No te quedan más curaciones para este personaje...");
                            }
                        }
                        case 4 -> //Cambiar de héroe
                        {
                                while (true)
                                {   
                                    int opcion = 0;
                                    System.out.println("Que héroe quieres seleccionar? Escribe el numero... 1)" + nombre[i][0] + " 2)" + nombre[i][1] + " 3)" + nombre[i][2]);
                                    opcion = entrada.nextInt();
                                    opcion -= 1; //Para que me de la posición del heroe, que el usuario ingresa del 1 al 3, y las posiciones van del 0 al 2
                                    
                                    //Selecciona el mismo heroe, se repite turno
                                    if (opcion == heroe_seleccionado[i]) 
                                    {
                                        System.out.println("Seleccionaste al mismo héroe...");
                                        break;
                                    }
                                    
                                    if (opcion > 2 || opcion < 0) //Control de exepciones
                                    {
                                        System.out.println("Opción de héroe inválida...");
                                    }
                                    else if (vida[i][opcion] <= 0) //Si el héroe esta debilitado
                                    {
                                        System.out.println("Este héroe esta derrotado... Seleccione otro");
                                    }
                                    else
                                    {  
                                        heroe_seleccionado[i] = opcion;
                                        System.out.println("El jugador " + (i + 1) + "cambia al héroe " + nombre[i][heroe_seleccionado[i]]);
                                        accion_terminada = true;
                                        break;
                                    }   
                                }
                        }
                        default ->
                        {
                            System.out.println("Opción inválida. Ingrese de nuevo...");
                        }
                    }   
                }
            }
            //pelea

            while (true)
            {
                int prob, daño;
                //TURNO DE JUGADOR
                    
                //Criticos para jugador 1
                prob = (int)(Math.random() * 100);

                //JUGADOR 1: Switch de acciones efectivas 
                switch (movimiento[j1])
                {
                    case 1 -> //Ataque fisico
                    {
                        System.out.println("\n" + nombre[j1][heroe_seleccionado[j1]] + " realiza un ataque fisico!");
                        daño = ataque[j1][heroe_seleccionado[j1]];

                        if (prob < 20)
                        {
                            daño *= 2;
                            System.out.println("¡Golpe crítico!");
                        }

                        vida[j2][heroe_seleccionado[j2]] -= daño;

                        //Verificar si el heroe fue debilitado
                        System.out.println(nombre[j2][heroe_seleccionado[j2]] + " pierde " + daño + " de vida");
                        if (vida[j2][heroe_seleccionado[j2]] > 0)
                            System.out.print("   |   Vida restante: " + vida[j2][heroe_seleccionado[j2]]);
                        else
                        {
                            System.out.println("El heroe del jugador 2 ha sido derrotado");
                            break;
                        }   
                    }
                    case 2 ->
                    {
                        System.out.println("\n" + nombre[j1][heroe_seleccionado[j1]] + " realiza un ataque mágico!");
                        daño = magia[j1][heroe_seleccionado[j1]];
                        energia[j1][heroe_seleccionado[j1]] -= gasto_de_energia;

                        if (prob < 20)
                        {
                            daño *= 2;
                            System.out.println("¡Golpe crítico!");
                        }

                        vida[j2][heroe_seleccionado[j2]] -= daño;

                        //Verificar si el heroe fue debilitado
                        System.out.println(nombre[j2][heroe_seleccionado[j2]] + " pierde " + daño + " de vida");
                        if (vida[j2][heroe_seleccionado[j2]] > 0)
                            System.out.print("   |   Vida restante: " + vida[j2][heroe_seleccionado[j2]]);
                        else
                        {
                            System.out.println("El heroe del jugador 2 ha sido derrotado");
                            break;
                        }   
                    }
                    case 3 ->
                    {
                        vida[j1][heroe_seleccionado[j1]] += valor_curacion;
                        curaciones[j1][heroe_seleccionado[j1]] -= 1;
                    }
                }
                    
                //Criticos para jugador 2
                prob = (int)(Math.random() * 100);

                //JUGADOR 2: Switch de acciones efectivas 
                if(vida[j2][heroe_seleccionado[j2]] > 0)
                {
                switch (movimiento[j2])
                {
                    case 1 -> //Ataque fisico
                    {
                        System.out.println("\n" + nombre[j2][heroe_seleccionado[j2]] + " realiza un ataque fisico!");
                        daño = ataque[j2][heroe_seleccionado[j2]];

                        if (prob < 20)
                        {
                            daño *= 2;
                            System.out.println("¡Golpe crítico!");
                        }

                        vida[j1][heroe_seleccionado[j1]] -= daño;

                        //Verificar si el heroe fue debilitado
                        System.out.println(nombre[j1][heroe_seleccionado[j1]] + " pierde " + daño + " de vida");
                        if (vida[j1][heroe_seleccionado[j1]] > 0)
                            System.out.print("   |   Vida restante: " + vida[j1][heroe_seleccionado[j1]]);
                        else
                        {
                            System.out.println("El heroe del jugador 1 ha sido derrotado");
                            break;
                        }   
                    }
                    case 2 ->
                    {
                        System.out.println("\n" + nombre[j2][heroe_seleccionado[j2]] + " realiza un ataque mágico!");
                        daño = magia[j2][heroe_seleccionado[j2]];
                        energia[j1][heroe_seleccionado[j1]] -= gasto_de_energia;

                        if (prob < 20)
                        {
                            daño *= 2;
                            System.out.println("¡Golpe crítico!");
                        }

                        vida[j1][heroe_seleccionado[j1]] -= daño;

                        //Verificar si el heroe fue debilitado
                        System.out.println(nombre[j1][heroe_seleccionado[j1]] + " pierde " + daño + " de vida");
                        if (vida[j1][heroe_seleccionado[j1]] > 0)
                            System.out.print("   |   Vida restante: " + vida[j1][heroe_seleccionado[j1]]);
                        else
                        {
                            System.out.println("El heroe del jugador 2 ha sido derrotado");
                            break;
                        }   
                    }
                    case 3 ->
                    {
                        vida[j2][heroe_seleccionado[j2]] += valor_curacion;
                        curaciones[j2][heroe_seleccionado[j2]] -= 1;
                    }
                }  
                }          
                    break; //Para terminar el turno si ningun heroe fue derrotado
            }


            //RESULTADOS DE COMBATE: Si ya fueron debilitados los heroes de alguien acaba el combate
            if((vida[j1][0] <= 0) && (vida[j1][1] <= 0 ) && (vida[j1][2] <= 0)) 
            {
                System.out.println("El JUGADOR 2 ha ganado el combate!");
                jugadorVivo1 = false;
            }
            if ((vida[j2][1] <= 0) && (vida[j2][1] <= 0 ) && (vida[j2][2] <= 0))
            {
                System.out.println("El JUGADOR 1 ha ganado el combate!");
                jugadorVivo2 = false; 
            }
        }
    }
}
