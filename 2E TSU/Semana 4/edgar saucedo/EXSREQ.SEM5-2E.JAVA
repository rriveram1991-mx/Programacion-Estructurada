Scanner sc = new Scanner(System.in);
       int opcion = 0;

       while (opcion !=2) {


           System.out.println("------MENU-------");
           System.out.println("1: CALCULAR PROMEDIO");
           System.out.println("2: SALIR");
           System.out.println("SELECCIONE UNA OPCION ");
           opcion = sc.nextInt();
           switch (opcion) {

               case 1:
                   System.out.print("¿Cuantas calificaciones va a ingresar?: ");
                   int cantidad = sc.nextInt();

                   double suma = 0;
                   int contadorValidas = 0;

                   for (int i = 1; i <= cantidad; i++) {
                       System.out.print("Ingrese la calificacion #" + i + ": ");
                       double calificacion = sc.nextDouble();

                       if (calificacion >= 0 && calificacion <= 100) {
                           suma += calificacion;
                           contadorValidas++;
                       } else {
                           System.out.println("Calificacion invalida. Debe estar entre 0 y 100.");
                           i--; 
                       }
                   }

                   if (contadorValidas > 0) {
                       double promedio = suma / contadorValidas;
                       System.out.println("El promedio es: " + promedio);
                   } else {
                       System.out.println("No se ingresaron calificaciones validas.");
                   }
                   break;

               case 2:
                   System.out.println("Saliendo del programa...");
                   break;

               default:
                   System.out.println("Opcion no valida.");
           }
       }

        sc.close();

           
       }

           }

