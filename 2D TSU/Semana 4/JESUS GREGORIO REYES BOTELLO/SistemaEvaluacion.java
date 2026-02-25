/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaevaluacion;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class SistemaEvaluacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        //#1 EL contador esta iniciado desde 1 pero es 0 porque si inicia desde 1 el contador pensara que ya hay un elemento
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

                case 1:
                 //#12 Esto se agrega ya que si volvemos a seleccionar la opcion 1 se empezaran a acumular las calificaciones 
                    contador = 0;
                    total = 0;
                    //#2 En el for hay un punto y coma fuera del parentesis, mala practica y de compilacion
                        for (int i = 0; i <= 5; i++) {
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();
                    //#3 Faltan llaves
                        if (cal >= 0 && cal <= 10){
                            total = total + cal;
                            contador++;
                        }
                            else{
                            System.out.println("Calificacion invalida");
                                    }
                         
                    }
                    break;

                case 2:
                    //#4 Pudes haber una division entre 0 ya que el total es entero
                    double promedio = (double)total / contador;
                    System.out.println("Promedio: " + promedio);
                    break;
                case 3:
                 //#5 Al no tener promedio el sistema nos reprobara automatica mente es mejor volver a preguntar
                  if (contador == 0){
                        System.out.println("NO HAY NOTAS REGISTRADAS");
                        break;
                    }
                
                //#6 EN el if del promedio >8 tenia un punto y coma, mala practica
                //#7 La condicion no va a leer ninguna calificacion porque no bya ninguna operacion y lectura de promedio
                    promedio = (double)total / contador;
                    System.out.println("Promedio: " + promedio);
                    
                    if (promedio >= 9){//#8 falta lave y logico
                     System.out.println("Excelente");
                    }else if(promedio >= 8){//#9 falta lave y logico
                     System.out.println("Bueno");
                    }else if(promedio >= 7){//#10 falta lave y logico
                    System.out.println("Regular");
                    }else{//#111 falta llave y logico
                    System.out.println("Reprobado");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }
//¿Por qué el promedio no es correcto?-El promedio no es correcto por el punto y coma en el for y la falta de llaves tambien
//la divison esta mal ya que puede dar 0 entonces el total lo ponemos como double para que no pase esto

//¿Por qué el programa puede comportarse extraño en el case 1?-Porque hay un punto y coma en el for y la falta de llaves

//¿Por qué el nivel no coincide con el promedio real?-porque No habia una lectura de promedio y faltaban llaves

//¿Por qué podría mostrar “Bueno” siempre? Por el punto y coma hace que la condicion termine ahi
        }

        sc.close();
    }
    
}
