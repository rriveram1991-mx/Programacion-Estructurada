/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication52;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class JavaApplication52 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String[] e = new String[10];
        int r;
        boolean s=false;
        for(int i=0;i<e.length;i++){
        e[i]="libre";// creo esto para que salag libre en vez de null
        
        }
        while(!s){// while normal creo el boolean para salir
            System.out.println("1.Ver estacionamiento");
            System.out.println("2.Estacionar auto");
            System.out.println("3.Retirar auto");
            System.out.println("4.Contar espacios ocupados");
            System.out.println("5.Salir");
            r = leer.nextInt();
        switch(r){
            case 1 -> {
                for(int i=0;i< e.length; i++){//coloco el for para seguir indicaciones
                    System.out.println("espacios del estacionamiento "+(i+1)+":"+ e[i]);
                }   }
            case 2 -> {
                System.out.println("ingresa tu numero de espacio");
                int es = leer.nextInt()-1;
                leer.nextLine();//este lo uso para limpiarlo y no me de error
                if(es>=0 && es< e.length){// colo el entre por si colocoa menos del 0 o ams del 10 le suelte un error
                    if(e[es].equals("libre")){// aque esta este if para cambiar de libre a ocupado
                        e[es]="ocupado";
                    }else{
                        System.out.println("error ya esta ocupado");
                    }
                }else{
                    System.out.println("error espacio invalido");
                }   }
            case 3 -> {
                System.out.println("ingrese el numero del espacio");
                    int es = leer.nextInt()-1;
                    leer.nextLine();
                    if(es>=0 && es< e.length){//se usa por si pone de mas o de menos le suelte un error
                        if(e[es].equals("ocupado")){//igual que ;p anterior lo uso para comparar
                            e[es]="libre";
                        }else{
                            System.out.println("error ya esta libre");
                        }
                    }else{
                        System.out.println("error espacio invalido");
                    }   }   
            
            case 4 -> {
                int c = 0;//uso este ocmo un contador
                for(String espacio : e){
                    if (espacio.equals("ocupado")){// uso este para mostrar cuales estan ocupado eh igual como contador
                        c++;
                    }
                }
                System.out.println("espacios ocupados: " + c);
                System.out.println("espaciso librs: " + (e.length - c));
                }
            case 5 -> {
                try { File myObj = new File("estacionamineto.txt");
                if(myObj.createNewFile()){
                    System.out.println("archivo creado: "+ myObj.getName());
                }else{
                    System.out.println("el archivo ya existe");
                }
                    try (FileWriter archivo = new FileWriter("estacionamineto.txt")) {
                        archivo.write("     ESTACIONAMIENTO    \n\n");
                        
                        for(int i = 0; i< e.length;i++){
                            archivo.write("estacionamiento "+(i+1)+":"+e[i] + "\n" );
                            
                        }   }
                System.out.println("archivo estacionamineto se guardo correctamente");
                
                } catch (IOException ex){
                    System.out.println("error al guardadar");
                    
                }   s=true;//lo uso para salir
                System.out.println("saliendo de sistema..");
                    //por si usa otro diferente
                }
             default -> System.out.println("opcion invalida");
                   }
          
        }
    }
}
        
        
        
        
    
    

