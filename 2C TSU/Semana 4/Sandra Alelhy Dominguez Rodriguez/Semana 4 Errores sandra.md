SANDRA DOMINGUEZ



**1. Error de compilación:** while (salir = false),  Debe tener 2 == para comparla. Porque con uno = no se ejecuta el While.

**2. Error de compilación:** if (nota >= 0 \&\& nota <= 10); No se puede tener  punto y coma al final de los paréntesis en el if, por qué si no no funciona .

**3. Error de compilación:** Faltaba break en case 1,  Sin el break, el código  ejecuta el código del siguiente case.

**4. Error de compilación:** También faltaba  break en case 4 .

**5. Error de compilación:** Faltan abrir y cerrar {}, la mayoría era en los if y en else.

**6. Error de compilación:** if (promedio >= 7);   No se puede usar el ; al final del paréntesis del if.

**7. Error de compilación:** while (i < cantidad);   No debe tener punto y coma al final de la línea por qué el bucle no va a funcionar.



**8. Error lógico:** for (int i = 0; i <= n; i++) - El bucle se ejecuta n+1 veces en lugar de n veces. Debería ser i < n.

**9. Error lógico:**  if (total / cantidad >= 7) está mal  el total/cantidad es la media de las notas, no es nota individual. Debería ser if (nota >= 7).

**10. Error lógico:** Lógica de aprobados/reprobados incorrecta . La lógica actual no cuenta las notas individuales.

**11. Error lógico:** case 3 no cuenta notas individuales. La lógica que tiene no es correcta.



**12. Mala práctica:** No se valida la entrada de opcion .Si la persona ingresa algo que no sea un número, el programa fallará.

**13. Mala práctica:** No se valida la entrada de n . Si la persona ingresa un número negativo o cero, el programa fallará.

**14. Mala práctica:** No se valida la entrada de nota . Si la persona ingresa un número fuera del rango 0-10, el programa fallará.

**15. Mala práctica:** Es mejor usar double por qué el int para total  puede causar un desbordamiento si la suma de las notas es muy grande.

**16. Mala práctica:** División por cero en total / cantidad .Si cantidad es cero, el código va a fallar.

**17. Mala práctica:** Uso de división entera en promedio . Si el número no es entero puede que de mal el resultado, tiene que definirse la variable como double y no como int.

**18. Mala práctica:** No se maneja InputMismatchException.Si el usuario introduce algo que no sea un número, el programa fallará.

**19. Mala práctica**: Uso de variables globales .Las variables total y cantidad deberían ser locales en cada case.

**20. Mala práctica**: Faltaba break en case 5 

**21. Mala práctica:** No se valida la cantidad > 0 en case 2 y case 3 .Si no hay notas, el código fallará.

