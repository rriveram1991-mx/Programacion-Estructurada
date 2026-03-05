/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.pkg2sem5;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class REQ12SEM5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner her = new Scanner (System.in);
int pa, loc=0, cdmx=0, tot;
        System.out.println("Cuantos pasajeros desea registrar");
        pa=her.nextInt();
  int[] des=new int[pa];
  String n[]= new String[pa];
  for(int i =0; (i<n.length || i<des.length);i++){
      System.out.println("Inserte nombre de pasajero");
      n[i]=her.next();
      System.out.println("Inserte su destino");
      System.out.println("1.Local");
      System.out.println("2.CDMX");
      des[i]=her.nextInt();
      while(n[i].isEmpty()){
          if(n[i].isEmpty()){
              System.out.println("Nombre vacío.Intente otra vez");}
           n[i]=her.next();
  }
  }
    System.out.println("LISTA DE PASAJEROS");
      int j = 0; 
for (String nombre : n) {
    // Usamos el arreglo 'des' que ya tiene los datos
    int da = des[j]; 
    System.out.print("Pasajero: " + nombre);

    if (da == 2) {
        cdmx++;
        System.out.println(" Destino: CDMX (Viaje largo)");
    } else if (da == 1) {
        loc++;
        System.out.println(" Destino: Local (Viaje corto)");
    } 
    j++;
}

if(loc>cdmx){
    System.out.println("Destino con mas pasajeros LOCAL con "+ loc + " pasajeros");
}      
else{
    System.out.println("Destino con mas pasajeros CDMX con "+ cdmx + " pasajeros");}
      
      tot=loc+cdmx;
      System.out.println("Total de pasajeros: "+tot);     
  }
    }

