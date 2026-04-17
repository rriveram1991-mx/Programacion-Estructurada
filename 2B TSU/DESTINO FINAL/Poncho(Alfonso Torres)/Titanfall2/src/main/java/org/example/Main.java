package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                Scanner scann = new Scanner(System.in);
                titandao titandao = new titandao();
                mochilao mochilao = new mochilao();

                int opcion;

                do {
                    System.out.println("1. Mostrar titanes");
                    System.out.println("2. Insertar titan");
                    System.out.println("3. Actualizar titan");
                    System.out.println("4. Eliminar titan");
                    System.out.println("5. Mostrar bag");
                    System.out.println("6. Insertar objeto en bag");
                    System.out.println("7. Actualizar objeto de bag");
                    System.out.println("8. Eliminar objeto de bag");
                    System.out.println("9. Salir");
                    System.out.print("Elige una opcion: ");
                    opcion = scann.nextInt();
                    scann.nextLine();

                    switch (opcion) {

                        case 1:
                            titandao.mostrarTitanes();
                            break;

                        case 2:
                            System.out.print("Nombre del titan: ");
                            String nombreTitan = scann.nextLine();

                            System.out.print("Clase del titan: ");
                            String claseTitan = scann.nextLine();

                            System.out.print("Vida del titan: ");
                            int vidaTitan = scann.nextInt();

                            System.out.print("Damage del titan: ");
                            int damageTitan = scann.nextInt();
                            scann.nextLine();

                            System.out.print("Descripcion del titan: ");
                            String descripcionTitan = scann.nextLine();

                            titandao.insertarTitan(nombreTitan, claseTitan, vidaTitan, damageTitan, descripcionTitan);
                            break;

                        case 3:
                            System.out.print("ID del titan a actualizar: ");
                            int idTitanAct = scann.nextInt();
                            scann.nextLine();

                            System.out.print("Nuevo nombre: ");
                            String nuevoNombreTitan = scann.nextLine();

                            System.out.print("Nueva clase: ");
                            String nuevaClaseTitan = scann.nextLine();

                            System.out.print("Nueva vida: ");
                            int nuevaVidaTitan = scann.nextInt();

                            System.out.print("Nuevo damage: ");
                            int nuevoDamageTitan = scann.nextInt();
                            scann.nextLine();

                            System.out.print("Nueva descripcion: ");
                            String nuevaDescripcionTitan = scann.nextLine();

                            titandao.actualizarTitan(
                                    idTitanAct,
                                    nuevoNombreTitan,
                                    nuevaClaseTitan,
                                    nuevaVidaTitan,
                                    nuevoDamageTitan,
                                    nuevaDescripcionTitan
                            );
                            break;

                        case 4:
                            System.out.print("ID del titan a eliminar: ");
                            int idTitanEliminar = scann.nextInt();
                            scann.nextLine();

                            titandao.eliminarTitan(idTitanEliminar);
                            break;

                        case 5:
                            mochilao.seebag();
                            break;

                        case 6:
                            System.out.print("Nombre del objeto: ");
                            String nombreObj = scann.nextLine();

                            System.out.print("Tipo del objeto: ");
                            String tipoObj = scann.nextLine();

                            System.out.print("Cantidad: ");
                            int cantidadObj = scann.nextInt();
                            scann.nextLine();

                            System.out.print("Descripcion del objeto: ");
                            String descripcionObj = scann.nextLine();

                            mochilao.obj(nombreObj, tipoObj, cantidadObj, descripcionObj);
                            break;

                        case 7:
                            System.out.print("ID del objeto a actualizar: ");
                            int idObjAct = scann.nextInt();
                            scann.nextLine();

                            System.out.print("Nuevo nombre: ");
                            String nuevoNombreObj = scann.nextLine();

                            System.out.print("Nuevo tipo: ");
                            String nuevoTipoObj = scann.nextLine();

                            System.out.print("Nueva cantidad: ");
                            int nuevaCantidadObj = scann.nextInt();
                            scann.nextLine();

                            System.out.print("Nueva descripcion: ");
                            String nuevaDescripcionObj = scann.nextLine();

                            mochilao.actualizarObjeto(
                                    idObjAct,
                                    nuevoNombreObj,
                                    nuevoTipoObj,
                                    nuevaCantidadObj,
                                    nuevaDescripcionObj
                            );
                            break;

                        case 8:
                            System.out.print("ID del objeto a eliminar: ");
                            int idObjEliminar = scann.nextInt();
                            scann.nextLine();

                            mochilao.eliminarObjeto(idObjEliminar);
                            break;

                        case 9:
                            System.out.println("Saliendo del sistema...");
                            break;

                        default:
                            System.out.println("Opcion no valida.");
                            break;
                    }

                } while (opcion != 9);

                scann.close();
            }
        }