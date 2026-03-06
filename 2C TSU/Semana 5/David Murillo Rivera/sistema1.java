import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class sistema1 {
    public static void main(String[] args) {
        List<String> nombres =new ArrayList<>();
        List<Integer> edad = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String nombre;
        int edades,pacientesT , cont1=0 , cont2=0 , cont3=0;
        System.out.println("Teclea el total de pacientes registrar");
        pacientesT=sc.nextInt();
        for(int i=1;i<=pacientesT;i++){
        System.out.println("Teclea el nombre del paciente"+i);
        nombre= sc.nextLine();
        sc.nextLine();
        nombres.add(nombre);
        System.out.println("Teclea su edad");
        edades=sc.nextInt();
        while (edades<0 || edades>120) {
            edad.add(edades);
        }
        if (edades<0 || edades>120)
        {
            System.out.println("Edad invalida");
            System.out.println("Teclea la edad nuevamente");
            edades=sc.nextInt();
            edad.add(edades);
        }
        }
         for (String mostrar  : nombres ) {
             System.out.println(mostrar);
            }
            for (Integer integer : edad) {
                System.out.println(edad);
                if(integer<18){
                    cont1++;
                }
                if(integer>=18 ||integer<=59){
                    cont2++;
                }
                if(integer>=60){
                    cont3++;
                    System.out.println("paciente prioritario");
                } 
            }
            System.out.println("Menores de edad : "+cont1);
            System.out.println("Mayores de edad : "+cont2);
            System.out.println("Pacientes prioritarios totales : "+cont3);
            sc.close();
    }

}
