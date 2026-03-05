/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1sem5;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class REQ1SEM5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner her = new Scanner (System.in);
int pa;
 int cmen=0, cmay=0, ad=0,am=0;
        System.out.println("Cuantos pacientes desea registrar");
        pa=her.nextInt();
  int[] v=new int[pa];
  String n[]= new String[pa];
 
  for(int i =0; i<pa;i++){
        System.out.println("Inserte nombre del paciente"+(i+1)+ ": ");
        n[i]=her.next();
               boolean edadCorrecta = false;
    while (!edadCorrecta) {
        System.out.println("Inserte edad:");
        v[i] = her.nextInt();
        if (v[i] < 0 || v[i] > 120) {
            System.out.println("Edad inválida. Intente de nuevo.");
        } else {
            edadCorrecta = true; 
        }
  }
  }
  int j=0;
        for(int ed:v){
            if (ed<18){
            cmen++;}   
            else{
            if (ed>=18 && ed<=59)
                ad++;
            else{
            if(ed>59)
                am++;}
            }
            
            if (am>0){
                System.out.println("Paciente prioritario");}
        }
        
             System.out.println("Menores de edad:"+ cmen);
            System.out.println("Adultos:"+ad);
            System.out.println("Adultos mayores"+am);
        }
    } 


    
