import java.util.Scanner;
public class arraybidimencionalEjem1RCC {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        boolean respuesta3=true; //variable para controlar el bucle de reserva de asientos
       String[][] asientos=new String[3][3];
       while (respuesta3){ 
       System.out.println("¿desea ver los asientos de la sala disponibles?");
       String respuesta=leer.nextLine();
       if(respuesta.equalsIgnoreCase("si")){ //condicion para mostrar los asientos disponibles
       for (int i=0;i<asientos.length;i++){
         System.out.println(""+asientos[i][0]+" "+asientos[i][1]+" "+asientos[i][2]);
       }}
         System.out.println("¿desea reservar un asiento?");//condicion para reservar un asiento
       String respuesta2=leer.nextLine();

       if(respuesta2.equalsIgnoreCase("si")){ 
            System.out.println("ingresa el numero de fila(0-2)");
            int fila=leer.nextInt();
            System.out.println("ingresa el numero de columna(0-2)");
            int columna=leer.nextInt();
            if(asientos[fila][columna]==null){
            asientos[fila][columna]="X";
            System.out.println("asiento reservado");
            System.out.println(""+asientos[0][0]+" "+asientos[0][1]+" "+asientos[0][2]);
            }else{
            System.out.println("asiento ocupado");
            }
             leer.nextLine();}
        System.out.println("¿desea seguir reservando asientos?"); //condicion para seguir reservando asientos
            String respuesta4=leer.nextLine();
            if(respuesta4.equalsIgnoreCase("no")){
            respuesta3=false;}}
    leer.close();
    }}

