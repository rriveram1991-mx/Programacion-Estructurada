import java.util.Scanner;
public class REQ1 {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int p,i,j;
        System.out.println("Cuantos pacientes tiene : ");
        p = scan.nextInt();
        scan.nextLine();
        
         int [] edades = new int[p];
         String[] neims = new String[p];
         int contma=0 ,contme= 0 ,contadul=0;

          for (j=0 ; j< neims.length;j++){
            System.out.println("Ingrese el nombre del paciente "+ (j+1));
            neims[j] = scan.nextLine();
          }
System.out.println("=============================================");
         for (i=0 ; i < edades.length ; i++) {
            System.out.println("Ingrese la edad del paciente "+ neims[i]);
            edades [i] = scan.nextInt();
            
            while (edades[i]<0 || edades[i]> 120){
                System.out.println("Edad invalidad intente de nuevo ");
                edades[i]  = scan.nextInt();
            }
            if (edades[i]<18 ) {
                contme++;
                
                
            }
            else if (edades[i]>=18 &&edades[i] <= 59){
                contadul++;


            }
            else {
                contma++;
            }
         }

        System.out.println("=============================================");
        for (String n : neims){
            System.out.println("Paciente registrado: " + n);
        }
        System.out.println("Los pacientes menores de edad son " + contme);
        System.out.println("Los pacientes adultos son " + contadul);
        System.out.println("Los pacientes prioritarios son "+ contma);

scan.close();
         }
         




    }
    
