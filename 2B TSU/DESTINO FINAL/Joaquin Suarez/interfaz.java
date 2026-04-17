package crud_2B;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class interfaz {
    public static void main(String[] args) {
        // Nombre del scanner cambiado a 'opcion' según tu pedido
        Scanner opcion = new Scanner(System.in);
        int seleccion = 0;

        do {
            System.out.println("1. registar Pokémon (CREATE)");
            System.out.println("2. Pokédex (READ)");
            System.out.println("3. mochila (READ)");
            System.out.println("4. Usar un Objeto (UPDATE)");
            System.out.println("5. Guardar y Salir");
            System.out.print("Selecciona: ");

            try {
                seleccion = Integer.parseInt(opcion.nextLine());
                Connection cnx = conexion.getConnection();

                switch (seleccion) {
                    case 1:
                        System.out.println("\n--- ATRAPAR POKÉMON ---");
                        System.out.print("Nombre: ");
                        String nombre = opcion.nextLine();
                        System.out.print("Tipo: ");
                        String tipo = opcion.nextLine();
                        System.out.print("Nivel: ");
                        int nivel = Integer.parseInt(opcion.nextLine());
                        System.out.print("naturaleza: ");
                        String naturaleza = opcion.nextLine();
                        System.out.print("PS: ");
                        int ps = Integer.parseInt(opcion.nextLine());

                        String sqlInsert = "INSERT INTO pokemons (nombre, tipo, nivel, ps_maximos) VALUES (?, ?, ?, ?)";
                        PreparedStatement psInsert = cnx.prepareStatement(sqlInsert);
                        psInsert.setString(1, nombre);
                        psInsert.setString(2, tipo);
                        psInsert.setInt(3, nivel);
                        psInsert.setInt(4, ps);
                        psInsert.executeUpdate();

                        System.out.println("¡" + nombre + " guardado!");
                        psInsert.close();
                        break;

                    case 2:
                        System.out.println("\n--- TU POKÉDEX ---");
                        Statement stPokedex = cnx.createStatement();
                        // Consulta a 'pokemons'
                        ResultSet rsPokedex = stPokedex.executeQuery("SELECT * FROM pokemons");

                        while (rsPokedex.next()) {
                            System.out.println("ID: " + rsPokedex.getInt("id_pokemon") +
                                    " | Nombre: " + rsPokedex.getString("nombre") +
                                    " | Tipo: " + rsPokedex.getString("tipo") +
                                    " | Nivel: " + rsPokedex.getInt("nivel"));
                        }
                        stPokedex.close();
                        break;

                    case 3:
                        System.out.println("\n--- TU MOCHILA ---");
                        Statement stMochila = cnx.createStatement();
                        ResultSet rsMochila = stMochila.executeQuery("SELECT * FROM mochila");

                        while (rsMochila.next()) {
                            System.out.println("ID Item: " + rsMochila.getInt("id_item") +
                                    " | Objeto: " + rsMochila.getString("nombre_item") +
                                    " | Cantidad: " + rsMochila.getInt("cantidad"));
                        }
                        stMochila.close();
                        break;

                    case 4:
                        System.out.println("\n--- USAR OBJETO ---");
                        System.out.print("ID del objeto: ");
                        int idItem = Integer.parseInt(opcion.nextLine());

                        // Validación del Mapa (ID 4 en el SQL proporcionado)
                        if (idItem == 4) {
                            System.out.println("¡Error! El Mapa no se puede gastar.");
                        } else {
                            String sqlUpdate = "UPDATE mochila SET cantidad = cantidad - 1 WHERE id_item = ? AND cantidad > 0";
                            PreparedStatement psUpdate = cnx.prepareStatement(sqlUpdate);
                            psUpdate.setInt(1, idItem);

                            int filas = psUpdate.executeUpdate();
                            if (filas > 0) System.out.println("Objeto usado con éxito.");
                            else System.out.println("No tienes unidades o el ID es incorrecto.");
                            psUpdate.close();
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;
                }
                if (cnx != null) cnx.close();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (seleccion != 5);
        opcion.close();
    }
}