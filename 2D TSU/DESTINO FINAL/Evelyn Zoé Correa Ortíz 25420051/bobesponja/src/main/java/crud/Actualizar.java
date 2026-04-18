package crud;
import java.sql.Connection;
import crud.Conexion;
import java.sql.PreparedStatement;
public class Actualizar {
    public static void Actualizar (int id, String nom, String color) {
        try {
            Connection con = Conexion.getConnection();
            String sql = "UPDATE personajes SET nombre=? , color=? WHERE idpersonaje=?";
            PreparedStatement update = con.prepareStatement(sql);
            update.setString(1, nom);
            update.setString(2, color);
            update.setInt(3, id);
            update.executeUpdate();
            System.out.println("PERSONAJE ACTUALIZADO CORRECTAMENTE");
            System.out.println();
            update.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar");
        }
    }
}