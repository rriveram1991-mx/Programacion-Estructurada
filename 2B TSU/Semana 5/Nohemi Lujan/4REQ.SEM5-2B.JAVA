* @author nohemi
 */
public class CrearSistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // variables 
        int pac;
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("¿cuantos pacientes serán registrados?");
        pac=leer.nextInt();
        leer.nextLine();
        
       String[] nom=new String [pac];
       int[]edades=new int [pac];
       
       for (int i=0; i<pac;i++){
           System.out.println("ingrese el nombre");
           nom[i]=leer.nextLine();
           
           System.out.println("ingrese la edad");
           int edad=leer.nextInt();
           
           while (edad<0 || edad>120){
               if (edad<0 || edad>120){
                   System.out.println("Edad no valida, intente de nuevo");
                   edad=leer.nextInt();
               }
               }
              edades[i]=edad;
               leer.nextLine();
           }
       int mene=0;
       int adul=0;
       int adulm=0;
       int prio=0;
       
       int indice=0;
       for (int e:edades){
           String nomb=nom[indice];
           System.out.println("paciente:"+nomb+"-edad:"+e);
           
           if (e<18){
               mene++;
           }else if (e>=18 && e<=59){
               adul++;
           }else if (e>=60){
               adulm++;
               System.out.print("*paciente prioritario*");
               prio++;
           }
           System.out.println();
          indice++;
       
           
       }
        
        System.out.println("menores de edad:"+mene);
        System.out.println("adultos:"+adul);
        System.out.println("adultos mayores:"+adulm);
        System.out.println("total de pacientes prioritarios:"+prio);
        
        
        
    }
    
}
