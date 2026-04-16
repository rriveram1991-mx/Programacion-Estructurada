package CRUD;
import po.conexion.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class leer {
public static void leerr(){
    Connection cmysql = Conexion.getConnection();
    try{
        Statement bs = cmysql.createStatement();
        ResultSet clCount = bs.executeQuery("SELECT COUNT(*) AS total FROM gatos");
        if(clCount.next()){
            int total = clCount.getInt("total");
            System.out.println("Total de gatos: "+total);
            System.out.println();
        }
        ResultSet bdcl = bs.executeQuery("SELECT * FROM gatos");
        System.out.println("LISTADO DE GATOS DEL SISTEMA");
        while (bdcl.next()){
            System.out.println("gato #"+bdcl.getInt("idgatos"));
            System.out.println("nombre: "+bdcl.getString("nombre"));
            System.out.println("tipo: "+bdcl.getString("tipo"));
            System.out.println();
        }
        System.out.println("---MOCHILA---");
        ResultSet rsM = bs.executeQuery("SELECT * FROM mochila");
        while(rsM.next()){
            System.out.println("Item: "+rsM.getString("nombre") + "x" + rsM.getInt("cantidad"));

        }
    }catch(Exception e){
        System.out.println("ERROR: "+e.getMessage());
    }
}
public static void main(String[] args){
    leerr();
}
}

