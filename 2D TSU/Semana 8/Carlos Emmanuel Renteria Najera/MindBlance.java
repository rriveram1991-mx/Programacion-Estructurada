/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mindblance;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class MindBlance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lr = new Scanner(System.in);
        int[] estadoA = new int [7];
        String[][] Actividades = new String [7][2];
        int op=0, cc=0, ccn=0;
        int prom = 0;
        
        while(op != 5){
            menu();
            op = lr.nextInt();
            lr.nextLine();
            
            switch(op){
                case 1:
                    cc = registrarEmocion(estadoA, lr, cc);
                    /*for (int i : estadoA) {
                        System.out.println(i);
                    }*/
                    break;
                case 2:
                    ccn = ingresarAct(Actividades, ccn, lr);
                    break;
                case 3:
                    System.out.println("Resumen semanal: ");
                    prom = verResumen(Actividades, estadoA, prom);
                    break;
                case 4:
                    if(prom == 0){
                        System.out.println("ingresa datos para calcular el promedio como minimo");
                    }else{
                    if (prom >= 4) {
                    System.out.println("felicitar al usuario");
                    }
                    else if(prom >= 3 && prom < 4){
                    System.out.println("recomendar ejercicio");
                    }
                    else if(prom >= 1 && prom < 3){
                    System.out.println("recomendar descanso y meditación");
                    }else{
                        System.out.println("ingresa datos primero!!!!");
                    }
                    }
                    break;
                case 5:
                    
                    break;
                default:
                    break;
            }    
            
            
            
        }
        
    }
    
    
    static void menu(){
        
        System.out.println("\n==================================");
        System.out.println("    Menu inicial   ");
        System.out.println("==================================");
        System.out.println("1.) registrar estado de animo");
        System.out.println("2.) registrar actividades");
        System.out.println("3.) ver resumen");
        System.out.println("4.) ver recomendaciones");
        System.out.println("5.) registrar estado de animo");
    }   
    static int registrarEmocion(int[] e, Scanner lr, int cc){
        if (cc < e.length) {
            System.out.println("Elige tu emocion del 1-5 siendo que 1: Muy mal, 3:Neutral, 5: Exelente");
            
            while(!lr.hasNextInt()){
                System.out.println("INgrese un numero entero!!");
                lr.next();
            }   
            int em = lr.nextInt();
            
            if (em >= 1 && em <=5) {
                e[cc] = em;
                System.out.println("Registrado!!");
                cc++;
            }else{
                System.out.println("Ingrese un numero en el rango especificado");
            }
             
        }else{
            System.out.println("Error: ya ocupaste todos los espacios");
        }
        
        
        return cc;
        
    }
    
    static int ingresarAct(String[][] d, int cc, Scanner lr){
        if(cc < d.length){
            System.out.println("ingrese los datos que hizo el dia : " );
            d[cc][1] = lr.nextLine();
            d[cc][0] = String.valueOf(cc+1);
            cc++;
        }else{
            System.out.println("Error: ya ocupaste todos los espacios");
        }
        return cc;
    }
    
    static int verResumen(String[][] d, int[] e, int prom){
        
        int suma=0;
        System.out.print("Promedio de tu estado de animo: ");
        for (int i = 0; i < e.length; i++) {
            suma += e[i];
        }
        prom = suma/e.length;
        System.out.print(prom);
        
        System.out.println();
        
        System.out.println("Registro de actividades saludables");
        
        for (String[] i : d) {
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        
        if (prom >= 4 && prom <= 5) {
            System.out.println("NIVEL alto de animo");
        }
        else if(prom >= 3 && prom < 4){
            System.out.println("NIVEL medio de animo");
        }
        else if(prom >= 1 && prom < 2){
            System.out.println("NIVEL bajo de animo");
        }
        
        
        
        return prom;
    }
}
