import java.util.Scanner;

public class SistemaEvaluacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        double total = 0; //se cambio a double para tener decimales
        int contador = 0; //empezamos en 0 para que el promedio sea real

        System.out.println("=== SISTEMA DE EVALUACION ===");

         while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                //error comun: se le quito ";" en el for, porque estaba generando un error al ejecutar
                case 1:
                    total = 0;    // Reiniciamos para que no se sumen con las anteriores
                    contador = 0;
                    for (int i = 1; i <= 5; i++) {
                        System.out.print("Ingrese calificacion " + i + ": ");
                        double cal = sc.nextDouble(); //se cambio a double para que acepte decimales
                        //error comun: le faltaron las llaves "{}" para no generar error en else
                        if (cal >= 0 && cal <= 10){
                            total = total + cal;
                            contador++;
                        } else {
                            System.out.println("Calificacion invalida");
                            i--;//para repetir turno
                        }
                    }
                    break;

                case 2:
                    //se agrego un if por si se quiere ingresar a la al promedio sin capturar calificaciones
                    if (contador == 0) {
                        System.out.println("Error: Primero capture calificaciones (Opcion 1).");
                    } else {
                        double promedio = total / contador; 
                        System.out.printf("Promedio: %.2f\n", promedio); 
                    } //se agrego llaves
                    break;

                case 3:
                    if (contador == 0) {
                        System.out.println("Error: No hay datos para evaluar.");
                    } else {
                        double prom = total / contador; //de declaro una nueva variable para sascar de una vez el resultado
                        System.out.print("Nivel: ");
                        //se agrego un limitador en cada calificacion para que no se mezclen los resultados
                        if (prom >= 9 && prom <= 10) {
                            System.out.println("Excelente");
                        } else if (prom >= 8 && prom < 9) {
                            System.out.println("Bueno");
                        } else if (prom >= 7 && prom < 8) {
                            System.out.println("Regular");
                        } else {
                            System.out.println("Reprobado");
                        }//se agrego llavas 
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        }

        sc.close();
    }
}
