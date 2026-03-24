/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package goldenaxe;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class GoldenAxe {

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
        int[][] magia = new int[2][3];
        int[][] mana = new int[2][3];
        int[][] usodepociones = new int[2][3];
        int debilitadosR1 = 0;
        int debilitadosB2 = 0;
        int estadoR1 = 0; 
        int estadoB2 = 0; 
        //variables//

   
        for (int x = 0; x < 2; x++)//primer lector para la matriz bidimensional//
        {
        System.out.println("Invocador" + (x + 1) + " invoque a sus guerreros");
        for (int n = 0; n < 3; n++)//segundo lector bidimensional//
        {
        System.out.println("Nombre a sus guerrero " + (n + 1) + ":");
        nombres[x][n] = leer.nextLine();//lector de los campeones//
        
        Hp[x][n] = 100;
        Hpreal [x][n] = 100;
        ataque[x][n] = 15;
        magia [x][n] = 30;
        mana [x] [n] = 80;
        usodepociones [x][n] = 2;
        //declaraion de los stats base de los campeones//
                 
      
            }
        }

        boolean combate = true;
        //entrada a la interfaz del juego/7

        while (combate)
        //declaracion para el inicio del juego//
        {
        System.out.println("Invocador, que haras?");
        System.out.println("1.- Atacar");
        System.out.println("2.- Usar pocion (la pocion reestablece 20 de Hp");
        System.out.println("3.- Ataque magico");
        System.out.println("4.- Evocacion de campeon");
        int accion = leer.nextInt();
        //menu de interaccion//

         switch (accion) 
         //acciones segun la decision del jugador//
         {
          case 1:
          Hp[1][estadoB2] -= ataque[0][estadoR1];
          System.out.println(nombres[0][estadoR1] + " ataca. " + nombres[1][estadoB2] + " perdio " + ataque[0][estadoR1] + " Hp");
          //uso del ataque fisico base del jugador contra el doombot//
                    
          if (ataque[0][estadoR1] > 80) 
          {
           System.out.println("¡Un golpe critico!!!!!!!!");
           }
            break;
            //bloque de ataque//

           case 2:
           if(usodepociones[0][estadoR1]>0)
           if (Hp[0][estadoR1] < Hpreal[0][estadoR1])
           //condiciones de recuperacion del heal//
            {
             Hp[0][estadoR1] += 20;
             if(Hp[0][estadoR1] > Hpreal[0][estadoR1]) Hp[0][estadoR1] = Hpreal[0][estadoR1];
             usodepociones[0][estadoR1]--;
                System.out.println("Pocion usada");
                } else 
                {
                 System.out.println("La vida ya esta completa");
                 //en caso de que la vida ya este llena//
                }
               
                break;
                //bloque de pocion//
                
           case 3:
               if (mana[0][estadoR1] >= 35) 
               {
              Hp[1][estadoB2] -= magia[0][estadoR1];
              mana[0][estadoR1] -= 35;
               System.out.println(nombres[0][estadoR1] + "BigBang Atack !");
               System.out.println(nombres[0][estadoR1] + " ataca. " + nombres[1][estadoB2] + " perdio " + magia[0][estadoR1] + " Hp");
               //bloque de ataque magico//

               } else 
               {
               System.out.println("Mana insuficiente.");
               //en caso de quedarse sin mana suficiente//
               }
               break;
               
           case 4:
               System.out.println("Invocador, selecciona a tu campeon   [0 - 2]");
               //la intruccion debe quedarse en ese intereccion por los principios logicos de los array//
               int invocacion = leer.nextInt();
               if(invocacion >= 0 && invocacion <3)
               { 
               if(Hp[0][invocacion]>0)
               {
               if(invocacion != estadoR1)
               {
                estadoR1 = invocacion;
               }else
               {
              System.out.println("Tu guerrero ya ha sido invocado en el campo");
               }
               }else
               { 
              System.out.println("Tu guerrero ya ha caido; La nigromancia no esta bien vista en nuestras tierras");
               }
               }else
               {
                 System.out.println("?");
               }   
               //bloque de invocacion//
                       
                       
               break;
      }
         
     //aqui empieza la parte divertida, para recordar viejos tiempos, el jugador derrota a un jefe final, turbo bufeado pero no imposible, creo, no lo pude vencer//
         
    if (Hp[1][estadoB2] <= 0) 
    {
    System.out.println("El guerrero" + nombres[1][estadoB2] + " ha caido");
    debilitadosB2++;
    //asegurar de que los guerreros del villano caigan//
    if (debilitadosB2 < 3) {
        estadoB2++;
        System.out.println("El nuevo campeon es " + nombres[1][estadoB2]);
    } else {
        System.out.println("Felicidades, has derrotado a la maldad");
        //en caso de que el villano haya alcanzado tres bajas, osea, victorias para nosotros//
        combate = false; 
    }
    }
         
    if (combate)
    {
    int DeathAdder = (int)(Math.random()*(35-20+1))+10;
    //este es el arreglo para el ataque del jefe final, quite los cambios y el uso de pociones para que lo unico de su lado fuera fuerza bruta y el jugador gane con strat//
    Hp[0][estadoR1] -= DeathAdder;
    System.out.println("El tirano ataca: -" +DeathAdder);
    //declaracion de daño//

    if (Hp[0][estadoR1] <= 0)
    {
    System.out.println("" + nombres[0][estadoR1] + "fue asesinado por la legion del tirano");
    debilitadosR1++;
    //en caso de cada baja//
    if (debilitadosR1 < 3) 
    {
    estadoR1++;
    System.out.println("Siguiente guerrero: " + nombres[0][estadoR1]);
    } else 
    {
    System.out.println("GAME OVER");
    //en caso de las bajas lleguen a 3//
    combate = false;
    }
    }
    }
    }
     
    
      


}
}
    

