import java.util.Scanner;

public class SistemaControlNotas{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
//Nota Explicativa: se cambio a un valor double 
        double total = 0;
        //Nota Explicativa: se cambio a un valor double 
        double cantidad = 0;
        boolean salir = false;
        //Nota Explicativa: se cambio a un valor double 
        double nota =0;
        
    int aprobados = 0;
                    int reprobados = 0;

      

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");
//Error Logico: falto poner otro igual 
        while (salir ==false) {

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();
                    //Error Logico: falto iniciar y cerrar llaves
                    //Nota Explicativa: se pone que el i es igual a 1 para no pedir la nota 0
                    for (int i = 1; i <= n; i++){
                      
                      System.out.print("Ingrese nota #" + i + ": ");
                      //Error de Sintaxis: aqui la nota faltaba definirla antes de usarla y quitar el int para no declararla dos veces  
                      nota = sc.nextInt();
                      
                    //Nota Explicativa: se cambia la llave del for para que agarre toda la operacion bien 
                    

//Error Logico: esta mal puesta esta llave 
                        if (nota >= 0 && nota <= 10){
                             total += nota;
                            cantidad++;
                            //Nota Explicativa: agregamos otro if de una sumatoria de notas para que se sepa si tiene materias aprobadas o reprobadas 
                            if (nota>= 7 ){
                                aprobados++;
                            } else {
                                reprobados++;
                            }
                            
                        }
                        //Mala Practica: falta iniciar la llava en else 
                        else{
                            System.out.println("Nota invalida");
                            break;
                        }
                    }
                
                case 2://Error Logico: la operacion del promedio esta equivocada por que aqui esta haciendo un 0/0 ya que aun no se ingresan los datos 
                
                 
            //Error Logico: falta que haga la operacion del promedio 
             double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);
                    //Mala Practica: iniciacion de llaves faltantes 
                    if (promedio >= 9){
                        System.out.println("Excelente");
                    }
                     //Mala Practica: falta lave
                    else if (promedio >= 8){
                        System.out.println("Bueno");
                    }
                    //Error de Sintaxis y Logico: falta de llave y puso mal el ";" error de sintaxis 
                    else if (promedio >= 7){
                        System.out.println("Regular");
                    }
                    //Mala Practica: agregar llaves 
                    else {
                        System.out.println("Reprobado");
                    }
                    //Error Logico: faltaba break 
                    break;

                case 3:
//Nota Explicativa: se movieron los aprovados y repovados al inicio para que puedan iniciar las variables 
                
                
                    //Error Logico: puso ";" cuando no eran necesarios 
                   //Nota Explicativa: se borra el while 
                        
                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                    
                    //Nota Explicativa: estos datos estaban afuera del while por lo que los metimos adentro 

                  

                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                     //Error Logico: falto break 
                     break;

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    //Error Logico: falto break 
                    break;


                default:
                    System.out.println("Opcion no valida");
                    
            }

        }

        sc.close();
    }
}
    //token extra 
