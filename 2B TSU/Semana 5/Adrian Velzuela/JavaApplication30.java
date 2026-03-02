/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication30;

/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication30 {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // Base de datos de movimientos del día. Positivos:depósitos. Negativos:retiros.
        double[] transacciones = {1500.50, -200.00, 5600.00, -10.25, -5200.00, 800.00, -150.00, 7000.00};
        
        double ingresos = 0;
        double egresos = 0;
        int alertasFraude = 0;

        System.out.println("reporte de auditoria");
        System.out.println("---------------------");

        // procesamiento con for-each
        for (double monto : transacciones) {
            // logica para clasificar montos
            if (monto > 0) {
                ingresos += monto;
                System.out.printf("[ingreso]  + $%.2f\n", monto);
            } else {
                egresos += Math.abs(monto); // convertimos a positivo para sumar al total de gastos
                System.out.printf("[egreso]   - $%.2f\n", Math.abs(monto));
            }

            // detección de movimientos inusuales
            if (Math.abs(monto) > 5000) {
                System.err.println("movimiento de alto riesgo detectado.");
                alertasFraude++;
            }
        }

        double balanceFinal = ingresos - egresos;

        System.out.println("\n resumen final");
        System.out.printf("total ingresado: $%.2f\n", ingresos);
        System.out.printf("total retirado:  $%.2f\n", egresos);
        System.out.printf("balance neto:    $%.2f\n", balanceFinal);
        System.out.println("alertas de seguridad: " + alertasFraude);
        
        if (balanceFinal < 0) {
            System.out.println("cuenta en números rojos.");
        } else {
            System.out.println("cuenta saludable.");
        }
    }
}