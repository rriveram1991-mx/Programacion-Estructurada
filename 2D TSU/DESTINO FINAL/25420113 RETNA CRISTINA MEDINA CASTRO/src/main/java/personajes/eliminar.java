package personajes;
import miraculous.conexion.conexion;

import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Connection;

public class eliminar {



        public static void eliminar() {

            Scanner sc = new Scanner(System.in);

            System.out.print("ID del pokemon a eliminar: ");
            int id = sc.nextInt();

            Connection con = conexion.getConnection();

            try {
                String sql = "DELETE FROM personajes WHERE id = ?";
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setInt(1, id );

                int filas = pst.executeUpdate();

                if (filas > 0) {
                    System.out.println("personaje eliminado");
                } else {
                    System.out.println("No se encontró el ID");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

