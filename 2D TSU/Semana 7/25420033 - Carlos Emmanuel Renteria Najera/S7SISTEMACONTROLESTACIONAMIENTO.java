/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s.pkg7.sistemacontrolestacionamiento;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Memer
 */
public class S7SISTEMACONTROLESTACIONAMIENTO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creo mis variables
        Scanner lr = new Scanner (System.in);
        File myObj = new File("Estacionamiento.txt");
        
        int [][] estacionamiento = new int [5][2];
        
        int op, f, c;
        
        do {
            //creo mi menu
            System.out.println("1. Ver estacinamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacio ocupados");
            System.out.println("5. salir");
            op = lr.nextInt();
            
            //Switch para las opciones
            switch (op) {
                case 1:
                    //hago un for each, para recorrer los espacios en el array
                    for (int[] i : estacionamiento) {
                        for (int j : i) {
                            //con el if, hago que se le agine ocupado o libre dependiendo de si tiene un 1
                            if (j == 1) {
                            System.out.print(" Ocupado " );    
                            }
                            else{
                            System.out.print(" Libre ");
                            }
                        }
                        
                        System.out.println();
                    }
                    
                    break;
                case 2:
                    //le pregundo al usuario
                    System.out.println("en que columna quiere estacionar su auto?");
                    c = lr.nextInt() - 1;
                    System.out.println("en que fila?");
                    f = lr.nextInt() - 1;
                    
                    //y con los datos que le pido al usuario, le agino 1, en caso de que este ocupado, no hace nada y le pide que le ingrese
                    if (estacionamiento[f][c] == 1) {
                        System.out.println("ese espacio esta ocupado, ingrese bien los datos");
                    }
                    else{
                        
                        //en caso contrario, se le agina un 1, que seria el ocupado
                        estacionamiento[f][c] = 1;
                        System.out.println("Usted ocupo ese espacio");
                    }
                    
                    break;
                case 3:
                    //le pido datos al usuario
                    System.out.println("de que columna quiere retirar su auto?");
                    c = lr.nextInt() - 1;
                    System.out.println("de que fila?");
                    f = lr.nextInt() - 1;
                    //y con los datos del usuario retiro el coche, en caso de que el espacio solicitado sea libre o 0 le pide que ingrese los datos nuevamente
                    if (estacionamiento[f][c] == 0) {
                        System.out.println("espacio libre, ingrese bien los datos");
                    }
                    else{
                        //en el otro caso, retira el auto exitosamente
                        estacionamiento[f][c] = 0;
                        System.out.println("Usted retiro su auto");
                    }
                    break;
                case 4:
                    
                    //declaro variables para mis contadores
                    int ocupado = 0;
                    int libre = 0;
                    
                    //con eso, y con dos for each, recorro mi array
                    for (int[] i : estacionamiento) {
                        for (int j : i) {
                            //con un if, hago que se cuente los espacios ocupados y libres
                            if (j == 1) {
                            ocupado++;    
                            }
                            else{
                            libre++;
                            }
                        }
                    }
                    //y finalmente los imprimo
                    System.out.println("Espacios ocupados:" + ocupado);
                    System.out.println("Espacios libres:" + libre);
                    break;
                case 5:
                    //en cierro todo para mi archivo de texto, en un try catch
                    try {
                        
                        //creo mi archivo
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    }
                    else{
                         System.out.println("File already exists.");
                    }
                    FileWriter myWriter = new FileWriter("Estacionamiento.txt");
                    
                    //hago lo mismo que en mi primer opcion
                    for (int[] i : estacionamiento) {
                        for (int j : i) {
                            
                            if (j == 1) {
                            myWriter.write(" Ocupado ");    
                            }
                            else{
                            myWriter.write(" Libre ");
                            
                            }
                        }
                        
                        myWriter.write("\n");
                    }
                    
                    myWriter.close();
                    
                    //para cerrar mi objeto de escritura, y salir del while
                    System.out.println("Saliendo de la platafoma....");
                    }
                    catch(IOException e){
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    
                    
                    break; 
                default:
                    break;
            }
            
        } while (op != 5);
        
        
    }
    
}
