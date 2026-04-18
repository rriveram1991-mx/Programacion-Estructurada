package CRUD;

import gimnasio.conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DeleteCliente {
    public static void DeleteCliente() {
        try{
            Connection conx= conexion.getConection();
            Statement st =conx.createStatement();
            ResultSet rs= st.executeQuery("SELECT COUNT(*) AS total FROM personas");
            if (rs.next()){
                System.out.println("Clientes antes de eliminar"+rs.getInt("total"));
                System.out.println();
            }

            String sql="DELETE FROM personas WHERE idpersonas = ?";
            PreparedStatement ps= conx.prepareStatement(sql);
            ps.setInt(1, 3);
            ps.executeUpdate();
            System.out.println("Cliente eliminado");
            System.out.println();
            ResultSet rs2= st.executeQuery("SELECT COUNT(*) as total FROM personas ");
            if (rs2.next()){
                System.out.println();
                System.out.println("Clientes actuales despues de eliminar:"+ rs2.getInt("total"));
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){

        DeleteCliente();
    }
}
