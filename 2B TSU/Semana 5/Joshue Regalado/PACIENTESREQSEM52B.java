/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pacientes.req.sem5.pkg2b;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class PACIENTESREQSEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numpa;
        
        //Capturacion de datos
        System.out.println("Cuantos pacientes de registraran?");
        numpa=sc.nextInt();
        
        
        String [] nombres = new String [numpa];
        int [] edades = new int [numpa];
                
        for(int i = 0; i < nombres.length; i++) {
            System.out.println("Ingres el nombre del paciente "+(i+1));
            nombres[i]=sc.next();
            
            System.out.println("Ingrese la edad de "+nombres[i]);
            edades[i]=sc.nextInt();
            
            while (edades[i]<0 || edades[i]>120) {
                System.out.println("Edad invalidad");
                
                if (edades[i]<0 || edades[i]>120) {
                System.out.println("Ingresela nuevamente:");
                edades[i]=sc.nextInt();
                }   
            }
        }
        //Analisis de sistema
        System.out.println("Pacientes registrados:");
        int i=0;
        for (String nombre : nombres) {
            System.out.println("Paciente: "+nombre+"// Edad: "+edades[i]);
            i++;
        }
        //Contar
        int menores, adultos, mayores;
        int j;
        menores=0;
        adultos=0;
        mayores=0;
        j=0;
        while (j<edades.length) {
            if (edades[j]<18) {
                menores++;
            } 
            else if (edades[j]>=18 && edades[j]<60) {
                adultos++;
            }
            else {
                System.out.println("\nPaciente prioritario: "+(nombres[j]));
                mayores++;
            }
            j++;
            
        }
        System.out.println("\nCONTEO DE TIPO DE PACIENTES");
        System.out.println("Pacientes menores: "+(menores));
        System.out.println("Pacientes adultos: "+(adultos));
        System.out.println("Pacientes mayores: "+(mayores));
        
        System.out.println("\nTotal de pacientes prioritaorios: "+(mayores));
   }
    
}
