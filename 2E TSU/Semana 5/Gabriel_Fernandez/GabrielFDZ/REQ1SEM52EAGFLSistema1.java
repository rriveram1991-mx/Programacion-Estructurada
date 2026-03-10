/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2e.agfl.sistema1;

import java.util.Scanner;
/**
 *
 * @author gl873
 */
public class REQ1SEM52EAGFLSistema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner leer = new Scanner(System.in);

        System.out.print("Cuantos pacientes se registraran: ");
        int num = leer.nextInt();
        leer.nextLine();

        String[] nom = new String[num];
        int[] edad = new int[num];

        for (int i = 0; i < num; i++) {

            System.out.print("Nombre: ");
            nom[i] = leer.nextLine();

            System.out.print("Edad: ");
            edad[i] = leer.nextInt();

            while (edad[i] < 0 || edad[i] > 120) {
                if (edad[i] < 0 || edad[i] > 120) {
                    System.out.print("Edad incorrecta, ingrese otra: ");
                    edad[i] = leer.nextInt();
                }
            }

            leer.nextLine();
        }

        int menores = 0;
        int adultos = 0;
        int mayores = 0;
        int prioritarios = 0;

        System.out.println("\nPacientes registrados:");

        for (String n : nom) {
            System.out.println(n);
        }

        for (int e : edad) {

            if (e < 18) {
                menores++;
            }

            if (e >= 18 && e <= 59) {
                adultos++;
            }

            if (e >= 60) {
                mayores++;
                prioritarios++;
                System.out.println("Paciente prioritario");
            }
        }

        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + mayores);
        System.out.println("Total pacientes prioritarios: " + prioritarios);
    }
}
    
    

