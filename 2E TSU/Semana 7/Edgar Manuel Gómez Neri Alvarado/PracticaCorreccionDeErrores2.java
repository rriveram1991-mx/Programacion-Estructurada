import java.util.Scanner;
/*
1.(Ejecución)
Línea aprox: 30 (i <= juegos.length)
Explicación: Solo llega hasta el índice 9. El if dentro del ciclo sobrescribirá la variable fila hasta la última posición vacía

2.(Error Lógico/Entrada)
Línea aproximada: 25 (sc.nextInt()) y 37 (sc.nextLine())
Explicación: Se salta el

3.(Error Lógico)
Línea aprox: 61 (juegos[i][0] == buscar)
Explicación: Se compara string con == en lugas de .equals()

4.(Error de Ejecución)
Líneas aprox: 52 (Mostrar), 61 (Buscar) y 70 (Estadísticas).
Explicación: Si el arreglo no está lleno (tienes 2 juegos de 10 posibles), el código intentará leer juegos[i][0] en una fila vacía. Al intentar hacer .equals() o Integer.parseInt() sobre null, el programa explotará.

5.(Error de Ejecución)
Línea aprox: 70 (Integer.parseInt)
Explicación: Si en "Horas" el usuario escribe algo que no sea un número (o si la fila está vacía), parseInt fallará.

6.(Error Lógico)
Línea aproximada: 73 (suma / juegos.length)
Explicación: Se dividide el total entre 10 (el tamaño total), no entre la cantidad de juegos reales. Si solo tienes 1 juego, el promedio será erróneo.

7.(Error Lógico)
Línea aproximada: 30 a 33 (Ciclo de registro)
Explicación:  Recorre todo el arreglo buscando espacios vacíos. Si el arreglo está vacío, fila terminará valiendo 9 (la última posición). El programa guardará el primer juego en la última fila, dejando las primeras 9 vacías.

8.(Error de Ejecución)
Línea aproximada: 36 en adelante (Asignación de datos)
Explicación: Si ya registraste 10 juegos y el arreglo está lleno, el ciclo for terminará sin asignar un nuevo valor a fila. Si no se inicializa fila con un valor de control (como -1), el programa intentará escribir en una posición que quizás no es la correcta.

9.(Error Lógico)
Línea aproximada: 61 (juegos[i][0] == buscar)
Explicación: Si el usuario busca un nombre y el arreglo sigue con filas vacías, al llegar a una fila donde juegos[i][0] sea null, el programa lanzará un error al intentar compararlo.


Codigo Correjido.
*/
public class PracticaCorreccionDeErrores2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("5. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    int fila = 0;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break;
                        }
                        System.out.println(i);
                    }

                    
                    System.out.print("Nombre: ");

                    juegos[fila][0] = sc.next();

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.next();

                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.next();

                    break;

                case 2:
                    for (int i = 0; i < juegos.length; i++) {
                        System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                    }
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.next();

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0].equals(buscar)) {
                            System.out.println("Coincidencia en el slot "+i);
                        }
                    }
                    break;
                    

                case 4:
                    int suma = 0,JuegosC = 0;
                    
                    for (int i = 0; i  < juegos.length; i++) {
                        if (juegos[i][0] != null && juegos[i][2] != null) {
                    JuegosC++;
                    try {
                    suma = Integer.parseInt(juegos[i][2]); 
                    } catch (Exception e) {
                        System.out.println("Error. Hay datos no numericos.");
                    }
                    
                    }}
                    if (JuegosC > 0) {
                        double promedio = (double) suma / JuegosC;
                        System.out.println("Promedio: " + promedio);
                    } else {
                        System.out.println("No hay juegos registrados para calcular el promedio.");
                    }
                    break;   
            }
        }
    }
}
