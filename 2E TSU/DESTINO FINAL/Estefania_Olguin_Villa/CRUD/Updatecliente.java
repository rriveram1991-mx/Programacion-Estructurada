package CRUD;
import gimnasio.conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class UpdateCliente {
    public static void UpdateCliente() {
    try{
        Connection conx = conexion.getConection();
        String sql = "UPDATE personas SET nombre=?, membresía=? WHERE idpersonas=?";
        PreparedStatement ps= conx.prepareStatement(sql);
        ps.setString(1, "fanny");
        ps.setString(2, "PLUS");
        ps.setInt(3, 1);
        ps.executeUpdate();
        System.out.println("Cliente actualizado");
        System.out.println( );
    }catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        UpdateCliente();
        BuscarCliente.BuscarCliente();
    }
}
