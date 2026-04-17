import java.sql.*;
import java.util.Scanner;

public class TestConexion {

    // --- EL MAIN: Es el corazón de la aplicación ---
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bleach_db";
        String user = "root";
        String pass = "VENOMSNAKE210";
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("¡Conexión exitosa a la Sociedad de Almas!");

            // Ciclo para que funcione como una aplicación continua
            do {
                System.out.println("\n========= MENÚ GOTEI 13 =========");
                System.out.println("1. Ver lista completa de Shinigamis");
                System.out.println("2. Buscar un Shinigami (Por ID)");
                System.out.println("3. Registrar nuevo guerrero");
                System.out.println("4. Actualizar progreso (Mochila)");
                System.out.println("0. Salir del sistema");
                System.out.print("Elige una opción: ");

                opcion = sc.nextInt();

                // El Switch para elegir qué acción tomar
                switch (opcion) {
                    case 1:
                        leerShinigamis(con);
                        break;
                    case 2:
                        buscarShinigami(con);
                        break;
                    case 3:
                        registrarShinigami(con);
                        break;
                    case 4:
                        actualizarGuerrero(con);
                        break;
                    case 5:
                        eliminarGuerrero(con);
                        break;
                    case 0:
                        System.out.println("Cerrando sesión... ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } while (opcion != 0); // El programa se repite hasta que elijas 0

            con.close(); // Cerramos la conexión al salir
        } catch (Exception e) {
            System.out.println("Error en el sistema: " + e.getMessage());
        }
    }

    // --- 1. MÉTODO PARA LEER TODOS ---
    public static void leerShinigamis(Connection con) {
        try {
            // Traemos todo de la tabla principal
            String query = "SELECT * FROM Shinigamis";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\n" + "=".repeat(100));
            System.out.printf("%-3s | %-15s | %-12s | %-12s | %-15s | %-15s\n",
                    "ID", "NOMBRE", "ZANPAKUTO", "SHIKAI", "BANKAI", "TECNICAS");
            System.out.println("-".repeat(100));

            while (rs.next()) {
                // Usamos nombres de columnas que coincidan con el ALTER TABLE de arriba
                int id = rs.getInt("id");
                String nom = rs.getString("nombre");
                String zan = (rs.getString("zanpakuto") != null) ? rs.getString("zanpakuto") : "N/A";
                String shi = (rs.getString("shikai") != null) ? rs.getString("shikai") : "N/A";
                String ban = (rs.getString("bankai") != null) ? rs.getString("bankai") : "N/A";
                String tec = (rs.getString("tecnicas") != null) ? rs.getString("tecnicas") : "N/A";

                System.out.printf("%-3d | %-15s | %-12s | %-12s | %-15s | %-15s\n",
                        id, nom, zan, shi, ban, tec);
            }
            System.out.println("=".repeat(100));
        } catch (Exception e) {
            System.out.println("❌ ERROR AL LEER: " + e.getMessage());
            e.printStackTrace(); // Esto te dirá en la consola de abajo qué línea falló
        }
    }
    // --- 2. MÉTODO NUEVO: BUSCAR SHINIGAMI ESPECÍFICO ---
    public static void buscarShinigami(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngresa el ID del Shinigami que deseas buscar: ");
        int idBuscado = sc.nextInt();

        String sql = "SELECT * FROM Shinigamis WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBuscado);
            ResultSet rs = ps.executeQuery();

            // Si encuentra un resultado, lo muestra
            if (rs.next()) {
                System.out.println("\n--- EXPEDIENTE ENCONTRADO ---");
                System.out.println("Nombre:   " + rs.getString("nombre"));
                System.out.println("División: Escuadrón " + rs.getInt("division"));
                System.out.println("Rango:    " + rs.getString("rango"));
                System.out.println("Reiatsu:  " + rs.getInt("reiatsu"));
                System.out.println("-----------------------------");
            } else {
                System.out.println("No se encontró ningún registro con el ID: " + idBuscado);
            }
        } catch (Exception e) {
            System.out.println("Error en la búsqueda: " + e.getMessage());
        }
    }

