 * @author nohemi
 */
public class CrearSistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables
        int numpas;
        Scanner leer = new Scanner(System.in);
        
        System.out.println("numero de pasajeros que serán registrados:");
        numpas=leer.nextInt();
        leer.nextLine();
        
        String [] nom=new String [numpas];
        String[] destinos=new String [numpas];
        
        for(int i=0; i<numpas;i++){
            System.out.println("nombre:");
            String nombre=leer.nextLine();
            
            while (nombre.trim().isEmpty()){
                if(nombre.trim().isEmpty()){
                System.out.println("error, debe escribir su nombre, no puede estar vacio");
                nombre=leer.nextLine();
            }
            }
            nom[i]=nombre;
            
            System.out.println("destino:");
            destinos[i]=leer.nextLine();
        }
        int cdmx = 0;
        int local = 0;
        int otros = 0;
        int indice = 0;
        
        for(String d:destinos){
            String nombrepas=nom[indice];
            System.out.println("pasajero:"+nombrepas+"-destino:"+d);
            
            if (d.equalsIgnoreCase("CDMX")) {
                System.out.print(" -> viaje largo");
                cdmx++;
            } else if (d.equalsIgnoreCase("local")) {
                System.out.print(" -> viaje corto");
                local++;
            } else {
                otros++;
            }
            System.out.println();
            indice++;
            
        }
        System.out.println("total pasajeros registrados:"+numpas);
        System.out.println("cdmx:"+cdmx+"local:"+local+"otros:"+otros);
        
        if(cdmx>local && cdmx>otros){
            System.out.println("destino con mas pasajeros: CDMX");
            
        }else if (local>cdmx && local>otros){
            System.out.println("destino con mas pasajeros: local");
        }else if (otros>cdmx && otros>local){
            System.out.println("destino con mas pasajeros: otros");
        }else{
            System.out.println("hay un empate entre los destinos con mas pasajeros");
        }
    }
}
