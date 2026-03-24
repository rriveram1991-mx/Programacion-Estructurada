package batallargp.sandra;

import java.util.Scanner;

public class BatallaRGPSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // MATRICES DE HÉROES
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        int[][] estado = new int[2][3]; // 1 = vivo, 0 = muerto
        int[][] curaciones = new int[2][3];

        // REGISTRAR LOS HEROES
        for (int j = 0; j < 2; j++) 
        {
            
            System.out.println("----------------------------------------------");
            System.out.println("JUGADOR #" + (j+1) + " REGISTRAR HEROES");
            
            for (int h = 0; h < 3; h++) 
            {
                System.out.print("INGRESE NOMBRE DEL HEROE " + (h + 1) + ": ");
                nombres[j][h] = sc.nextLine();
                vida[j][h] = 100;
                ataque[j][h] = 10 + (int)(Math.random() * 10);
                magia[j][h] = 15 + (int)(Math.random() * 10);
                energia[j][h] = 30;
                estado[j][h] = 1; 
                curaciones[j][h] = 0;
            }
        }

        int turno = 0; // 0 JUGADOR1, 1 JUGADOR2

        while (hayVivos(estado[0]) == 1 && hayVivos(estado[1]) == 1) 
        {
            int enemigo;
            if (turno == 0) 
            {
                enemigo = 1;
            } else 
            {
                enemigo = 0;
            }

            System.out.println("-----------------------------------------------");
            System.out.println("\nTURNO JUGADOR # " + (turno + 1));
            
            System.out.println("JUGADOR #"+(turno+1));
            int heroe = elegirHeroe(sc, nombres, estado, turno);

            System.out.println("-----------------------------------------------");
            System.out.println("ACCIONES DE " + nombres[turno][heroe]);
            System.out.println("1. ATAQUE FISICO");
            System.out.println("2. ATAQUE MAGICO");
            System.out.println("3. CURARSE");
            System.out.println("4. CAMBIAR HEROE");
            System.out.print("SELECCIONE UNA ACCION: ");
            int acc= sc.nextInt();
            sc.nextLine();
            System.out.println("----------------------------------------------");
             
            if (acc== 1)
            {
                System.out.println("JUGADOR #"+(enemigo+1));
                int obj= elegirHeroe(sc, nombres, estado, enemigo);
                int daño = ataque[turno][heroe];
                
                if (Math.random() * 100 < 20) 
                {
                    daño *= 2;
                    System.out.println("¡CRITICO!");
                }
                vida[enemigo][obj] -= daño;
                System.out.println(nombres[turno][heroe] + "  GOLPEA A  " + nombres[enemigo][obj] + " CON " + daño+ "HP");
                
                if (vida[enemigo][obj] <= 0) 
                {
                    vida[enemigo][obj] = 0;
                    estado[enemigo][obj] = 0;
                    System.out.println(nombres[enemigo][obj] + " MURIO");
                }
            } else if (acc== 2) 
            {
                if (energia[turno][heroe] >= 10) 
                {
                    int objetivo = elegirHeroe(sc, nombres, estado, enemigo);
                    int daño = magia[turno][heroe];
                    if (Math.random() * 100 < 20)
                    {
                        daño *= 2;
                        System.out.println("¡CRITICO!");
                    }
                    vida[enemigo][objetivo] -= daño;
                    energia[turno][heroe] -= 10;
                    System.out.println(nombres[turno][heroe] + "  LANZA MAGIA A   " + nombres[enemigo][objetivo] + " CON " + daño+ "HP");
                    if (vida[enemigo][objetivo] <= 0) {
                        vida[enemigo][objetivo] = 0;
                        estado[enemigo][objetivo] = 0;
                        System.out.println(nombres[enemigo][objetivo] + " MURIO");
                    }
                } else {
                    System.out.println("NO TIENES ENERGIA");
                }
            } else if (acc== 3) {
                if (curaciones[turno][heroe] < 2) {
                    vida[turno][heroe] += 20;
                    curaciones[turno][heroe]++;
                    System.out.println(nombres[turno][heroe] + "  SE CURO, VIDA: " + vida[turno][heroe]);
                } else {
                    System.out.println(" YA NO PUEDES CURARTE");
                }
            } else if (acc== 4) {
                heroe = elegirHeroe(sc, nombres, estado, turno);
                System.out.println(" CAMBIASTE A " + nombres[turno][heroe]);
            } else {
                System.out.println(" ACCION NO VALIDA");
            }

            if (turno == 0) {
                turno = 1;
            } else {
                turno = 0;
            }
        }

        if (hayVivos(estado[0]) == 1) {
            System.out.println("JUGADOR 1 GANA!");
        } else {
            System.out.println("JUGADOR 2 GANA!");
        }
    }

    // Métodos auxiliares
    public static int hayVivos(int[] heroes) {
        for (int h : heroes) {
            if (h == 1) {
                return 1; // HAY AL MENOS 1 VIVO
            }
        }
        return 0; // TODOS ESTEN MUERTOS
    }

    public static int elegirHeroe(Scanner sc, String[][] nombres, int[][] estado, int jugador)
    {
        int h;
        while (true) 
        {
              System.out.println("ELIGE HEROE:");
            for (int i = 0; i < 3; i++) 
            {
                if (estado[jugador][i] == 1)
                {
                    System.out.println((i + 1) + ". " + nombres[jugador][i]);
                }
            }
            System.out.println("HEROE:");
            h = sc.nextInt() - 1;
            sc.nextLine();
            if (h >= 0 && h < 3 && estado[jugador][h] == 1) 
            {
                return h;
            } else 
            {
                System.out.println("ESE HEROE NO ESTA DISPONIBLE");
            }
        }
    }
}