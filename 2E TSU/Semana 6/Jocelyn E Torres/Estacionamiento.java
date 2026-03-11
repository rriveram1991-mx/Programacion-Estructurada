public class Estacionamiento {
    public static void main(String[] args) {
        // Estacionamiento de 3 niveles y 10 cajones por nivel
        boolean[][] cajones = new boolean[3][10];

        // Ocupar algunos lugares aleatoriamente
        cajones[0][5] = true;
        cajones[1][2] = true;
        cajones[2][9] = true;

        System.out.println("\nEstado del Estacionamiento (Ocupado: true, Vacio: false):");
        for (int i = 0; i < cajones.length; i++) {
            System.out.print("Nivel " + i + ": ");
            for (int j = 0; j < cajones[i].length; j++) {
                System.out.print(cajones[i][j] + " ");
            }
            System.out.println();
        }
    }
}