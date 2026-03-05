/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica9;

import java.util.Scanner;
public class Practica9 {
    public static void main(String[] args) {
    Scanner mika = new Scanner (System.in);
    int P,I,X=0,MDE=0,AM=0,A=0;
        System.out.println("Cuantos pacientes se registraran?");
        P = mika.nextInt();
 String [] NOM = new String[P];
 int [] ED = new int[P];
 for (I=0;I<P;I++){
     X++;
     System.out.println("Ingrese nombre del paciente "+X+":");
     NOM[I] = mika.next();
     System.out.println("Ingrese edad del paciente "+X+":");
     ED [I] = mika.nextInt();
     while (ED[I]>120 || ED[I]<=0){
         System.out.println("Edad invalida. Ingrese nuevamente su edad.");
      ED [I] = mika.nextInt();   
     }
     if (ED [I] < 18){
         MDE++;
     }else if (ED[I]>=18 && ED[I]<60){
         A++;
     }else{
        AM++; 
         System.out.println("Paciente prioritario.");
     }
 }
 X=0;
        System.out.println("NOMBRES:");
 for (var N : NOM){
     X++;
     System.out.println("Nombre paciente "+X+" : "+N);
 }
 X=0;
        System.out.println("EDADES:");
 for (var E : ED){
     X++;
     System.out.println("Edad paciente "+X+" : "+E);
 }
        System.out.println("-------------------------------------------------------");
        System.out.println("              PACIENTES PRIORITARIOS: "+AM);
        System.out.println("-------------------------------------------------------");
    
    
    
    }
}
