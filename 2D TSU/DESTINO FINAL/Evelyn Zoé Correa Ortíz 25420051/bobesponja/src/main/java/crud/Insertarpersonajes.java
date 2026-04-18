package crud;
import crud.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insertarpersonajes {

    // Quitamos el 'static' para que puedas usarlo con 'pk.insertar' en el Main
    public void insertar(String v1, String v2) {
        Connection conexion = Conexion.getConnection(); // Asegúrate que la clase Conexion esté accesible
        try {
            String sql = "INSERT INTO personajes(nombre, color) VALUES (?,?)";
            PreparedStatement insert = conexion.prepareStatement(sql);
            insert.setString(1, v1);
            insert.setString(2, v2);
            insert.executeUpdate();
            System.out.println("Personaje registrado con éxito");
        } catch (Exception e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }
}