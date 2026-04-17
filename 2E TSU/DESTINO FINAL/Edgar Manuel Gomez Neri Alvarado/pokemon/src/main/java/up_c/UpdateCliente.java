package up_c;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pokemoninv.conexion;

public class UpdateCliente {
    public static void UpdateCliente() {
        Connection conx = pokemoninv.conexion.getConnection();
        try {
            // 1. Creamos el Statement correctamente
            Statement st = conx.createStatement();
            // 2. Ejecutamos la consulta
            ResultSet clCount = st.executeQuery("SELECT COUNT(*) as total FROM miembros");
            // 3. Procesamos el resultado
            if (clCount.next()) {
                int total = clCount.getInt("total");
                System.out.println("Total de miembros en el gym: " + total);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }
}