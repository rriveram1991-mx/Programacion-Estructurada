package CRUD;
import po.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class borrar {
    public static void eliminar(int id){
     Connection c =  Conexion.getConnection();
     try {
         Statement st = c.createStatement();
         ResultSet rs = st.executeQuery("SELECT COUNT(*) as total FROM gatos");
         if (rs.next()) {
             System.out.println("Gatos antes de eliminar: " + rs.getInt("total"));
         }
         String sql = "DELETE FROM gatos WHERE idgatos = ?";
         PreparedStatement ps = c.prepareStatement(sql);
         ps.setInt(1, id);
         int FA = ps.executeUpdate();
         if (FA > 0) {
             System.out.println("Gato eliminado con exito");
         } else {
             System.out.println("No se ha encontrado ese gato registrado");
         }
         ResultSet rs2 = st.executeQuery("SELECT COUNT(*) as total FROM gatos");
         if (rs2.next()) {
             System.out.println("Gatos despues de eliminar: " + rs2.getInt("total"));
         }
         ps.close();
         c.close();
     } catch (Exception e) {
         System.out.println("ERROR AL ELIMINAR: " + e.getMessage());
     }

    }
    public static void main(String[] args) {
        eliminar(1);
    }
}