    // --- 3. MÉTODO PARA INSERTAR ---
    public static void registrarShinigami(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- REGISTRAR NUEVO GUERRERO ---");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("División (Número): ");
        int div = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        System.out.print("Rango (Capitán, Teniente, etc.): ");
        String rango = sc.nextLine();

        System.out.print("Reiatsu (Puntos): ");
        int rei = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre de Zanpakuto: ");
        String zan = sc.nextLine();

        // El SQL para insertar uno nuevo
        String sqlShinigami = "INSERT INTO Shinigamis (nombre, division, rango, reiatsu, zanpakuto) VALUES (?, ?, ?, ?, ?)";

        try {
            // Usamos RETURN_GENERATED_KEYS para saber qué ID le asignó MySQL
            PreparedStatement ps = con.prepareStatement(sqlShinigami, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setInt(2, div);
            ps.setString(3, rango);
            ps.setInt(4, rei);
            ps.setString(5, zan);

            ps.executeUpdate();

            // Obtener el ID generado para meterlo también a la mochila (Escuadron)
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int nuevoId = rs.getInt(1);
                String sqlMochila = "INSERT INTO Escuadron (id_shinigami) VALUES (?)";
                PreparedStatement psMochila = con.prepareStatement(sqlMochila);
                psMochila.setInt(1, nuevoId);
                psMochila.executeUpdate();

                System.out.println("¡" + nombre + " ha sido registrado con el ID: " + nuevoId + "!");
            }
        } catch (Exception e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }
    // --- 4. MÉTODO PARA ACTUALIZAR (MOCHILA) ---
    public static void actualizarGuerrero(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngresa el ID del guerrero a modificar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        System.out.println("¿Qué dato deseas modificar?");
        System.out.println("1. Nombre del Personaje");
        System.out.println("2. Rango/Tipo (Capitán, Arrancar, etc.)");
        System.out.println("3. Nombre de la Zanpakuto");
        System.out.println("4. Shikai");
        System.out.println("5. Bankai");
        System.out.println("6. Técnicas Especiales");
        System.out.println("7. Nivel de Reiatsu");
        System.out.print("Selecciona una opción: ");
        int opc = sc.nextInt();
        sc.nextLine();

        String columna = "";
        switch (opc) {
            case 1: columna = "nombre"; break;
            case 2: columna = "rango"; break;
            case 3: columna = "zanpakuto"; break;
            case 4: columna = "shikai"; break;
            case 5: columna = "bankai"; break;
            case 6: columna = "tecnicas"; break;
            case 7: columna = "reiatsu"; break;
            default: System.out.println("Opción no válida."); return;
        }

        System.out.print("Introduce el nuevo valor: ");
        String nuevoValor = sc.nextLine();

        // Actualizamos directamente en la tabla Shinigamis
        String sql = "UPDATE Shinigamis SET " + columna + " = ? WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoValor);
            ps.setInt(2, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("¡Datos actualizados correctamente en la Sociedad de Almas!");
            } else {
                System.out.println("No se encontró ningún guerrero con el ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    // 4. ---METODO ELIMINAR PERSONAJE---
    public static void eliminarGuerrero(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n¿Cuál es el ID del guerrero que deseas eliminar de la bolsa? ");
        int id = sc.nextInt();

        System.out.print("¿Estás seguro de eliminarlo? (si/no): ");
        String confirmar = sc.next();

        if (confirmar.equalsIgnoreCase("si")) {
            String sql = "DELETE FROM Shinigamis WHERE id = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                int filas = ps.executeUpdate();
                if (filas > 0) {
                    System.out.println("¡Guerrero eliminado de la Sociedad de Almas!");
                } else {
                    System.out.println("ID no encontrado.");
                }
            } catch (Exception e) {
                System.out.println("Error al eliminar: " + e.getMessage());
            }
        }
    }
}