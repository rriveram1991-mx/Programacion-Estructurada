/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosingricardo46;

import java.util.Scanner;

/**
 *
 * @author yahir
 */
public class EjerciciosIngRicardo46 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int paciente;
        int ct1=0;
                int ct2=0;
                int ct3=0;
        System.out.println("¿Cuántos pacientes se registrarán?");
        paciente=leer.nextInt();
        String[] nombres = new String[paciente];
        int[] edad = new int[paciente];
        
        for (int i= 0; i < nombres.length; i++) {
            System.out.println("Ingresa el nombre del paciente #" + (i+1) +":");
            nombres[i]=leer.next();
    }
        for (int j=0; j < edad.length; j++) {
            System.out.println("Ingresa la edad del paciente #" + (j+1) + ":"); 
            edad[j]=leer.nextInt();
            while (edad[j] >= 121 || edad[j] <=0) {
                System.out.println("Edad invalida");
                System.out.println("Ingrese nuevamente su edad");
                edad[j]=leer.nextInt();
                }
                
                if (edad[j] < 18) {
                    ct1++;
                }
                if (edad[j]<=59 && edad[j]>=18) {
                    ct2++;
                }
                if (edad[j] > 59) {
                    System.out.println("Paciente prioritario");
                    ct3++;
                }
            }
            System.out.println("Lista de pacientes:");
            for (String n : nombres) {
                System.out.println("Nombre: "+n);
                }
                
                 System.out.println("Total de pacientes prioritarios: "+ct3 );   
                }
                
            }
    

