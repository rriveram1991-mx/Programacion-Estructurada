/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.de.batalla;
 import java.util.Scanner;
/**
 *
 * @author LABTICS
 */
public class SistemaDeBatalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
 Scanner entrada = new Scanner(System.in);
        
        // 2 jugadores, 3 héroes cada uno
        String nombres[][] = new String[2][3];
        int vida[][] = new int[2][3];
        int ataque[][] = new int[2][3];
        int magia[][] = new int[2][3];
        int energia[][] = new int[2][3];
        boolean vivo[][] = new boolean[2][3];
        int curaciones[][] = new int[2][3];
        
        // Poner datos de los héroes (Jugador 1)
        nombres[0][0] = "Caballero"; vida[0][0] = 100; ataque[0][0] = 20; magia[0][0] = 0; energia[0][0] = 30; vivo[0][0] = true; curaciones[0][0] = 0;
        nombres[0][1] = "Mago"; vida[0][1] = 70; ataque[0][1] = 10; magia[0][1] = 30; energia[0][1] = 50; vivo[0][1] = true; curaciones[0][1] = 0;
        nombres[0][2] = "Arquero"; vida[0][2] = 80; ataque[0][2] = 25; magia[0][2] = 15; energia[0][2] = 40; vivo[0][2] = true; curaciones[0][2] = 0;
        
        // Jugador 2 (enemigo)
        nombres[1][0] = "Orco"; vida[1][0] = 65; ataque[1][0] = 22; magia[1][0] = 5; energia[1][0] = 25; vivo[1][0] = true; curaciones[1][0] = 0;
        nombres[1][1] = "Bruja"; vida[1][1] = 110; ataque[1][1] = 100; magia[1][1] = 35; energia[1][1] = 60; vivo[1][1] = true; curaciones[1][1] = 0;
        nombres[1][2] = "Hada"; vida[1][2] = 85; ataque[1][2] = 28; magia[1][2] = 10; energia[1][2] = 35; vivo[1][2] = true; curaciones[1][2] = 0;
        
        System.out.println("¡BATALLA INICIADA!");
        System.out.println("Jugador 1: Caballero(100), Mago(70),Arquero(80)");
        System.out.println("Jugador 2: Orco(110), Bruja(65), Hada(85)\n");
        
        int turnoJugador = 0; // 0 = jugador1, 1 = jugador2
        
        // MIENTRAS AMBOS TIENEN HÉROES VIVOS
        while(true) {
            // revisar si jugador 1 tiene vivos
            boolean p1Vivo = false;
            for(int i=0; i<3; i++) {
                if(vivo[0][i]) { p1Vivo = true; break; }
            }
            
            // revisar si jugador 2 tiene vivos
            boolean p2Vivo = false;
            for(int i=0; i<3; i++) {
                if(vivo[1][i]) { p2Vivo = true; break; }
            }
            
            // Si uno no tiene vivos, termina
            if(!p1Vivo) {
                System.out.println("\n¡JUGADOR 2 GANA!");
                break;
            }
            if(!p2Vivo) {
                System.out.println("\n¡JUGADOR 1 GANA!");
                break;
            }
            
            // TURNO DEL JUGADOR
            if(turnoJugador == 0) {
                System.out.println("TURNO JUGADOR 1 ");
                mostrarMisHeroes(0, nombres, vida, energia, vivo, curaciones);
                
                // Elegir mi héroe
                System.out.print("Elige tu héroe (1,2,3): ");
                int miHeroe = entrada.nextInt() - 1;
                
                // Validar héroe vivo
                while(!vivo[0][miHeroe]) {
                    System.out.print("Ese héroe está muerto! Elige otro: ");
                    miHeroe = entrada.nextInt() - 1;
                }
                
                // Menú simple
                System.out.println("\n1=Ataque normal  2=Magia  3=Curar  4=Cambiar");
                System.out.print("¿Qué haces? ");
                int accion = entrada.nextInt();
                
                // Elegir enemigo
                System.out.print("Ataca a enemigo (1,2,3): ");
                int enemigoHeroe = entrada.nextInt() - 1;
                while(!vivo[1][enemigoHeroe]) {
                    System.out.print("Ese enemigo está muerto! Elige otro: ");
                    enemigoHeroe = entrada.nextInt() - 1;
                }
                
                // EJECUTAR ACCIÓN
                if(accion == 1) {
                    // ATAQUE NORMAL
                    int dano = ataque[0][miHeroe];
                    
                    // CRÍTICO 20% chance
                    int azar = (int)(Math.random() * 100);
                    if(azar < 20) {
                        dano = dano * 2;
                        System.out.println("¡CRÍTICO x2!");
                    }
                    
                    vida[1][enemigoHeroe] = vida[1][enemigoHeroe] - dano;
                    System.out.println(nombres[0][miHeroe] + " hace " + dano + " daño a " + nombres[1][enemigoHeroe]);
                    
                } else if(accion == 2) {
                    // ATAQUE MAGIA
                    if(energia[0][miHeroe] < 10) {
                        System.out.println("¡SIN ENERGÍA!");
                    } else {
                        int dano = magia[0][miHeroe];
                        int azar = (int)(Math.random() * 100);
                        if(azar < 20) {
                            dano = dano * 2;
                            System.out.println("¡MAGIA CRÍTICA!");
                        }
                        
                        vida[1][enemigoHeroe] = vida[1][enemigoHeroe] - dano;
                        energia[0][miHeroe] = energia[0][miHeroe] - 10;
                        System.out.println(nombres[0][miHeroe] + " magia " + dano + " daño (Energía:" + energia[0][miHeroe] + ")");
                    }
                    
                } else if(accion == 3) {
                    // CURAR
                    if(curaciones[0][miHeroe] < 2) {
                        vida[0][miHeroe] = vida[0][miHeroe] + 20;
                        curaciones[0][miHeroe]++;
                        System.out.println(nombres[0][miHeroe] + " se cura +20 (usos:" + curaciones[0][miHeroe] + "/2)");
                    } else {
                        System.out.println("¡SIN MÁS CURACIONES!");
                    }
                    
                } else if(accion == 4) {
                    System.out.println("Cambiaste héroe (sigue tu turno)");
                }
                
            } else {
                // TURNO JUGADOR 2 
                System.out.println("TURNO JUGADOR 2");
                
                //  elige primer héroe vivo
                int iaHeroe = -1;
                for(int i=0; i<3; i++) {
                    if(vivo[1][i]) {
                        iaHeroe = i;
                        break;
                    }
                }
                
                //  elige primer héroe enemigo vivo
                int iaEnemigo = -1;
                for(int i=0; i<3; i++) {
                    if(vivo[0][i]) {
                        iaEnemigo = i;
                        break;
                    }
                }
                
                // decide al azar
                int accionIA = (int)(Math.random() * 4) + 1;
                
                if(accionIA == 1) {
                    // Ataque normal
                    int dano = ataque[1][iaHeroe];
                    int azar = (int)(Math.random() * 100);
                    if(azar < 20) dano = dano * 2;
                    
                    vida[0][iaEnemigo] -= dano;
                    System.out.println(nombres[1][iaHeroe] + " ataca " + dano + " a " + nombres[0][iaEnemigo]);
                    
                } else if(accionIA == 2 && energia[1][iaHeroe] >= 10) {
                    // Magia
                    int dano = magia[1][iaHeroe];
                    int azar = (int)(Math.random() * 100);
                    if(azar < 20) dano = dano * 2;
                    
                    vida[0][iaEnemigo] -= dano;
                    energia[1][iaHeroe] -= 10;
                    System.out.println(nombres[1][iaHeroe] + " magia " + dano);
                    
                } else if(accionIA == 3 && curaciones[1][iaHeroe] < 2) {
                    // Curar
                    vida[1][iaHeroe] += 20;
                    curaciones[1][iaHeroe]++;
                    System.out.println(nombres[1][iaHeroe] + " se cura");
                }
            }
            
            // REVISAR MUERTES
            revisarMuertes(0, nombres, vida, vivo);
            revisarMuertes(1, nombres, vida, vivo);
            
            // Mostrar vidas
            System.out.println("\nVIDAS:");
            System.out.println("P1: " + vida[0][0] + "," + vida[0][1] + "," + vida[0][2]);
            System.out.println("P2: " + vida[1][0] + "," + vida[1][1] + "," + vida[1][2]);
            System.out.println();
            
            turnoJugador = 1 - turnoJugador; // Cambiar turno
        }
        
        entrada.close();
    }
    
    // Función para mostrar mis héroes
    public static void mostrarMisHeroes(int jugador, String nombres[][], int vida[][], int energia[][], boolean vivo[][], int curaciones[][]) {
        System.out.println("TUS HÉROES:");
        for(int i=0; i<3; i++) {
            if(vivo[jugador][i]) {
                System.out.println((i+1) + ". " + nombres[jugador][i] + " V:" + vida[jugador][i] + " E:" + energia[jugador][i] + " C:" + curaciones[jugador][i]);
            } else {
                System.out.println((i+1) + ". " + nombres[jugador][i] + " MUERTO");
            }
        }
    }
    
    // Revisar si héroe murió
    public static void revisarMuertes(int jugador, String nombres[][], int vida[][], boolean vivo[][]) {
        for(int i=0; i<3; i++) {
            if(vida[jugador][i] <= 0 && vivo[jugador][i]) {
                vida[jugador][i] = 0;
                vivo[jugador][i] = false;
                System.out.println("¡" + nombres[jugador][i] + " MURIÓ!");
            }
        }
    }
}
        
        
        
        
 
