/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s8.mindbalance;

import java.util.Scanner;

public class S8MindBalance {

    public static void main(String[] args) {
        // Scanner y variables
        Scanner sc = new Scanner(System.in);
        
        int[] estadoAnimo = new int[7];
        String[][] actividades = new String[7][3];
        
        int diaActual = 0;
        int opcion;
        
        // 
        do{
            System.out.println("\n===========================");
            System.out.println("\n====== MIND BALANCE ======");
            System.out.println("Dia Actual: " + Math.min(diaActual + 1, 7) + "/7");
            System.out.println("1) Registrar estado de animo.");
            System.out.println("2) Registrar actividades.");
            System.out.println("3) Ver resumen.");
            System.out.println("4) Ver recomendacion.");
            System.out.println("5) Salir.");
            System.out.println("\n===========================");
            System.out.print("Selecciona una opcion: ");
            
            while(!sc.hasNextInt()){
                System.out.print("Ingresa un numero valido.");
                sc.next();
            }
            
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    if(diaActual < 7){
                        System.out.println("\n===== ESTADO DE ANIMO =====");
                        System.out.println("1) Muy mal.");
                        System.out.println("2) Mal.");
                        System.out.println("3) Neutral.");
                        System.out.println("4) Bien.");
                        System.out.println("5) Excelente.");
                        System.out.print("Ingresa un valor (1 - 5): ");
                        
                        int estado = sc.nextInt();
                        
                        if(estado >= 1 && estado <= 5){
                            estadoAnimo[diaActual] = estado;
                            System.out.println("Estado guardado para el dia " + (diaActual + 1) + ".");
                        }
                        else{
                            System.out.println("Numero invalido.");
                        }
                    }
                    else{
                        System.out.print("Ya registraste los 7 dias.");
                    }
                    break;
                    
                case 2:
                    if(diaActual < 7){
                        sc.nextLine();
                        System.out.println("\nIngresa 3 actividades saludables: ");
                        
                        for(int i = 0; i < 3; i++){
                            System.out.print("Actividad " + (i + 1) + ": ");
                            actividades[diaActual][i] = sc.nextLine();
                        }
                        
                        System.out.println("Actividades registradas para el dia " + (diaActual + 1) + ".");
                        diaActual++;
                    }
                    else{
                        System.out.println("Ya completaste los 7 dias.");
                    }
                    break;
                    
                case 3:
                    int suma = 0;
                    int contadorDias = 0;
                    
                    for(int i = 0; i < estadoAnimo.length; i++){
                        if(estadoAnimo[i] != 0){
                            suma += estadoAnimo[i];
                            contadorDias++;
                        }
                    }
                    
                    if(contadorDias > 0){
                        double promedio = (double)suma / contadorDias;
                        
                        System.out.println("\n====== RESUMEN ======");
                        System.out.println("Promedio: " + promedio + ".");
                        
                        if(promedio < 3){
                            System.out.println("Nivel de bienestar: Bajo.");
                        }
                        else if(promedio < 4){
                            System.out.println("Nivel de bienestar: Medio.");
                        }
                        else{
                            System.out.println("Nivel de bienestar: Alto.");
                        }
                        
                        // Peor dia
                        int peorDia = -1;
                        int peorValor = 6;
                        
                        for(int i = 0; i < estadoAnimo.length; i++){
                            if(estadoAnimo[i] != 0 && estadoAnimo[i] < peorValor){
                                peorValor = estadoAnimo[i];
                                peorDia = i;
                            }
                        }
                        
                        if(peorDia != -1){
                            System.out.println("Peor dia: Dia " + (peorDia + 1) + " con valor " + peorValor + ".");
                            
                            if(peorValor <= 2){
                                System.out.println("Mensaje motivacional.");
                            }
                        }
                    }
                    else{
                        System.out.println("No hay datos registrados.");
                    }
                    
                    int totalActividades = 0;
                    
                    for(String[] dia : actividades){
                        for(String act : dia){
                            if(act != null && !act.isEmpty()){
                                totalActividades++;
                            }
                        }
                    }
                    
                    System.out.println("Actividades registradas: " + totalActividades + ".");
                    break;
                    
                case 4:
                    int sumaRec = 0;
                    int contRec = 0;
                    
                    for(int val : estadoAnimo){
                        if(val != 0){
                            sumaRec += val;
                            contRec++;
                        }
                    }
                    
                    if(contRec > 0){
                        double promedio = (double)sumaRec / contRec;
                        
                        System.out.println("\n====== RECOMENDACION ======");
                        
                        if(promedio < 3){
                            System.out.println("Descansa y practica meditacion.");
                        }
                        else if(promedio < 4){
                            System.out.println("Realiza ejercicio fisico.");
                        }
                        else{
                            System.out.println("Excelente. Sigue asi.");
                        }
                    }
                    else{
                        System.out.println("No hay datos para recomendar.");
                    }
                    break;
                    
                case 5:
                    System.out.println("\nGracias por usar MindBalance.");
                    break;
                    
                default:
                    System.out.println("Opcion invalida.");
            }
        }
        
        while(opcion != 5);
    }
    
}
