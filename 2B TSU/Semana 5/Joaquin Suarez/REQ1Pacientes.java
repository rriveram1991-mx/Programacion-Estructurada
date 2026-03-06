/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.pacientes;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class REQ1Pacientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
     Scanner leer = new Scanner(System.in);
     String[] nombres = new String[5];/*limites de datos para el arreglo*/
     double [] edades = new double[5];
     int pacientes = 0;
     int menor = 0;
     int medio= 0;
     int mayor = 0;/*contadores*/
     for(int n = 0; n < edades.length; n++)
     {
         System.out.println("Ingrese el nombre del paciente"+ (n+1));
         nombres[n] = leer.nextLine();
         
         System.out.println("Ingrese la edad del paciente");
         edades[n] = leer.nextDouble();
         
         while(edades[n] <0 || edades[n] > 120)/*condicion para los limites de edad del paciente*/
         {
         System.out.println("Edad fuera del rango");
         leer.nextLine();
         if(edades[n] < 0 || edades[n] >120 )/*accion a tomar en caso de superar el limite*/
         {
             System.out.println("Ingrese de nuevo la edad ");
             edades[n] = leer.nextDouble();
         }
         }
         leer.nextLine();

         if (edades[n]<18)/*arreglo para ejemplificar los contadores y clasificacion de edad*/
         {
             menor++;        
         }else if (edades[n] <59 && edades[n] >18)
         {
             medio++;
         }else if(edades[n] > 60)
         {
             System.out.println("Paciente priotiratrio");/*condicion especial para demotrar que la atenciones a mayores sera prioritaria*/
             mayor++;
         }
         pacientes++;
     }
     
     for(int n = 0; n < edades.length; n++)/*ciclo para presentar datos finales*/
     {
        System.out.println("Paciente: " + nombres[n] + " edad: "+ edades[n]);
     }
        System.out.println("total de pacientes: "+pacientes);
        System.out.println("Total de pacientes prioritarios: "+mayor);
        System.out.println("Total de pacientes entre 18 y 59: "+medio);
        System.out.println("Total de pacientes menores de 18: "+menor);
     
     
        
        
        
        
        
        
        
        
    }
    
}
