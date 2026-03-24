
package simuladorbatalla.sandra;

import java.util.Scanner;

public class SimuladorBatallaSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

    
        String[][] NOM = new String[2][3];
        int[][] VIDA = new int[2][3];
        int[][] ATAQUE = new int[2][3];

        
       
        System.out.println("--------MENU DE ATAQUES DISPONIBLES---------------");
        System.out.println("1. ATAQUE RAPIDO (+5 DAÑO)");
        System.out.println("2. ATAQUE DOBLE");
        System.out.println("3. ATAQUE TRUENO (PARA QUE EL OTRO JUGADOR TENGA +11 DAÑO)");
        System.out.println("4. ESCUDO");
       
        
        for (int j = 0; j < 2; j++) 
        {
            System.out.println("----------------------------------------------");
            System.out.println("JUGADOR #" + (j+1) + " REGISTRA SUS PERSONAJES");
            
            for (int p = 0; p < 3; p++) 
            {
                System.out.print("INGRESE NOMBRE DEL PERSONAJE  " + (p+1) + ": ");
                NOM[j][p] = leer.nextLine();
                
                System.out.print("INGRESE VIDA DE SU PERSONAJE (DE 1 A 3): ");
                VIDA[j][p] = leer.nextInt();
                
                System.out.print("INGRESE NUMERO DE ATAQUE QUE DESEA USAR: ");
                ATAQUE[j][p] = leer.nextInt();
                System.out.println(".........................................");
                leer.nextLine(); 
            }
        }

    
        int PersonajesRestantes[] = {3, 3};
        boolean PODER[] = {false, false}; 
        int vidasExtra[] = {0, 0}; //PARA GANAR VIDA ADICIONAL

        
        System.out.print("SELECCION PERSONAJE DE JUGADOR 1 (DE 0 a 2): ");
        int p1 = leer.nextInt();
        
        
        System.out.print("SELECCION DE PERSONAJE DE JUGADOR 2 (DE 0 a 2): ");
        int p2 = leer.nextInt();
         System.out.println("----------------------------------------------");
       
        while (PersonajesRestantes[0] > 0 && PersonajesRestantes[1] > 0) 
        {
           
            int DAÑO = ATAQUE[0][p1];
            
            if (PODER[0]) 
            {
                DAÑO *= 2;
                PODER[0] = false;
                System.out.println("¡JUGADOR 1, USO SU PODER!");
            }
           
            VIDA[1][p2] -= DAÑO; 
            System.out.println(NOM[0][p1] + " ATACA! " + NOM[1][p2] + " PERDIO " + DAÑO +"HP DE VIDA.");
            System.out.println("VIDA RESTANTE PARA  " + NOM[1][p2] + ": " + VIDA[1][p2]);

            
            if (VIDA[1][p2] <= 0)
            {
                System.out.println(NOM[1][p2] + " FUE VENCIDO!");
                PersonajesRestantes[1]--;

               
                int PREMIO = (int)(Math.random() * 3); 
                
                switch (PREMIO)
                {
                    case 0: ATAQUE[0][p1] += 5; 
                            System.out.println("PREMIO: ¡ " + NOM[0][p1] + " GANA PODER +5 PARA ATAQUE!"); 
                            break;
                            
                    case 1: PODER[0] = true; 
                            System.out.println("PREMIO: ¡JUGADOR 1 OBTIENE UN PODER ESPECIAL (ATAQUE DOBLE)!"); 
                            break;
                            
                    case 2: vidasExtra[0]++; 
                            System.out.println("GRAN PREMIO: ¡JUGADOR 1 GANA UNA VIDA ADICIONAL!"); 
                            break;
                }

                if (PersonajesRestantes[1] > 0) 
                {
                    System.out.print("JUGADOR 2 SELECCIONE OTRO PERSONAJE: ");
                    p2 = leer.nextInt();
                } else if (vidasExtra[1] > 0) 
                {
                    vidasExtra[1]--;
                    PersonajesRestantes[1] = 1;
                    VIDA[1][p2] = 30;
                    System.out.println("¡JUGADOR 2, REVIVE SU PERSONAJE CON SU VIDA ADICIONAL!");
                } else break;
            }

            if (PersonajesRestantes[1] <= 0) break;

           
            DAÑO = ATAQUE[1][p2];
            if (PODER[1]) {
                DAÑO *= 2;
                PODER[1] = false;
                System.out.println("¡JUGADOR 2, USO SU PODER!");
            }
            VIDA[0][p1] -= DAÑO;
            System.out.println(NOM[1][p2] + " ATACA! " + NOM[0][p1] + " PERDIO " + DAÑO +"HP DE VIDA");
            System.out.println("VIDA RESTANTE PARA " + NOM[0][p1] + ": " + VIDA[0][p1]);

            if (VIDA[0][p1] <= 0) 
            {
                System.out.println(NOM[0][p1] + " FUE VENCIDO!");
                PersonajesRestantes[0]--;

              
                int premio = (int)(Math.random() * 3);
                switch (premio) {
                    case 0: ATAQUE[1][p2] += 5; 
                            System.out.println("PREMIO: ¡" + NOM[1][p2] + " GANA PODER +5 PARA ATAQUE!"); 
                            break;
                    case 1: PODER[1] = true; 
                            System.out.println("PREMIO: ¡JUGADOR 2 OBTIENE UN PODER ESPECIAL (ATAQUE DOBLE)!"); 
                            break;
                    case 2: vidasExtra[1]++; 
                            System.out.println("GRAN PREMIO: ¡JUGADOR 2 GANA UNA VIDA ADICIONAL!"); 
                            break;
                }

                if (PersonajesRestantes[0] > 0) 
                {
                    System.out.print("JUGADOR 1 SELECCIONE OTRO PERSONAJE: ");
                    p1 = leer.nextInt();
                } else if (vidasExtra[0] > 0) 
                {
                    vidasExtra[0]--;
                    PersonajesRestantes[0] = 1;
                    VIDA[0][p1] = 30;
                    System.out.println("¡JUGADOR 2, REVIVE SU PERSONAJE CON SU VIDA ADICIONAL!");
                } else break;
            }
        }

         System.out.println("----------------------------------------------");
        if (PersonajesRestantes[0] > 0) 
        {
            System.out.println("¡GANA JUGADOR 1!");
        } else 
        {
            System.out.println("¡GANA JUGADOR 2!");
        }
    }
}