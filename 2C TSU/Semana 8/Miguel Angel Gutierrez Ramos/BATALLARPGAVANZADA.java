/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batallarpgavanzada;

import java.util.Scanner;

/**
 *
 * @author miguelgu
 */
public class BATALLARPGAVANZADA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        
        //Este es el registro de los heroes
        for (int j = 0; j < 2; j++) {
            System.out.println("===== Jugador " + (j + 1) + " =====");

            for (int i = 0; i < 3; i++) {
                
                System.out.print("Nombre del heroe #" + (i + 1) + ": ");
                nombres[j][i] = input.nextLine();
                
                System.out.print("Vida: ");
                vida[j][i] = Integer.parseInt(input.nextLine());
                
                System.out.print("Ataque: ");
                ataque[j][i] = Integer.parseInt(input.nextLine());
                
                System.out.print("Magia: ");
                magia[j][i] = Integer.parseInt(input.nextLine());
                
                System.out.print("Energia: ");
                energia[j][i] = Integer.parseInt(input.nextLine());
                
                curaciones[j][i] = 0;
                vivo[j][i] = true;
            }            
        }
        //Aqui cada jugador elige su heroe inicial
        System.out.println("\nJugador 1 elige su heroe:");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + ". " + nombres[0][i]);
        }
        int actual1 = input.nextInt();

        System.out.println("\nJugador 2 elige su heroe:");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + ". " + nombres[1][i]);
        }
        int actual2 = input.nextInt();
        
        //Comienza la batalla
        while (true){
            // se abre el menu para el jugador 1
            System.out.println("\n--- Turno Jugador 1 ---");
            System.out.println("1. Ataque fisico");
            System.out.println("2. Ataque magico");
            System.out.println("3. Curarse");
            System.out.println("4. Cambiar heroe");
            int opc1 = input.nextInt();
            
            if (opc1 > 4 || opc1 < 1){
            System.out.println("Opcion invalida pierdes turno..");
            continue;}
            
            if (opc1 == 4) {
                System.out.println("Elige otro heroe:");
                for (int i = 0; i < 3; i++) {
                    if (vivo[0][i]) {
                        System.out.println(i + ". " + nombres[0][i]);
                    }
                }
                actual1 = input.nextInt();
                if (!vivo[0][actual1]) {
                System.out.println("Ese heroe ha muerto, elige otro.");
                continue;}

            } else if (opc1 == 1){ 
                //Se valida si el heroe esta muerto, encaso de que si tendra que elegir otro.
                if (!vivo[0][actual1]) {
                System.out.println("Tu heroe ha muerto, elige otro");
                for (int i = 0; i < 3; i++) {
                    if (vivo[0][i]) {
                        System.out.println(i + ". " + nombres[0][i]);
                    }
                }
                actual1 = input.nextInt();
                continue; 
                } 
                int daño = ataque[0][actual1];
                
                int prob = (int)(Math.random()*100);
                if (prob < 20){
                    daño *= 2;
                    System.out.println("!!GOLPE CRITICO!!");
                }
                if (!vivo[1][actual2]) {
                    System.out.println("El enemigo está muerto, cambia de heroe:");
                do{
                    for (int i = 0; i < 3; i++) {
                    if (vivo[1][i]) {
                    System.out.println(i + ". " + nombres[1][i]); }
                    }
                    actual2 = input.nextInt();
                    if (!vivo[1][actual2]){
                        System.out.println("Ese tambien esta muerto, elige otro...");
                    }
                }while (!vivo[1][actual2]);
                }
                vida[1][actual2] -= daño;
                //Se verifica si murio el heroe con el ataque
                if (vida[1][actual2] <= 0) {
                vida[1][actual2] = 0;
                vivo[1][actual2] = false;
                System.out.println(nombres[1][actual2] + " esta muerto");
                }
                
                System.out.println(nombres[0][actual1] + " ataca a " + nombres[1][actual2]);
                System.out.println("Daño: " + daño); 
                System.out.println("Vida de "+nombres[1][actual2]+": "+vida[1][actual2]);
            }
            else if (opc1 == 2){
                if (!vivo[0][actual1]) {
                System.out.println("Ese heroe está muerto, elige otro");
                for (int i = 0; i < 3; i++) {
                    if (vivo[0][i]) {
                        System.out.println(i + ". " + nombres[0][i]);
                    }
                }
                actual1 = input.nextInt();
                continue; // Se pone este continue en cada opcion para validar que un heroe muerto no pueda curarse o atacar.
                }   
                if (energia[0][actual1]>=10){
                    int daño = magia[0][actual1];
                    
                    int prob = (int)(Math.random()*100);
                    if (prob < 20){
                        daño *= 2;
                        System.out.println("!GOLPE CRITICO!");
                    }
                    //si el enemigo esta muerto se fuerza al cambio
                    if (!vivo[1][actual2]) {
                    System.out.println("El enemigo está muerto, cambia de heroe:");
                do{
                    for (int i = 0; i < 3; i++) {
                    if (vivo[1][i]) {
                    System.out.println(i + ". " + nombres[1][i]); }
                    }
                    actual2 = input.nextInt();
                    if (!vivo[1][actual2]){
                        System.out.println("Ese tambien esta muerto, elige otro...");
                    }
                }while (!vivo[1][actual2]);
                }
                    vida[1][actual2] -= daño;
                    energia[0][actual1] -= 10;
                    
                    //Verifico si murio el heroe con el ataque
                    if (vida[1][actual2] <= 0) {
                    vida[1][actual2] = 0;
                    vivo[1][actual2] = false;
                    System.out.println(nombres[1][actual2] + " esta muerto");}
                
                System.out.println(nombres[0][actual1] + " ataca a " + nombres[1][actual2]+" con ataque magico!");
                System.out.println("Daño: " + daño); 
                System.out.println("Vida de "+nombres[1][actual2]+": "+vida[1][actual2]);
                } else {
                    System.out.println("Sin energia");
                }
            }
            else if (opc1 == 3){            
                if (!vivo[0][actual1]){
                   System.out.println("No puedes curar a un heroe muerto.");
                }
                else if (curaciones[0][actual1]<2){
                   vida[0][actual1] += 20;
                   curaciones[0][actual1]++;
                   System.out.println(nombres[0][actual1]+" Se ha curado 20 de vida");
                }
                else {
                   System.out.println("Ya no tienes curaciones..");
                }
                    }
                else if (opc1 > 4 || opc1 < 1){
                System.out.println("Opcion invalida pierdes turno..");
                continue;
                }
            // se abre el menu para el jugador 2
            System.out.println("\n--- Turno Jugador 2 ---");
            System.out.println("1. Ataque fisico");
            System.out.println("2. Ataque magico");
            System.out.println("3. Curarse");
            System.out.println("4. Cambiar heroe");
            int opc2 = input.nextInt();
            
            if (opc2 > 4 || opc2 < 1){
            System.out.println("Opcion invalida pierdes turno..");
            continue;}
            
            if (opc2 == 4) {
                System.out.println("Elige otro heroe:");
                for (int i = 0; i < 3; i++) {
                    if (vivo[1][i]) {
                        System.out.println(i + ". " + nombres[1][i]);
                    }
                }
                actual2 = input.nextInt();
                if (!vivo[1][actual2]) {
                System.out.println("Tu heroe ha muerto, elige otro");
                continue;}
            } else if (opc2 == 1){
                if (!vivo[1][actual2]) {
                System.out.println("Tu heroe ha muerto, elige otro");
                for (int i = 0; i < 3; i++) {
                    if (vivo[1][i]) {
                        System.out.println(i + ". " + nombres[1][i]);
                    }
                }
                actual2 = input.nextInt();
                } 
                int daño = ataque[1][actual2];
                
                int prob = (int)(Math.random()*100);
                if (prob < 20){
                    daño *= 2;
                    System.out.println("!!GOLPE CRITICO!!");
                }
                if (!vivo[0][actual1]) {
                    System.out.println("El enemigo está muerto, cambia de heroe:");
                do{
                    for (int i = 0; i < 3; i++) {
                    if (vivo[0][i]) {
                    System.out.println(i + ". " + nombres[0][i]); }
                    }
                    actual1 = input.nextInt();
                    if (!vivo[0][actual1]){
                        System.out.println("Ese tambien esta muerto, elige otro...");
                    }
                }while (!vivo[0][actual1]);
                }
                vida[0][actual1] -= daño;
                //Se verifica si murio el heroe con el ataque
                if (vida[0][actual1] <= 0) {
                vida[0][actual1] = 0;
                vivo[0][actual1] = false;
                System.out.println(nombres[0][actual1] + " esta muerto");
                }
                
                System.out.println(nombres[1][actual2] + " ataca a " + nombres[0][actual1]);
                System.out.println("Daño: " + daño); 
                System.out.println("Vida de "+nombres[0][actual1]+": "+vida[0][actual1]);
            }
            else if (opc2 == 2){
                if (!vivo[1][actual2]) {
                System.out.println("Tu heroe ha muerto, elige otro");
                for (int i = 0; i < 3; i++) {
                    if (vivo[1][i]) {
                        System.out.println(i + ". " + nombres[1][i]);
                    }
                }
                actual2 = input.nextInt();
                continue; // Se pone este continue en cada opcion para validar que un heroe muerto no pueda curarse o atacar y vuelva al menu
                }   
                if (energia[1][actual2]>=10){
                    int daño = magia[1][actual2];
                    
                    int prob = (int)(Math.random()*100);
                    if (prob < 20){
                        daño *= 2;
                        System.out.println("!GOLPE CRITICO!");
                    }
                    if (!vivo[0][actual1]) {
                    System.out.println("El enemigo está muerto, cambia de heroe:");
                do{
                    for (int i = 0; i < 3; i++) {
                    if (vivo[0][i]) {
                    System.out.println(i + ". " + nombres[0][i]); }
                    }
                    actual1 = input.nextInt();
                    if (!vivo[0][actual1]){
                        System.out.println("Ese tambien esta muerto, elige otro...");
                    }
                }while (!vivo[0][actual1]);
                }
                    vida[0][actual1] -= daño;
                    energia[1][actual2] -= 10;
                    
                    //Verifico si murio el heroe con el ataque
                    if (vida[0][actual1] <= 0) {
                    vida[0][actual1] = 0;
                    vivo[0][actual1] = false;
                    System.out.println(nombres[0][actual1] + " ha muerto");}
                
                System.out.println(nombres[1][actual2] + " ataca a " + nombres[0][actual1]+" con ataque magico!");
                System.out.println("Daño: " + daño); 
                System.out.println("Vida de "+nombres[0][actual1]+": "+vida[0][actual1]);
                } else {
                    System.out.println("Sin energia");
                }
            }
            else if (opc2 == 3){            
                if (!vivo[1][actual2]){
                   System.out.println("No puedes curar a un heroe muerto.");
                }
                else if (curaciones[1][actual2]<2){
                   vida[1][actual2] += 20;
                   curaciones[1][actual2]++;
                   System.out.println(nombres[1][actual2]+ " Se ha curado 20 de vida");
                }
                else {
                   System.out.println("Ya no tienes curaciones..");
                }
            }
            boolean vivosJ1 = false;
            boolean vivosJ2 = false;

            // revisamos si gana jugador 1
            for (int i = 0; i < 3; i++) {
            if (vivo[0][i]) {
            vivosJ1 = true; }
            }

            // revisamos si gana jugador 2
            for (int i = 0; i < 3; i++) {
            if (vivo[1][i]) {
            vivosJ2 = true;}
            }

           if (!vivosJ1) {
           System.out.println("Gana Jugador 2");
           break;
           }

          if (!vivosJ2) {
          System.out.println("Gana Jugador 1");
          break;}
                    }
    }  
} 
