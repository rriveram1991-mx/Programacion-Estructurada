/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2;

/**
 *
 * @author Guillermo
 */
//¿Por qué el promedio no es correcto?
//por que estabamos usando un contador mal definido por que estaba inicializado en 1 y siempre suma un numero extra a cada valor que le damos
//¿Por qué el programa puede comportarse extraño en el case 1?
//no se comporta extraño el problema es que no tiene donde mostrar las calificaciones
//¿Por qué el nivel no coincide con el promedio real?

//¿Por qué podría mostrar “Bueno” siempre?
    import java.util.Scanner;
public class S4_Deteccion2_Sistema_de_Evaluacion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
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
                total = 0;//13.Tiene que estar dentro del case para cada vez que queramos caputar calificacion de nuevo se reinice a 0
               contador = 0;//7 el contador esta inicializado en 1 y siempre va sumar un numero mas 
                            //14.Nunca iba a dar bien la segunda captura de calificaciones por que nunca se reiniciaba a 0 
                    // 1. en este case el for esta forzado a cerrar con el punto y como
                    for (int i = 1; i <= 5; i++) {
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();

                        if (cal > 0 && cal <= 10){//2.El if estaba sin abrir y cerrar
                            total = total + cal;   //4.Condicion del if mal
                            contador++;            //5.No tiene donde mostrar el resultado 
                     
                        }
                        else{
                            System.out.println("Calificacion invalida");
                            break;//11.Al dar una calificacion inavlida te seguia dejando poner mas calificaciones cuando no deberia 
                        }       
                    }
                     System.out.println("Total: " + total);
                    break;
                    
                case 2:
                    double promedio = (double) total / contador;//12.La divison esta mal hecha hace division entera 
                    System.out.println("Promedio: " + promedio);
                    break;

                case 3:
                    if (total / contador >= 9){//3.El switch esta sin abrir y cerrado por ;
                        System.out.println("Excelente");
                    }
                    else if (total / contador >= 8){//8.El else if esta forzado a cerrarse por el punto y coma que tenia antes 
                        System.out.println("Bueno");//9.No tenia llaves el ese if y haci que el no funcionara el else if unidado 
                                }
                    else if (total / contador >= 7){//10.Ningun ese if tenia llaves de aprtura ni de cerradura y eso generaba un conflicto 
                        System.out.println("Regular");
                    }
                    else{
                        System.out.println("Reprobado");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");//6.El default no tiene break y nunca va terminar el ciclo de while 
                    break;
            }
         
        }
        sc.close();
    }

}
