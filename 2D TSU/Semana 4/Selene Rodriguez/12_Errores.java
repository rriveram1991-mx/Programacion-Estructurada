/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package detectar12_errores;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Detectar12_errores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        //14.ERRROR LOGICO 
        int contador = 0;

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:                              //Aqui en error 7 es de compilacion
                    for (int i=1; i <= 5;i++) {  //7.El puto y coma ";" hacia que me diera la advertencia de que estaba mal, ahi no va
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();

                        if (cal >= 0 && cal <= 10){ //5.Faltaba una llave
                            total = total + cal;
                            contador++;
                }else{
                            System.out.println("Calificacion invalida");
                        }
                } //6. Faltaba en cerrar una llave
            
                    break;

                case 2:
                    if (contador==0){ //10.Agregue esta variable para que si al momento de que el usuario ponga 0 salga este mensaje. 
                        System.out.println("NO hay calificacion.");
                    }else{
                        //Errror logico agregue "(double)" para que dividiera en decimales tambien.
                    double promedio = (double)total / contador;  // 9.Le gregue el "double" porque es una division y tiene que aparecer tambien con punto decimal. 
                    System.out.println("Promedio: " + promedio);
                    break;
                    }
            
            break;
                case 3:
                    if (contador==0){  //11.Lo agregue porque antes no habia ninguna validacion para que el usuario intetara ver el nivel.
                        System.out.println("No hay calificaciones");
                    }else{
                       //En estas lineas habia errores logicos que los cambie `por la variable promedio. 
                       //Y puse "(double)" para que dividiera en decimales tambien es error logico.
                       //Aqui son malas practicas tambien ya que antes se hacia la misma operacion 3 veces por dividir "total/contador"
                    double promedio = (double) total/contador; //12.Lo agregue ya que antes estaba haciendo una division entera. 
                    if (promedio>= 9){//8.Aqui no estoy dividiendo si, no que si promedio es mayor o igual sera excelente y si es mayor a 8 "bueno".
                        System.out.println("Excelente");
                        //1. Error de compilacion.
                   }else if (promedio >= 8){ //1. en vez de ";" le pongo una llave ya que si lo dejo finaliza y si pongo la llave el bucle se vuelve finito y igual es promedio
                        System.out.println("Bueno");
                    }      else if (promedio >= 7){    //3.Faltaba dos llaves, igual lleva promedio no una division 
                        System.out.println("Regular");
                    }else{   //4.Faltaban llaves
                        System.out.println("Reprobado");  // Esta `parte tuve que cambiar "total/contador" y reemplazarla por la variable "promedio" ya que el programa 
                        //estaba haciendo varias veces una division y puse "promedio" ya que asi hace la operacion una unica vez y va como conservando el valor.
                   
                    break;
                    }//13.Por ultimo cerre la llave de la cual        
                    }
                            //2. faltaban 1 llaves para cerrar el else if 
                          
                case 4:
                    System.out.println("Saliendo...");
                    break;
    
                default:
                    System.out.println("Opcion incorrecta");
            }
        }}

        }

//¿Por qué el promedio no es correcto? Porque estaba haciendo una divion tipo entera "total/contador", y el contador tiene que ver ahi 
    //ya que estaba en 1 en vez de 0 y eso hacia que generara errores cuando no habia calificaciones.

//¿Por qué el programa puede comportarse extraño en el case 1? Checando bien en esa parte pienso que es por el punto y coma haciendo que no se ejecutara bien y faltaban llaves y cerrarlas
  //haciendo que el contador se ejecutara cuando no debia ejecutarse.

//¿Por qué el nivel no coincide con el promedio real? Por la division entera "total/contador" que esto hacia que los valores puedan cambiar

//¿Por qué podría mostrar “Bueno” siempre? Porque habia un punto y coma sobrante eso hacia que la condicion se cerrara y impedia que se ejecutara bien el codigo.

        
    

    

