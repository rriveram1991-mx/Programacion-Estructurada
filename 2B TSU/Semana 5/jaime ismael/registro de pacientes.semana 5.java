/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication65;
//
//Requerimientos del Sistema 1

import java.util.Scanner;

//El sistema debe solicitar:
//Cuántos pacientes se registrarán.
//Crear dos arrays:
//String[] nombres
//int[] edades
//Captura de datos:
//Usar un for para capturar nombre y edad.
//Validar con while que la edad no sea negativa ni mayor a 120.
//Si la edad es inválida, pedirla nuevamente usando if.
//Análisis del sistema:
//Usar for-each para mostrar todos los pacientes registrados.
//Contar:
//Cuántos son menores de edad (<18)
//Cuántos son adultos (18–59)
//Cuántos son adultos mayores (60 o más)
//Condiciones:
//Si un paciente es mayor o igual a 60 → mostrar "Paciente prioritario".
//Al final mostrar:
//Total de pacientes prioritarios.


public class JavaApplication65 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("cuantos pacientes se registraran");
         int cant = leer.nextInt();
         
         
        String[] nombres = new String[cant];
        int[] edades = new int[cant];
        int menores = 0;
        int adultos = 0;
        int priority = 0;
        
        //solicitud de nombre y edad en base a la cantidad de pacientes
        for (int x = 0 ; x < nombres.length; x++ ){
            
            System.out.println("ingrese nombre de paciente " + (x+1) + ": " );
            nombres[x] = leer.next();
            
            System.out.println("ingrese edad del paciente " + (x+1) + ": ");
            edades[x] = leer.nextInt();
            // validar edad con un bucle infinito que solo se rompe cuando se ingresa la edad 
            // esperada dentro de el rango aceptable 
            while (true) {

        if (edades[x] >= 0 && edades[x] <= 120) {
            break; 
        }
        System.out.println("Edad invalida, vuelva a intentar: ");
        edades[x] = leer.nextInt();
    }
            //contadores 
            if (edades[x] < 18){
             menores++;   
            }else if (edades[x] >= 18 && edades[x] < 60){
             adultos++;   
            }else if (edades[x] >= 60){
                priority++; 
                System.out.println("paciente priority detectado");
            }
            
        }//for each que recorre la lista e imprime los nombre 
        System.out.println("lista de pacientes: ");
        for (String nombre : nombres){
            System.out.println(nombre);
            
        }
        
        System.out.println("datos: ");
        System.out.println("pacientes menores de edad: " + menores);
        System.out.println("pacientes adultos: " + adultos);
        System.out.println("pacientes mayores de edad: " + priority);
        
        System.out.println("cantidad de pacientes con prioridad: " + priority);
        
    }
    
}
