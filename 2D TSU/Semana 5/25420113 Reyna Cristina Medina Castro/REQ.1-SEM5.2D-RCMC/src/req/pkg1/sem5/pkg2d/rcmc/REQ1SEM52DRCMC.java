/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2d.rcmc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class REQ1SEM52DRCMC {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        //reyna cristina medina castro
       Scanner leer=new Scanner(System.in);
      
              //pedir los pacienyes
        System.out.print("¿Cuantos pacientes de registrara");
        int cantidad = leer.nextInt();
        leer.nextLine(); 

        //crear los arrays de nombres y de edades
        String[] nombres = new String[cantidad];
        int[] edades = new int[cantidad];

        //gyuardar las edades
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nPaciente " + (i + 1));
            System.out.print("Nombre: ");
            nombres[i] =leer.nextLine();
            

            int edad;
            while (true) {
                System.out.print("Edad: ");
                edad = leer.nextInt();
                leer.nextLine();

                if (edad >= 0 && edad <= 120) {
                    break; //cerrar if
                } else {
                    System.out.println("Edad invalida.Debe estar entre 0 y 120.");
                }
            }
            edades[i] = edad;
        }

        // Empezando por cero
        int menores = 0, adultos = 0, mayores = 0, prioritarios = 0;
        //verificar en que rango de las edades entra

        System.out.println("\n--- Pacientes registrados ---");
        for (int edad : edades) {
            //si son >18 entonces son menores
            if (edad < 18) {
               
                menores++;
            } else if (edad < 60) {
                //si son engre 18 y menores a 60 entonces entra en adultos
                adultos++;
            } else {
                //si sonn mayores de 60 son prioritarios y mayores o sea viejitos
                mayores++;
                prioritarios++;
            }
        }

        // Los pacientes de mas de 60 son pacientes prioritarios
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre: " + nombres[i] + ", Edad: " + edades[i]);
            if (edades[i] >= 60) {
                System.out.println(" → Paciente prioritario");
            } else {
                System.out.println();
            }
        }

        // Resultados ya para mostrar
        System.out.println("\n==========RESULTADOS==========");
        System.out.println("Menores de edad (<18): " + menores);
        System.out.println("Adultos (18-59) " + adultos);
        System.out.println("Adultos mayores (60+): " + mayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

        leer.close();
    }
}

 
