/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package err;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class Err {

    /**
     * LEIDY NEREIDA IBARRA CONTRERAS 2"C"
     */
    public static void main(String[] args) {
    

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        double total=0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir==false)
        {
           

            System.out.println("1. Capturar notas");
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

                    for (int i =1;i <= n; i++) {

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10){
                            total += nota;
                            cantidad++;
                        }
                            else {
                            System.out.println("Nota invalida");
                    }      
                    }
                    
                                break;
                case 2:
                    double     promedio = total / cantidad;

                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9){
                        System.out.println("Excelente");
                    }
                    else if (promedio >= 8){
                        System.out.println("Bueno");}
                    else if (promedio >= 7){
                        System.out.println("Regular");}
                    else{
                        System.out.println("Reprobado");
                    }
                    break;
                    
                case 3:

                    int aprobados = 0;
                    int reprobados = 0;
                  
                    int i = 0;
                    while (i <= cantidad){
                        if(total/cantidad >= 7){
                            aprobados++;}
                        else {
                            if(total/cantidad < 7){
                            
                                reprobados++;}
                        i++;
                    
                            
                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                        }}
                    break;
                       
                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
break;
                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        
        }

      
}
}

/// ERROR
///1linea de código 23 ,le cambie el tipo de dato ,para mas adelante poder realizar una  division q contenia datos decimales(promedio).(LOGICO)
///2linea de código 28, EN EL WHILE EL "="no dejaba q el ciclo si quiese empezara por que no era una igualacion, lo cambie por un "=="(LOGICO)
///3linea de código 48 ,modifique la inicializacion de "i" de 0 a 1 , ya que al dejarla en 0 al total de calificaciones elegidas por el usuario se le aumentaria 1.(LOGICO)
///4linea de código 53, la comdicion if, tiene ";" al final lo cual cierra la condicion , no se ejecuta por que no sale de ahi.(COMPILACION)
///5linea de codigo 53 y 56 ,aplico corchetes para abrir y cerrar condicion if.(COMPILACION)
///6linea de código 57 y 59 aplico cocrchetes para cerrar y abrir el else de mi primera conddición.(COMPILACION)
///7linea de código 62, agrtegamos el breake , para asi cerrar el caso 1 y poder abrir el siguiente caso.(COMPILACION)
///8linea de código 64 , es la division hablada q no se podia realizar por contener dos datos de tipo entero y querer realizar una div double.(LOGICO))
///9linea de código 68 y 70 abrimos corchete de condicion y la cerramos.(COMPILACION)
///10liena de código 71 y 72 aplicamos corchetes para if else.(COMPILACION)
///11linea de código 73 quitamos el ";" de nuestro else if , por que no deja que evalue la condición al ropmerla .(COMPILACION)
///12linea de código 73 y 74 agregamos corchetes para abrir y cerrar.(COMPILACION)
///13linea de código 75 y 77 de nuevo corchetes y cerramos el else final.(COMPILACION)
//14linea de codigo 86 , en nuestra condición de whule , aplicamos un = a la condicion para que pueda entrar , ya que tiene valor de 0 y ambos valen 0, no puede ser menor asi q ponemos si es igual.(LOGICO)
//15linea de código 87 y 88, agregamos corchetes (COMPILACION)
// 16 linea de código  89 y 96, agregamos corchete de abrir y lo cerramos en la linea 96.(COMPILACION)
//17 linea de código 104 ,agregammos el break para cerrar ese caso.(COMPILACION)
//18 linea de código 109 , agrego el break para cerrar nuestro ultimo caso, y dar espacio al default.(COMPILACION)
//19 linea de código 116 no es necesario cerrar el scanner al ya finalizar el co´digo.
// 20 linea de código 90 agregamos un if dentro del else ,condiconando promedio menor a 7 metera los valores a rep, y si no agrego notas , respetara los valores.(COMPILACIÓN)

