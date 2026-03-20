/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner (System.in);
        String[][] nombres = new String[2][3];
        int[][] Hp = new int[2][3];
        int[][] Hpreal = new int[2][3];
        int[][] ataque = new int[2][3];
        int debilitadosR1 = 0;
        int debilitadosB2 = 0;
        int estadoR1 = 0; 
        int estadoB2 = 0; 
        //variables//

   
        for (int x = 0; x < 2; x++)//primer lector para la matriz bidimensional//
        {
        System.out.println("Entrenador " + (x + 1) + " elija a su equipo");
        for (int n = 0; n < 3; n++)//segundo lector bidimensional//
        {
        System.out.println("Elija a su pokemon " + (n + 1) + ":");
        nombres[x][n] = leer.nextLine();//lector segun el pokemon elegido//
                
       System.out.println("Establezca el Hp:");
       int Hpcondicional = leer.nextInt();
        Hp[x][n] = Hpcondicional;
        Hpreal[x][n] = Hpcondicional;//puntos de guardado para diferenciar el Hp inicial y aquel que cambia con los ataques//
                
         System.out.println("Establezca el ataque:");
         ataque[x][n] = leer.nextInt();
         leer.nextLine(); //potencia base de ataque//
            }
        }

        boolean combate = true;

        while (combate)
        {
        System.out.println("Entrenador 1 (Bruno), que haras?");
        System.out.println("1.- Atacar");
        System.out.println("2.- Usar pocion (la pocion reestablece 20 de Hp");
        int accion = leer.nextInt();
        //menu de interaccion//

         switch (accion) 
         {
          case 1:
          Hp[1][estadoB2] -= ataque[0][estadoR1];
          System.out.println(nombres[0][estadoR1] + " ataca. " + nombres[1][estadoB2] + " perdio " + ataque[0][estadoR1] + " Hp");
                    
          if (ataque[0][estadoR1] > 80) 
          {
           System.out.println("¡Un golpe critico!!!!!!!!");
           }
            break;
            //bloque de ataque//

           case 2:
           Hp[0][estadoR1] += 20;
           if (Hp[0][estadoR1] > Hpreal[0][estadoR1])
            {
             Hp[0][estadoR1] = Hpreal[0][estadoR1];
             System.out.println("Consejo del profesor Abedul: Cada cosa en su momento.");
                } else 
                {
                 System.out.println(nombres[0][estadoR1] + " ha recuperado 20 HP.");
                }
                break;
                //bloque de pocion//
            }

          
            if (Hp[1][estadoB2] <= 0) 
            {
            System.out.println("¡" + nombres[1][estadoB2] + " se ha debilitado!");
            debilitadosB2++;
                
           if (debilitadosB2 < 3) 
           {
            estadoB2++;
            System.out.println("Aura: ¡Vamos " + nombres[1][estadoB2]);
            //contador de debilitaciones para jugador 2//
            } else
           {
             System.out.println("La entrenadora Aura no tiene mas pokemon. ¡La victoria es para Bruno!");
             combate = false;
              break; 
                }
            }

            if (combate)
            {
            Hp[0][estadoR1] -= ataque[1][estadoB2];
            System.out.println(nombres[1][estadoB2] + " ataca a " + nombres[0][estadoR1]);
            System.out.println("HP restante de " + nombres[0][estadoR1] + ": " + Hp[0][estadoR1]);

            if (Hp[0][estadoR1] <= 0) 
            {
             System.out.println("¡" + nombres[0][estadoR1] + " se ha debilitado!");
             debilitadosR1++;

           if (debilitadosR1 < 3) 
            {
             estadoR1++;
             System.out.println("Bruno: ¡Adelante " + nombres[0][estadoR1] + "!");
             } else 
           {
            System.out.println("El entrenador Bruno no tiene mas pokemon. ¡La victoria es para Aura!");
            combate = false;
            //bloque de debiltacion y combate para el jugador1//
                    }
                }
            }
        } 
    } 
     
   
     
     
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
     }
     
    
    } 


         
     
     
        
        
        
        
        
        
    }
    
