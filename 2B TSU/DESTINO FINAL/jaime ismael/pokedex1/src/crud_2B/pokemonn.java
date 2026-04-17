package crud_2B;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class pokemonn {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int seleccionUsuario = 0;

        System.out.println("=== SISTEMA DE GESTIÓN POKÉMON INICIADO ===");

        do {
            System.out.println("\n----------- PANEL DE CONTROL -----------");
            System.out.println("1. Pokédex");
            System.out.println("2. inventario");
            System.out.println("3. Registrar captura");
            System.out.println("4. Modificar registro");
            System.out.println("5. Consumir objeto");
            System.out.println("6. Finalizar y desconectar");
            System.out.print("Seleccione una operación: ");

            try {
                // Lectura robusta para evitar errores de buffer
                seleccionUsuario = Integer.parseInt(inputScanner.nextLine());
                Connection dbConnection = conexion.getConnection();

                switch (seleccionUsuario) {
                    case 1:
                        // --- OPERACIÓN: READ (POKÉMON) ---
                        System.out.println("\n>> REPORTE DE EJEMPLARES EN POKÉDEX:");
                        Statement stmtListar = dbConnection.createStatement();
                        ResultSet rsLista = stmtListar.executeQuery("SELECT * FROM pokemones");

                        while (rsLista.next()) {
                            System.out.printf("Ref: %d | Especie: %s | Elemento: %s | Lv: %d%n",
                                    rsLista.getInt("id_pokemon"),
                                    rsLista.getString("nombre"),
                                    rsLista.getString("tipo"),
                                    rsLista.getInt("nivel"));
                        }
                        stmtListar.close();
                        break;

                    case 2:
                        // --- OPERACIÓN: READ (MOCHILA) ---
                        System.out.println("\n>> INVENTARIO ACTUAL:");
                        Statement stmtMochila = dbConnection.createStatement();
                        ResultSet rsInv = stmtMochila.executeQuery("SELECT * FROM mochila");

                        while (rsInv.next()) {
                            System.out.println("Cód. Item: " + rsInv.getInt("id_item") +
                                    " | Artículo: " + rsInv.getString("nombre_item") +
                                    " | Stock: " + rsInv.getInt("cantidad"));
                        }
                        stmtMochila.close();
                        break;

                    case 3:
                        // --- OPERACIÓN: CREATE ---
                        System.out.println("\n>> CAPTURA:");
                        System.out.print("Identificador/Nombre: ");
                        String nomEspecie = inputScanner.nextLine();
                        System.out.print("Categoría elemental: ");
                        String catTipo = inputScanner.nextLine();
                        System.out.print("Rango de Nivel: ");
                        int valNivel = Integer.parseInt(inputScanner.nextLine());
                        System.out.print("Capacidad de Salud (PS): ");
                        int valPs = Integer.parseInt(inputScanner.nextLine());

                        String queryAdd = "INSERT INTO pokemones (nombre, tipo, nivel, ps_maximos) VALUES (?, ?, ?, ?)";
                        PreparedStatement pstmtAdd = dbConnection.prepareStatement(queryAdd);
                        pstmtAdd.setString(1, nomEspecie);
                        pstmtAdd.setString(2, catTipo);
                        pstmtAdd.setInt(3, valNivel);
                        pstmtAdd.setInt(4, valPs);

                        pstmtAdd.executeUpdate();
                        System.out.println("Registro completado: " + nomEspecie + " se añadió a la base de datos.");
                        pstmtAdd.close();
                        break;

                    case 4:
                        // --- OPERACIÓN: UPDATE MANUAL ---
                        System.out.println("\n>> ACTUALIZACIÓN DE DATOS:");
                        System.out.print("Ingrese ID del registro a modificar: ");
                        int idRef = Integer.parseInt(inputScanner.nextLine());

                        System.out.print("Nuevo nombre de etiqueta: ");
                        String upNombre = inputScanner.nextLine();
                        System.out.print("Nuevo nivel de combate: ");
                        int upNivel = Integer.parseInt(inputScanner.nextLine());

                        String queryUpdate = "UPDATE pokemones SET nombre = ?, nivel = ? WHERE id_pokemon = ?";
                        PreparedStatement pstmtUp = dbConnection.prepareStatement(queryUpdate);
                        pstmtUp.setString(1, upNombre);
                        pstmtUp.setInt(2, upNivel);
                        pstmtUp.setInt(3, idRef);

                        if (pstmtUp.executeUpdate() > 0) {
                            System.out.println("Sincronización exitosa.");
                        } else {
                            System.err.println("Error: No se localizó el ID especificado.");
                        }
                        pstmtUp.close();
                        break;

                    case 5:
                        // --- OPERACIÓN: UPDATE AUTOMÁTICO ---
                        System.out.println("\n>> USO DE SUMINISTROS:");
                        System.out.print("ID del artículo a reducir: ");
                        int codArticulo = Integer.parseInt(inputScanner.nextLine());

                        String queryStock = "UPDATE mochila SET cantidad = cantidad - 1 WHERE id_item = ? AND cantidad > 0";
                        PreparedStatement pstmtStock = dbConnection.prepareStatement(queryStock);
                        pstmtStock.setInt(1, codArticulo);

                        if (pstmtStock.executeUpdate() > 0) {
                            System.out.println("Inventario actualizado (-1 unidad).");
                        } else {
                            System.err.println("Operación fallida: Stock insuficiente o ID erróneo.");
                        }
                        pstmtStock.close();
                        break;

                    case 6:
                        System.out.println("Cerrando sesión... Datos volcados correctamente.");
                        break;

                    default:
                        System.out.println("Comando desconocido.");
                }

                if (dbConnection != null) dbConnection.close();

            } catch (NumberFormatException e) {
                System.out.println("Error de entrada: Se requiere un valor numérico.");
            } catch (Exception e) {
                System.out.println("Incidencia en el sistema: " + e.getMessage());
            }

        } while (seleccionUsuario != 6);

        inputScanner.close();
    }
}