package mb;
import java.util.Scanner;
public class Mb {
    public static void main(String[] args) {
        Scanner mika = new Scanner (System.in);
        String [][] AS = new String[7][3];
        String OP,EDA;
        int SM=0,PDB=0,L=0,DA=0;
        boolean WL=true;
        double P=0;
        int[] RA = new int[7];
        System.out.println("MIND BALANCE :)");
        while(WL){
        System.out.print("""
                           ----------------------------------------------------------------
                           MENU...
                           1. Registrar estado de animo diario.
                           2. Registrar actividad saludable.
                           3. Mostrar un resumen de su bienestar.
                           4. Dar recomendaciones.
                           5. Salir.
                           ----------------------------------------------------------------
                           """);
        OP = mika.next();
        switch (OP){
            case "1":
               if (L < 7) {
                    System.out.print("""
                                      ---     REGISTRAR ESTADO DE ANIMO      ---
                                      ------------------------------------------
                                      1 - Muy mal.
                                      2 - Mal.
                                      3 - Neutral.
                                      4 - Bien.
                                      5 - Muy bien.
                                      ------------------------------------------
                                      """.formatted(L + 1));
                    EDA = mika.next();
                    if (EDA.equals("1") || EDA.equals("2") || EDA.equals("3") || EDA.equals("4") || EDA.equals("5")) {
                        int VA = Integer.parseInt(EDA);
                        RA[L] = VA;
                        switch (VA) {
                            case 1 -> PDB -= 2;
                            case 2 -> PDB -= 1;
                            case 4 -> PDB += 1;
                            case 5 -> PDB += 2;
                            default -> {
                            }
                        }
L++; 
                        System.out.println("Registrado!");
                    } else {
                        System.out.println("Elija una opcion valida (1-5).");
                    }
                } else {
                    System.out.println("Ya se ha registrado los 7 dias de la semana.");
                }
                break;
            case "2":          
    if (DA < 7) {
        System.out.println("--- REGISTRAR ACTIVIDADES DEL DIA " + (DA + 1) + " ---");
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese la actividad saludable: ");
            AS[DA][i] = mika.next(); 
        }
        System.out.println("Actividades guardadas!");
        DA++; 
    } else {
        System.out.println("Ya has completado el registro de los 7 días.");
    }
    break;
            case "3":
                System.out.println("--- RESUMEN ---");  
            if (L > 0) {
                        double S = 0;
                        for (int i = 0; i < L; i++) {
                            S += RA[i];
                        }
                         P = S / L;
                        int TTDA = 0;
                        for (String[] F : AS) {
                            for (String act : F) {
                                if (act != null) {
                                    TTDA++;
                                }
                            }
                        }
                        System.out.println("Promedio de animo: " + P);
                        System.out.println("Actividades saludables: " + TTDA);
                        System.out.print("Estado de Bienestar: ");
                        if (P < 3){
                            System.out.println("BAJO");
                        }else if (P < 4.5){
                            System.out.println("MEDIO");
                        }else{
                            System.out.println("ALTO");
                        }
                    } else {
                        System.out.println("No hay datos suficientes.");
                    }
            break;
            case "4":
                if (P < 3){
                   System.out.println("RECOMENDACION: Ejercicio y meditacion pueden ayudar!");
                }else if (P < 4.5){
                System.out.println("RECOMENDACION: Haga ejercicio minimo una vez por semana!");
                }else{
                System.out.println("Felicitaciones! Usted esta saludable, siga asi!");
                        }
                break;
            case "5":
                WL=false;
                System.out.println("Hasta luego!");
                break;
            default: System.out.println("Ingrese una opcion correcta.");
            break;
        }
            }
        }
    }
    

