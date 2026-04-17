package crud_2B;

import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        Connection prueba = conexion.getConnection();

        if (prueba != null) {
            System.out.println("¡Éxito!");
        } else {
            System.out.println("fallo");
        }
    }
}