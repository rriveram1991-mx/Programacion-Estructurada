/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacontrolnotas;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Sistemacontrolnotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
            Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = true;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir== true) {// error logico se le tiene que poner ! para poder entrar

            System.out.println("1. Capturar notas");// No esta dando a entender que ponga correctamente el numero se pueden confundir
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();
            int nota=0;
            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {// error logico se tiene que iniciar desde 1 no desde 0

                        System.out.print("Ingrese nota #" + i + ": ");
                         nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10){// Error logico ya que no se pone ; es con {
                            total += nota;
                            cantidad++;
                        }else{//falto abrir llave
                            System.out.println("Nota invalida");
                    }
                    } // y falto cerrar la llave del for 
                      break;    // faltaba el break
                case 2:

                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9){ // falta de llave 
                        System.out.println("Excelente");
                    }else if (promedio >= 8){ // falta de llave 
                        System.out.println("Bueno");
                    } else if (promedio >= 7){ // error logico no es ; es con llave
                        System.out.println("Regular");
                    }else{
                        System.out.println("Reprobado");}// falta de llave 

                    break;

                case 3:// no funcionara ya que se necesita un arreglo

                   int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
                    while (i < cantidad) //no se pone ;
                    {
                        if (total / cantidad >= 7)
                            aprobados++;
                        else
                            reprobados++;
                        i++;
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break; //faltaba break

                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
break; // faltaba break
                case 5:

                    salir = false;
                    System.out.println("Saliendo del sistema");
              break;
                  //faltaba un break
                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
        
        
    }
    
}
