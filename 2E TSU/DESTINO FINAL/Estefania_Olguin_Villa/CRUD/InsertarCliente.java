package CRUD;

import gimnasio.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertarCliente {
    public static void main(String[] args){
        Connection cnx = conexion.getConection();
        try{
            String sql= "INSERT INTO personas (nombre, membresia) VALUES (?,?)";
            PreparedStatement insert =cnx.prepareStatement(sql);
            insert.setString(1, "fanny");
            insert.setString(2, "PLUS");
            insert.executeUpdate();
            System.out.println("Cliente insertado correctamente al sistema");
            insert.setString(1, "omar");
            insert.setString(2, "NORMAL");
            insert.executeUpdate();
            System.out.println("Cliente insertado correctamente al sistema");
            insert.setString(1, "victoria");
            insert.setString(2, "NORMAL");
            insert.executeUpdate();
            System.out.println("Cliente insertado correctamente al sistema");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
