public class Cine {
    public static void main(String[] args) {
        // Matriz de 5 filas x 6 columnas
        char[][] asientos = new char[5][6];

        // Llenar asientos como Libres
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                asientos[i][j] = 'L';
            }
        }

        // Simular una reserva
        asientos[0][0] = 'X'; 
        asientos[2][3] = 'X';

        System.out.println("Mapa de Asientos (L=Libre, X=Ocupado):");
        for (char[] fila : asientos) {
            for (char asiento : fila) {
                System.out.print("[" + asiento + "] ");
            }
            System.out.println();
        }
    }
}
