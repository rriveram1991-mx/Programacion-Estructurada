/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaestacionamiento;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author miguelgu
 */
public class SistemaEstacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=====SISTEMA DE ESTACIONAMIENTO=====");
        
        boolean salir = false;
        String espacio[] = new String [10];
        
        for (int i = 0; i<espacio.length; i++){
            espacio[i] = "LIBRE";
        }
        while (!salir){
        System.out.println("Seleccione opcion: ");
        System.out.println("1. Ver estacionamiento.");
        System.out.println("2. Estacionar auto.");
        System.out.println("3. Retirar auto.");
        System.out.println("4. Contar espacios ocupados.");
        System.out.println("5. Salir.");
        
        int opc = input.nextInt();
        
        switch (opc){
            case 1:
                for (int i = 0; i< espacio.length; i++){
                    System.out.println("Espacio "+(i+1)+":"+espacio[i]);
                }
                break;
            case 2:   
                System.out.println("Ingrese espacio donde desea estacionar: ");
                int lugar = input.nextInt();
                
                if (lugar >= 1 && lugar <=10){
                    if (espacio[lugar - 1].equals("LIBRE")){
                        espacio[lugar - 1] = "OCUPADO";
                        System.out.println("AUTO ESTACIONADO CORRECTAMENTE");
                    }
                    else {
                        System.out.println("El espacio esta ocupado");
                    }
                }
                else {
                    System.out.println("ERROR. Numero invalido..");
                }
                break;
            case 3:
                System.out.println("Ingrese el espacio del auto que desea retirar: ");
                int retiro = input.nextInt();
                if (retiro >= 1 && retiro <=10){
                    if (espacio[retiro - 1].equals("OCUPADO")){
                        espacio[retiro - 1] = "LIBRE";
                        System.out.println("AUTO RETIRADO CORRECTAMENTE");
                    }
                    else {
                        System.out.println("El espacio esta libre");
                    }
                     }
                else {
                    System.out.println("ERROR. Numero invalido.");
                }
                break;
                
            case 4:
                int contador = 0;
                
                for (String place : espacio){
                    if (place.equals("OCUPADO")){
                        contador++;
                    }
                }
                System.out.println("Espacios ocupados: "+contador);
                break;
            case 5:
                salir = true;
                System.out.println("Saliendo del sistema...");
                
               try {
                   FileWriter archivo = new FileWriter("reporte_estacionamiento.txt");
               }
               
                break;
                
            default:
                System.out.println("Ingrese opcion valida");
        }
    }   
    
}
}
