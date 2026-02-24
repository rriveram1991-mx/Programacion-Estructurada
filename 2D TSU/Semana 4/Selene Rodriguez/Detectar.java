/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package detectar;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Detectar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

   

      Scanner  sc = new Scanner(System.in); 
      

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;
        

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir == false) { //6.El bucle no se ejecutaba bien y agrege el signo"!" mas un "=".

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.println("Seleccione opcion: "); // 3.Igual estaba como "print" en vez de "println"
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: "); //1.Aqui estaba con "print" en vez de "prinln"
                    int n = sc.nextInt();
                      total=0;  //17.esto me ayuda a reiniciar los datos antiguos 
                      cantidad=0;
                    for (int i=1; i <= n;i++){  //11.el bucle empieza desde 1 y faltaba una llave.
                        System.out.print("Ingrese nota #" + i + ": "); //2.Aqui igual estaba  como "print" en vez de "println"
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10){ //4.Aqui encontre el error del ";" el if no lleva ";" lleva esta "{"
                            total += nota; 
                            cantidad++;
                        } else {  //5. Aqui no tenia la llave le puse las dos 
                            System.out.println("Nota invalida");
                    }
                    } //19.Faltaba por cerrar una llave 
                        break; //8.Falta un break
                case 2:
                        if (cantidad==0){
                    double promedio = (double) total / cantidad; //13.Aqui me esta pidiendo una division por lo que lleva decimales asi que le pongo "(double)"
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9){
                        System.out.println("Excelente");
                    } else if (promedio >= 8) { //16.  Igual aqui lleva su llave eso hacia en todo el case un error.
                        System.out.println("Bueno");
                            }else if (promedio >= 7){ //14.Aqui no lleva ";" me arroja un error en vez de eso una llave ponemos "{"
                        System.out.println("Regular");
                    } else { //15. En el else siempre llevan dos llaves asi"}else{" ya que asi se ejecuta bien el codigo.
                        System.out.println("Reprobado");
                            }
                    }
                    break;

                case 3:

                    int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
                    while (i < cantidad) {  //7.Aqui no lleva punto y coma porque finaliza el bucle en cambio si dejo la llave se hace un bluce infinito.
                        if (total / cantidad >= 7)
                            aprobados++;
                        else
                            reprobados++;
                        i++;
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:

                    total = 0;
                    cantidad = 0;
                   
                    System.out.println("Datos reiniciados");
                   break; //9.Aqui faltaba un break
                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");

                default:
                    System.out.println("Opcion no valida");
                    break; //12.Faltaba aqui un break
                    }
        }
    }
} 
// En conclusion encontre 19 errores talvez se me paso contar uno mas pero por lo que vi modifique un poquito la logica y los errores mas comunes eran
// que faltaba cerrar llaves como por ejemplo en el "}else{ en el "if" y el error de poner punto y coma en vez de llaves igual en poner un "=" en vez de "=="

    
    
