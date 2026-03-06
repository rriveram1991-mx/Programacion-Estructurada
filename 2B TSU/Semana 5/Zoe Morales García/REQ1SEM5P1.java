/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.req1sem5p1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class REQ1SEM5P1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos pacientes desea registrar");
        int pacientes=sc.nextInt();
        String[] nombre=new String [pacientes];
        int[]edades=new int[pacientes];

        for (int i = 0; i < edades.length; i++) {
            System.out.println("Ingrese nombre del paciente"+(i+1));
            nombre[i] = sc.nextLine();
            System.out.println("Ingrese la edad del paciente ");
            edades[i] = sc.nextInt();

            while (edades[i] < 0 || edades[i] > 120) {
                if(edades[i] < 0 || edades[i] > 120){
                System.out.println("Edad inválida. Intente nuevamente:");
                edades[i] = sc.nextInt();}
            }
            sc.nextLine();
        }
        int menores=0;
        int adultos=0;
        int adultos_m=0;
        int prioridad = 0;
        int i=0;
        for(String nom:nombre){
            int edad=edades[i];
            if(edad<18){
                menores++;
            }else if (edad>=59){
               adultos++;
            }else{
                adultos_m++;
                System.out.println("Pacientes prioritarios:");
                prioridad++;
            }
            i++;
        }
        System.out.println("Pacientes menores de edad: " + menores);
        System.out.println("Pacientes adultos: " + adultos);
        System.out.println("Pacientes adultos mayores: " + adultos_m);
        System.out.println("Pacientes qque son prioridad: " + prioridad);   

        

    }
}
