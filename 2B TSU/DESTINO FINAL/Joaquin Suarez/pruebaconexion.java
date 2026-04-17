package crud_2B;

import java.sql.Connection;

public class pruebaconexion {
    private static conexion Conexion;

    public static void main (String[] args){
            Connection prueba = Conexion.getConnection();
            if(prueba!= null) {
                System.out.println("exito");
            }else{
                System.out.println("error en conexion");
            }
    }
}
