/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg1.sem7.pkg2e.agfl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author gl873
 */
public class RTO1SEM72EAGFL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean[] espacio= new boolean[10];
        Scanner leer = new Scanner(System.in);
        int opcion;
       
        do{
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opción:");
            opcion = leer.nextInt();
            
            switch (opcion){
                case 1:
                    System.out.println("Ver estacionamiento:");
                    for (int i = 0; i < espacio.length; i++) {
                        if (espacio[i]) {
                            System.out.println("Lugar " + (i + 1) + ": Ocupado");
                        } else {
                            System.out.println("Lugar " + (i + 1) + ": Libre");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el lugar: ");
                    int lugar = leer.nextInt()-1;

                    if (lugar >= 0 && lugar < espacio.length) {
                        if (espacio[lugar]) {
                            System.out.println("Ese lugar ya está ocupado.");
                        } else {
                            espacio[lugar] = true;
                            System.out.println("Auto estacionado.");
                        }
                    } else {
                        System.out.println("Lugar inválido.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el lugar a retirar: ");
                    int retirar = leer.nextInt() -1 ;

                    if (retirar >= 0 && retirar < espacio.length) {
                        if (!espacio[retirar]) {
                            System.out.println("Ese lugar ya está libre.");
                        } else {
                            espacio[retirar] = false;
                            System.out.println("Auto retirado.");
                        }
                    } else {
                        System.out.println("Lugar inválido.");
                    }
                    break;

                case 4:
                    int ocupados = 0;

                     for (boolean e : espacio) {
                      if (e) {
                      ocupados++;
                    }
                }

                System.out.println("Espacios ocupados: " + ocupados);
                break;

                case 5:
                    System.out.println("Salir");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }while(opcion !=5);
        
        try {

            File est = new File("estacionamiento.txt");

            if (est.createNewFile()) {
                System.out.println("Archivo creado: " + est.getName());
            } else {
                System.out.println("El archivo ya esta en existencia.");
            }

            FileWriter escribir = new FileWriter("estacionamiento.txt");
            
            escribir.write("Espacios del Estacionamiento: \n\n");


           for(int i = 0; i < espacio.length; i++) {
               
                if (espacio[i]) {
                            escribir.write("Lugar " + (i + 1) + ": Ocupado \n");
                        } else {
                            escribir.write("Lugar " + (i + 1) + ": Libre \n");
                        }
                    }
           
           int ocupados = 0;
           for (boolean e : espacio) {
                      if (e) {
                      ocupados++;
                    }
                }

                escribir.write("\nEspacios ocupados: " + ocupados);

            escribir.close();
            leer.close();
            System.out.println("Se completo escribir correctamente en el archivo");

        } catch (IOException e) {

            System.out.println("Ocurrio un error.");
            e.printStackTrace();

        }
    }
    
}
