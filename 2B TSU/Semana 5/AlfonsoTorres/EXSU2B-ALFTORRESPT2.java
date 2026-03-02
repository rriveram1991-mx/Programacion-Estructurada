/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exs.u2.alftorres.pt2;

import java.util.Scanner;

/**
 *
 * @author fonso
 */
public class EXSU2ALFTORRESPT2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double ttl =0;
        int opcion =0; 
        int Ncalis =0;
        System.out.println("PonchScann... ");
        System.out.println("Iniciando programa...");
        System.out.println("PROGRAMA DE CALCULO DE CALIFICACIONES.");
        Scanner Leer = new Scanner(System.in);
        System.out.println("Elija qué desea hacer...");
        System.out.println("1. Ingresar calificiones");
        System.out.println("2. Calcular promedip.");
        System.out.println("3. Salir.");
        opcion = Leer.nextInt();
        switch (opcion){
            case 1 : 
                System.out.println("Ingrese la cantidad de calificaciones a ingresar:");
                Ncalis = Leer.nextInt();
               
                for (int i = 1; i <= Ncalis; i++) {
                    System.out.println("Ingrese la calificacion #"+ i + ":");
                    double calis = Leer.nextDouble();
                    
                    if (calis >=0 && calis <=100) {
                        ttl += calis;
                }
                else {
                    System.out.println("Invalido.");
                        } 
        }
                
            case 2: 
                    System.out.println("Calculando Promedio...");
                    double prom = ttl/Ncalis;
                    System.out.println("Promedio=" + prom);
                    break;
            case 3: 
                System.out.println("Saliendo del sistema");
                break;
            default: 
                System.out.println("Opcion Invalida.");
                    
                    

        }
    }
}
                    
                
                
                  

    
    

