/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem8_mhlf;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class REQ1SEM8_MHLF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int op;
        int [] estado = new int[5];  
        int act=0;
        double p=0.0;
        String [][] actividades = new String [7][10];
        
        do{
        System.out.println("""
                           1. Registrar estado de animo diario
                           2. Registrar actividades saludables realizadas
                           3. ver resumen
                           4. Recomendaciones automaticas
                           5. Salir""");
        op = leer.nextInt();
        switch(op){
            case 1 -> { 
                System.out.println("""
                                                       1.muy mal
                                                       2. mal
                                                       3. masomenos
                                                       4. bien
                                                       5. muy bien""");
                for(int i=0;i<estado.length;i++){
                    System.out.println("ingresa tu estado de animo en el dia " +(i+1));
                    estado[i] = leer.nextInt();
                    if(estado[i]>=1 && estado[i]<=5){
                        System.out.println("se a registrado correctamente");
                        
                    }else{
                        System.out.println("del 1 al 5 broo");
                        i--;
                    }
                }   }
            case 2 -> {
                System.out.println("--Ingresa tus actividades--");
                act = leer.nextInt();
                if (act >=10){
                    System.out.println("maximo 10 actividades por dia");
                    act=10;
                }
                for(int i=0;i<7;i++){
                    System.out.println("actividades del dia"+(i+1));
                    for(int j=0;j<act;j++){
                        actividades[i][j] = leer.next();
                    }
                }
                }
                  
                  
        case 3 -> { 
            boolean d=false;
            for(int i=0;i<estado.length;i++){
                if(estado[i] !=0){
                    d=true;
                    break;
                }
                
            }
            
            if(!d){
                
                System.out.println("no hay datos registrados aun");
            }else{
                int suma=0;
                for(int i=0;i<estado.length;i++){
                    suma+=estado[i];
                }
                p= (double) suma/estado.length;
                
                for (int i = 0; i <5; i++) {
                    System.out.println("dia "+(i+1)+": "+estado[i]);
                }
                System.out.println("Promedio del estado de anime: "+p);
                int dia=1;
                for(String[] fila : actividades){
                    System.out.println("dia "+dia++);
                    for(String actividad: fila) {
                        if(actividad !=null){
                            System.out.println("-"+actividad);
                        }
                    }
                }
                
                
                
            }    }
        
        case 4 -> {
            int suma=0;
            for(int i=0;i<estado.length;i++){
                suma+=estado[i];
            }
            p= (double) suma/estado.length; 
            if(p==0){
                System.out.println("ingresa primero los valores");
            
            }else if(p<3){
                System.out.println("recomiendo descanso, relajacion constante y no te preocupes por meditacin todo mejorara");
            }else if(p >=3 && p<=4 ){
                System.out.println("te recomendamos realizar un minimo de actividad fisica para mejor el pensamiento, ntp todo mejorara");
            }else{
                System.out.println("excelente burruaga");
            }}
        
        case 5 -> System.out.println("vuelva pronto broo");
       
        
        default -> System.out.println("ingrese del 1-5 porfavor");
           
        }
        }while(op != 5);
    }
    
}
