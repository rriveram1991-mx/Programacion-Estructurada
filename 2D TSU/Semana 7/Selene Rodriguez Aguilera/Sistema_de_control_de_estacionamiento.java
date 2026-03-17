/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema_de_control_de_estacionamiento;



/**
 *
 * @author crist
 */
import java.util.Scanner;
import java.io.FileWriter;    
import java.io.IOException;   //Esto me ayuda a craer y escribir en el archivo de texto que es txt.
public class Sistema_de_control_de_estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String [] estacionamiento = new String [10];  //Aqui empiezan los arrays que es de los espacios del estacionamiento
        for (int i =0; i <estacionamiento.length; i ++){ //Inicializa todos los espacios como libre al iniciar el programa.
            estacionamiento [i] = "LIBRE";
            
        }
        
        int contadorOcupados = 0;
 Scanner leer = new Scanner (System.in);
 boolean continuar = true; // variable que controla el ciclo del menu y para salir se vuelve falso.
 while (continuar) {
 System.out.println("Selecciona una opcion del 1 al 5");
 System.out.println("1.Ver estacionamiento.");
 System.out.println("2.Estacionar auto.");
 System.out.println("3.Retirar auto.");                        
 System.out.println("4.Contar espacios ocupados.");                  
 System.out.println("5.Salir."); //Este es el menu.
 int opcion = leer.nextInt();
 switch (opcion) {
     case 1:
         System.out.println("Estado del estacionameinto");
         for (int i = 0; i < estacionamiento.length; i++){ // Recorre cada posicion del array de 0 al 9.
             System.out.println("Espacio" + (i+1)+ estacionamiento [i]);
             
         }
         break;
     case 2:
                     //  Estacionar auto con validación if
                     System.out.print("\nIngresa el número de espacio (1-10): ");
                     int espacioEstacionar = leer.nextInt() - 1; // Ajustar a índice
                     if (espacioEstacionar >= 0 && espacioEstacionar < 10) { // convierte el numero de espacio de 1-10
                         if (estacionamiento[espacioEstacionar].equals("LIBRE")) {
                             estacionamiento[espacioEstacionar] = "OCUPADO";
                             System.out.println("Auto estacionado exitosamente.");
                         } else {
                             System.out.println("Error: El espacio ya está ocupado.");
                         }
                     } else {
                         System.out.println("Error: Número de espacio inválido.");
                     }
                     break;
                 case 3:
                     //  Retirar auto con validación if
                     System.out.print("Ingresa el número de espacio (1-10): ");
                     int espacioRetirar = leer.nextInt() - 1; // Ajustar a índice
                     if (espacioRetirar >= 0 && espacioRetirar < 10) {
                         if (estacionamiento[espacioRetirar].equals("OCUPADO")) {
                             estacionamiento[espacioRetirar] = "LIBRE";
                             System.out.println("Auto retirado exitosamente.");
                         } else {
                             System.out.println("Error: El espacio ya está libre.");
                         }
                     } else {
                         System.out.println("Error: Número de espacio inválido.");
                     }
                     break;
                 case 4:
                     //  Contar espacios ocupados con for-each
                     contadorOcupados = 0; //Inicializa un contador de 0
                     for (String espacio : estacionamiento) {
                         if (espacio.equals("OCUPADO")) {
                             contadorOcupados++;
                         }
                     }
                     System.out.println("Total de espacios ocupados: " + contadorOcupados);
                     break;
                 case 5:
                     //  Salir del programa
                     continuar = false;
                     // A qui se  crear el archivo TXT con estado final
                     try (FileWriter estac = new FileWriter("estado_estacionamiento.txt")) {
                         estac.write(" ESTADO FINAL DEL ESTACIONAMIENTO \n");
                         for (int i = 0; i < estacionamiento.length; i++) {
                             estac.write("Espacio " + (i + 1) + ": " + estacionamiento[i] + "\n");
                         }
                         estac.write("Total de autos estacionados: " + contadorOcupados);
                         System.out.println("Archivo 'estado_estacionamiento.txt' creado exitosamente.");
                     } catch (IOException e) {
                         System.out.println("Error al crear el archivo TXT.");
                     }
                     System.out.println("Saliendo del sistema...");
                     break;
                 default:
                     System.out.println("Opción inválida. Intenta nuevamente.");
                     break;
                     
             }
         }
       
     }
 }
 


 

 



    
    

