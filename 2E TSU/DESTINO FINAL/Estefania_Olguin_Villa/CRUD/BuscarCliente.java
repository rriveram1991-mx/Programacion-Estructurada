package CRUD;
import gimnasio.conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BuscarCliente {
    public static void BuscarCliente(){
        Connection conx= conexion.getConection();
        try{
            Statement st =conexion.getConection().createStatement();
            ResultSet clCount = st.executeQuery("SELECT COUNT(*) as total  FROM personas");
            if (clCount.next()){
                int total= clCount.getInt("total");
                System.out.println("Total de clientes: "+ total);
                System.out.println();
            }
            ResultSet info = st.executeQuery("SELECT * FROM personas");
            System.out.println("INFORMACION DE NUESTROS CLIENTES");
            System.out.println();
            while(info.next()){
                System.out.println("ID cliente:"+info.getInt("idpersonas"));
                System.out.println("Nombre del cliente: "+info.getString("nombre"));
                System.out.println("Tipo de Membresía:"+info.getString("membresia"));
                System.out.println();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        BuscarCliente();
    }
    }

