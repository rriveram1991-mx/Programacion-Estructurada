package crud_2B;



import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        Connection prueba = Conexion.getConnection();

        if (prueba != null) {
            System.out.println("¡Éxito! El puente a la región Pokémon está abierto.");
        } else {
            System.out.println("Algo falló, revisa tu contraseña o si MySQL está encendido.");
        }
    }
}
