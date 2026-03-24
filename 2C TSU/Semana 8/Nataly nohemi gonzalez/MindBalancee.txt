/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mind.balance;
 import java.util.Scanner;
/**
 *
 * @author LABTICS
 */
public class MindBalance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Scanner entrada = new Scanner(System.in);
        
        // arrays simples
        int[] animo = new int[7];  // 7 dias
        boolean[][] actividades = new boolean[7][4];  // 7 dias x 4 actividades
        int dias = 0;  // cuantos dias tengo
        
        System.out.println("Mind Balance");
        System.out.println("1=mal 2=regular 3=bien 4=muy bien 5=feliz");
        
        int opcion;
        do {
            System.out.println("\nMENU:");
            System.out.println("1= Poner animo");
            System.out.println("2= Poner actividades");
            System.out.println("3= Ver todo");
            System.out.println("4= Consejo");
            System.out.println("5= Salir");
            
            System.out.print("como te sientes ? ");
            opcion = entrada.nextInt();
            
            if(opcion == 1) {
                // registrar animo
                if(dias < 7) {
                    System.out.print("Animo hoy (1-5): ");
                    int miAnimo = entrada.nextInt();
                    animo[dias] = miAnimo;
                    dias++;
                    System.out.println("ok guardado");
                } else {
                    System.out.println("semana llena");
                }
            }
            
            else if(opcion == 2) {
                // actividades
                if(dias > 0) {
                    int dia = dias - 1;
                    System.out.println("actividades dia " + dia + ":");
                    System.out.print("ejercicio? (1=si 0=no): ");
                    actividades[dia][0] = entrada.nextInt() == 1;
                    System.out.print("meditacion? (1=si 0=no): ");
                    actividades[dia][1] = entrada.nextInt() == 1;
                    System.out.print("agua? (1=si 0=no): ");
                    actividades[dia][2] = entrada.nextInt() == 1;
                    System.out.print("sueño? (1=si 0=no): ");
                    actividades[dia][3] = entrada.nextInt() == 1;
                    System.out.println("guardado");
                } else {
                    System.out.println("primero animo");
                }
            }
            
            else if(opcion == 3) {
                // resumen
                if(dias == 0) {
                    System.out.println("no hay datos");
                } else {
                    // promedio
                    int suma = 0;
                    for(int i=0; i<dias; i++) {
                        suma = suma + animo[i];
                    }
                    double promedio = (double)suma / dias;
                    
                    // contar actividades
                    int totalAct = 0;
                    for(int d=0; d<dias; d++) {
                        for(int a=0; a<4; a++) {
                            if(actividades[d][a]) totalAct++;
                        }
                    }
                    
                    System.out.println("RESUMEN:");
                    System.out.println("promedio: " + promedio);
                    System.out.println("actividades: " + totalAct + "/" + (dias*4));
                    
                    if(promedio < 3) {
                        System.out.println("BIENESTAR: MALO");
                    } else if(promedio < 4) {
                        System.out.println("BIENESTAR: MEDIO");
                    } else {
                        System.out.println("BIENESTAR: BUENO");
                    }
                }
            }
            
            else if(opcion == 4) {
                // consejos
                if(dias == 0) {
                    System.out.println("no hay datos");
                } else {
                    double prom = 0;
                    int suma = 0;
                    for(int i=0; i<dias; i++) {
                        suma += animo[i];
                    }
                    prom = (double)suma / dias;
                    
                    System.out.println("CONSEJO:");
                    if(prom < 3) {
                        System.out.println("trata de descansar mas , necesitas tomar un respiro");
                        System.out.println("trata de meditar un poco , te ayuda a relajarte");
                    } else if(prom < 4) {
                        System.out.println("haz ejercicio ,te hara mejorar tu estado de animo y te dara mas energia");
                        System.out.println("trata de tomar mas agua , te dara mas energia y te mantendraa mas sano");
                    } else {
                        System.out.println("estas genial!");
                        System.out.println("sigue asi");
                    }
                }
            }
            
        } while(opcion != 5);
        
        System.out.println("bai bai");
        entrada.close();
    }
}
   