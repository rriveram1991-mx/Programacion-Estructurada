/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act3sem5;
import java.util.Scanner;
/**
 *
 * @author miguelgu
 */
public class Act3Sem5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Cuantos pacientes se van a registrar?");
        int regis = input.nextInt();
        input.nextLine();
        String[] nombres = new String[regis];
        int[] edades = new int[regis];
        int prio = 0;
 
        for (int i = 0; i < regis; i++){
            System.out.println("Ingrese nombre del paciente #" + (i + 1) +" :");
             nombres[i] = input.nextLine();
             
             System.out.println("Ingrese edad del paciente #" + (i + 1) +" :");
                 edades [i] = input.nextInt();
                 input.nextLine();
                 
                 if (edades [i] > 60){
                     System.out.println("Paciente prioritario!!");
                     prio++;
                 }

            while (edades[i] < 0 ||  edades[i] > 120){
                System.out.println("Ingrese una edad valida...");
                edades[i] = input.nextInt();
        }
        }
            System.out.println("Pacientes registrados: ");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Paciente #"+(i+1)+" :" +nombres[i]+ " Edad: "+edades[i]);
        }
        
        int j = 0;
        int menor = 0;
        while (j < regis)
        { if (edades[j] < 18) {
          menor++; }
          j++;
        }
        
        int k = 0;
        int adulto = 0;
        while (k < regis)
        { if (edades[k] > 18 && edades[k] < 60) {
          adulto++; }
          k++;
        }
        
        int l = 0;
        int mayor = 0;
        while (l < regis)
        { if (edades[l] > 60) {
          mayor++; }
          l++;
        }
        
        System.out.println("Total de pacientes prioritarios: "+prio);
        
            
        
    }
    }
    

