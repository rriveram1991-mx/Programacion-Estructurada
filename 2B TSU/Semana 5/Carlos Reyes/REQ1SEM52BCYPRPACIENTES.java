/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2bcypr.pacientes;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class REQ1SEM52BCYPRPACIENTES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("¿Cuantos pacientes desea registrar?");
        int cantidad = sc.nextInt();
        sc.nextLine();
        
        String[] nombres = new String[cantidad];
        int[] edades = new int[cantidad];
        
        int menores=0;
        int adultos=0;
        int adultosmayores=0;
        int prioritarios=0;
        
        for (int i=0; i < cantidad; i++) {
            
            System.out.println("\nPaciente"+ (i+1));
            
            System.out.println("Nombre:");
            nombres[i]=sc.nextLine();
            
            System.out.println("Edad:");
            edades[i]=sc.nextInt();
            
            while (edades[i] < 0 || edades[i] > 120) {
                
                if (edades[i]<0 || edades [i] > 120){
                    System.out.println("Edad invalida, ingrese nuevamente:");
                }
            }
            sc.nextLine();
            
            if (edades[i] < 18) {
                menores++; 
            } 
            else if (edades [i] <=59) {
                adultos++;
            }
            else {
                adultosmayores++;
            }
            if (edades[i] >= 60){
                System.out.println("Paciente prioritario");
                prioritarios++;
            }
        }
        System.out.println("\nPacientes registrados:");
        
        for (String nombre:nombres){
            System.out.println("Paciente:"+ nombre);
        }
        System.out.println("\nEstadísticas del sistema:");
        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + adultosmayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

        sc.close();

        
    }
    
}
