package CRUD;
import po.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class registrar {
    public static void registrarse(){
        Connection cmysql =  Conexion.getConnection();
        try{
            String sql = "INSERT INTO gatos(nombre,tipo,ataque,vida,saludact) VALUES(?,?,?,?,?)";
            PreparedStatement insert = cmysql.prepareStatement(sql);
            insert.setString(1, "minimi");
            insert.setString(2, "Fuego");
            insert.setInt(3, 55);
            insert.setInt(4, 100);
            insert.setInt(5, 100);
            insert.executeUpdate();
            System.out.println("REGISTRADO");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
public static void main(String [] args){
    registrarse();
}
}
