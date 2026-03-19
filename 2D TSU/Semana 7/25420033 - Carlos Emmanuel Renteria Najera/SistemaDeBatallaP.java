/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadebatallap;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class SistemaDeBatallaP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lr = new Scanner(System.in);
        
        String[][] J1 = new String [3][3];
        String[][] J2 = new String [3][3];
        int opc = 0;
 
        while(opc != 4){
        
            menuinicio();
            opc = lr.nextInt();
            lr.nextLine();
            
            switch(opc){
                case 1:
                    Asignarpokemon(J1, lr);
                    break;
                case 2:
                    Asignarpokemon(J2, lr);  
                    break;
                case 3:
                    MostrarEquipos(J1);
                    System.out.println();                    
                    MostrarEquipos(J2);
                    break;
                case 4:  
                    System.out.println("\n===== empieza la batalla =====");
                        BatallaActiva(J1, J2, lr);
                    break;
                default:
                    break;
            
            
            }
            
            
        
        }
        
        
    }
    
    public static void menuinicio(){
        System.out.println("\n===========================");
        System.out.println("      MENÚ      ");
        System.out.println("===========================");
        System.out.println("1) Agine equipos al primer jugador");
        System.out.println("2) Asigne equipos al segundo jugador");
        System.out.println("3) Mostrar Equipos");
        System.out.println("4) Empezar batalla");
        System.out.print("Seleccione: ");
    }
    
    //public static 
   
    public static void Asignarpokemon(String[][] equipo, Scanner lr){
            int fila = -1;
                    for (int i = 0; i < equipo.length; i++) {
                        if (equipo[i][0] == null) {
                            fila = i;
                            break;   
                        }
                    }
                        if (fila != -1) {
                            System.out.println("Nombre del pokemon: ");
                            equipo[fila][0] = lr.nextLine();
                            System.out.println("Vida del pokemon: ");
                            equipo[fila][1] = lr.nextLine();
                            System.out.println("Ataque del pokemon: ");
                            equipo[fila][2] = lr.nextLine();
                            
                            System.out.println("Pokemon registrado!");
                        }
                        else{
                            System.out.println("Equipo completo!");
                        }
    }
    
    public static void MostrarEquipos(String[][] equipo){
            for (int i = 0; i < equipo.length; i++) {
                        System.out.println(equipo[i][0] + " - " + equipo[i][1] + " - " + equipo[i][2]);
                    }
    
    }
    
    public static boolean elegirPokemon(String[][] equipo1, String[][] equipo2, String buscar){

            for (int i = 0; i < equipo1.length; i++) {
                
                if (equipo1[i][0] != null && equipo1[i][0].equalsIgnoreCase(buscar)) {
                    if (!equipo1[i][1].equals("0")) {
                        
                    
                    System.out.println("Adelante " + equipo1[i][0]);
                    int daño = Integer.parseInt(equipo1[i][2]);
                    int vidaE = Integer.parseInt(equipo2[i][1]);
                    
                    int nuevaV = Math.max(0, vidaE - daño);
                    equipo2[i][1] = Integer.toString(nuevaV);
                    
                        System.out.println("El pokemon:" + equipo2[i][0] + "ha sufrido un ataque");
                        System.out.println("vida restante:" + nuevaV);
                        return true;
                    }
                    else{
                        System.out.println("ese pokemon esta derrotado, por imbecil, se te salta el turno");
                        return false;
                    }             
                }   
            }
            System.out.println("no tienes un pokemon con ese nombre, elige otro!");
            return false;
    }
    
    public static boolean equipoDerrotado(String[][] equipo) {
    for (int i = 0; i < equipo.length; i++) {
        if (equipo[i][0] != null) { 
            int vida = Integer.parseInt(equipo[i][1]);
            if (vida > 0) {
                return false; 
            }
        }
    }
    return true;
}
    
    
    public static void BatallaActiva(String[][] equipo1, String[][] equipo2 , Scanner lr){
        boolean BA = true;
        int turno = 1;
        
        while(BA){
            System.out.println("\n----------------------------");
            System.out.println("TURNO DEL JUGADOR " + turno);
            System.out.println("----------------------------");
            System.out.println("1) Atacar");
            System.out.println("2) Ver estado de los Pokemon");
            System.out.println("3) Intentar Huir (Rendirse)");
            System.out.print("Seleccione acción: ");
            
            int accion = Integer.parseInt(lr.nextLine());
            
            switch(accion){
                case 1: 
                    boolean turnoC = false;     
                    while (!turnoC){
                        System.out.print("Elije a tu pokemon: ");
                        String buscar = lr.nextLine();
                        if (turno == 1) {
                        turnoC = elegirPokemon(equipo1, equipo2, buscar);
                        turno = 2;
                        }
                        else{
                        turnoC = elegirPokemon(equipo2, equipo1, buscar);
                        turno = 1;
                        }
                    }
                    
                        break;
                case 2:
                    MostrarEquipos(equipo1);
                    System.out.println();                    
                    MostrarEquipos(equipo2);
                        break;
                case 3:
                    System.out.println("el jugador"+ turno +"se a retirado...");
                    BA = false;
                        break;
                default:
                    System.out.println("solo hay 3 opciones maldito...");
                    break;
            }

   
            if (equipoDerrotado(equipo2)) {
                System.out.println("el jugador 1 ha GANADO");
                BA = false;
            }
            else if (equipoDerrotado(equipo1)){
                System.out.println("el jugador 2 ha GANADO");
                BA = false;
            }
            
        }
    }
    
    
}
