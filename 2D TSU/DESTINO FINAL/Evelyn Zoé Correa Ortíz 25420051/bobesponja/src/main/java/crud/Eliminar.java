package crud;
import java.sql.Connection;
import crud.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Eliminar {
    public static void Eliminar(int pi){
        try {
            Connection con = Conexion.getConnection();
            Statement cnl = con.createStatement();
            ResultSet stl = cnl.executeQuery("SELECT COUNT(*) AS total FROM personajess");
            if (stl.next()) {
                System.out.println("TOTAL DE KANGREBURGERS ANTES DE ELMINIMAR" + stl.getInt("total"));

            }
            String sql = "DELETE FROM kangreburgers WHERE idkangreburgers=?";
            PreparedStatement del = con.prepareStatement(sql);
            del.setInt(1, pi);
            del.executeUpdate();
            System.out.println("EL PERSONAJE HA SIDO ELIMINADA CON EXITO");
            ResultSet stl2 = cnl.executeQuery("SELECT COUNT(*) AS total FROM kangreburgers");
            if (stl2.next()) {
                System.out.println("TOTAL DE PERSONAJES DESPUES DE ELIMINAR:" + stl2.getInt("total"));
            }
        }
        catch (Exception e){
            System.out.println("ERROR AL ELIMINAR" + e);

            }
        }

        public static void main() {
            int a = 1;
            Eliminar(a);
        }
    }

