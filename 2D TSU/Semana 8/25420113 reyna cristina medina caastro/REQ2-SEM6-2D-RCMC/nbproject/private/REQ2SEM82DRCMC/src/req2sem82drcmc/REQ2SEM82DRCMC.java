/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req2sem82drcmc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class REQ2SEM82DRCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner leer=new Scanner(System.in);
       int diasr=0;
       //crear arrays para las actividades
       int []estado=new int [7];
       String act [][]=new String [7][3];
       //crear el menu
        System.out.println("Bienvenido al sistema de salud mentall");
        System.out.println("Que desea hacer hoy?");
        System.out.println("1.Registrar estado de animo");
        System.out.println("2.Registrar actividades saludables");
        System.out.println("3.Mostrar resumen de tu bienestar");
        System.out.println("4.Dar recomendaciones");
        System.out.println("5.Salir");
        int opc;
        opc=leer.nextInt();
        do{
            //segun la opcion hay que gacer
        switch (opc){
            case 1 -> {//registrp del estado de animo
                System.out.println("Registre su estado de animo de hoy");
                if (diasr < 7) {//la escala
                    System.out.println("Nivel: 1(Muy mal) a 5(Excelente)");
                    System.out.print("Día " + (diasr + 1) + " - como te sientes el dia de hoy?");
                    leer.nextLine();
                    //leer el estado de animo
                    estado[diasr] = leer.nextInt();
                    System.out.println("guardado");
                } else {
                    System.out.println("listp");
                }
            }
           
            case 2 -> {//registrar las actividades saludables
                System.out.println("Registro de actividades saludables realizadas");
                if (diasr < 7) {
                    leer.nextLine();
                    //hacer preguntas pasra ello
                    System.out.print("hiciste ejercicio (si o no)");
                    act[diasr][0]=leer.nextLine();
                    System.out.print("hiciste algun tipp de meditacion o yoga (si/no): ");
                    act[diasr][1] = leer.nextLine();
                    System.out.print("Tomaste agua agua? (si/no): ");
                    act[diasr][2]=leer.nextLine();
                    diasr++;
                    System.out.println("Actividade registradasd.");
                } else {
                    System.out.println("todos los dias ya fueron ocupados ");
                }
            }
                 case 3 -> {//registrar los habitos saludbables.proimddios y asi
                     if (diasr== 0) {
                         System.out.println("No se puede");
                     } else {
                         double suma = 0;
                         for (int i = 0; i < diasr; i++) {
                             suma +=estado[i];
                         }
                         double promedio =suma/diasr;
                         
                         int totalactividades = 0;
                         for (String[] dia :act){
                             
                             for (String actividad:dia) {
                                 
                                 if (actividad!= null && actividad.equalsIgnoreCase("si")) {
                                     totalactividades++;
                                 }
                             }
                         }
                         //aqui damos el resumen de la semana, promedio
                         System.out.println("resumen dela semana");
                         System.out.printf("Promedio del estado de animo:%2f%n",promedio);
                         System.out.println("Total " + totalactividades);
                         
                         String nivel = (promedio < 3) ? "Bajillo" : (promedio <= 4) ? "Mas o menos hijo" : "Altooooo";
                         System.out.println("nivel del bienestar: " + nivel);
                     }
            }//recomendaciones segun el promedio
                        
                      case 4 -> {
                          if (diasr==0){
                              System.out.println("Registrate ");
                          } else {
                              double sumaRec=0;
                              for (int i=0;i<diasr;i++)sumaRec+=estado[i];
                              double prom = sumaRec/diasr;
                              
                              System.out.print("recomendaciones para ti <3");
                              if (prom<3) {
                                  System.out.println("deberias de priorizarte mas y de descansar mas y asi");
                              } else if (prom>=3 && prom<4) {
                                  System.out.println("vas b ien, solo te falta algo de ejercicioi");
                              } else {
                                  System.out.println("excelente hijo, todo super biej");
                              }
                          }
            }
//salir
                case 5 -> System.out.println("byeeeeeeeeeeeeeeeee");
//por defecto
                default -> {
                    System.out.println("no existe esta opcion");}
        }}
                    while (opc !=5);
            }
        
    
        }