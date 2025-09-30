import model.*;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Planificador planificador = new Planificador();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar una tarea");
            System.out.println("2. Modificar tarea");
            System.out.println("3. Listar tareas");
            System.out.println("4. Completar tarea");
            System.out.println("5. Listar completas");
            System.out.println("6. Listar incompletas");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1. Tarea de trabajo");
                    System.out.println("2. Tarea de ocio");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Fecha (dd/MM/yyyy): ");
                    String fechaStr = sc.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = null;
                    try {
                        fecha = sdf.parse(fechaStr);
                    } catch (ParseException e) {
                        System.out.println("Formato de fecha incorrecto, se usará la fecha actual.");
                        fecha = new Date();
                    }

                    System.out.print("Prioridad (BAJA/MEDIA/ALTA): ");
                    Prioridad prioridad = Prioridad.valueOf(sc.nextLine().toUpperCase());

                    Tarea nueva = null;
                    if (tipo == 1) {
                        System.out.print("Descripción del proyecto: ");
                        Proyecto proyecto = new Proyecto(sc.nextLine());
                        nueva = new TareaTrabajo(titulo, descripcion, fecha, prioridad, proyecto);
                    } else if (tipo == 2) {
                        System.out.print("Ubicación: ");
                        String ubicacion = sc.nextLine();
                        System.out.print("Presupuesto: ");
                        double presupuesto = sc.nextDouble();
                        sc.nextLine();
                        nueva = new TareaOcio(titulo, descripcion, fecha, prioridad, ubicacion, presupuesto);
                    }

                    System.out.print("¿Es subtarea de otra? (s/n): ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("s")) {
                        System.out.print("ID de la tarea padre: ");
                        int idPadre = sc.nextInt();
                        sc.nextLine();
                        Tarea padre = planificador.buscarPorId(idPadre);
                        if (padre != null) {
                            padre.agregarSubtarea(nueva);
                        } else {
                            System.out.println("No existe el padre, se añade como independiente.");
                            planificador.agregarTarea(nueva);
                        }
                    } else {
                        planificador.agregarTarea(nueva);
                    }
                    break;

                case 2:
                    System.out.print("ID de la tarea a modificar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Tarea t = planificador.buscarPorId(id);
                    if (t != null) {
                        System.out.println("1. Modificar título");
                        System.out.println("2. Modificar descripción");
                        System.out.println("3. Modificar fecha");
                        System.out.println("4. Modificar prioridad");
                        int mod = sc.nextInt();
                        sc.nextLine();

                        switch (mod) {
                            case 1 :
                                System.out.print("Nuevo título: ");
                                t.setTitulo(sc.nextLine());
                                break;
                            case 2 :
                                System.out.print("Nueva descripción: ");
                                t.setDescripcion(sc.nextLine());
                                break;
                            case 3 :
                                System.out.print("Nueva fecha (dd/MM/yyyy): ");
                                String nuevaFechaStr = sc.nextLine();
                                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                                try {
                                    Date nuevaFecha = sdf2.parse(nuevaFechaStr);
                                    t.setFecha(nuevaFecha);
                                } catch (ParseException e) {
                                    System.out.println("Formato incorrecto, no se modificó la fecha.");
                                }
                                break;
                            case 4 :
                                System.out.print("Nueva prioridad (BAJA/MEDIA/ALTA): ");
                                t.setPrioridad(Prioridad.valueOf(sc.nextLine().toUpperCase()));
                                break;
                        }
                    } else {
                        System.out.println("No encontrada.");
                    }
                    break;

                case 3 :
                    planificador.listarTareas();
                    break;
                case 4 :
                    System.out.print("ID de la tarea a completar: ");
                    planificador.completarTarea(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5 :
                    planificador.listarCompletas();
                    break;
                case 6 :
                    planificador.listarIncompletas();
                    break;
                case 7 :
                    System.out.println("Saliendo...");
                    break;
                default : System.out.println("Opción inválida");
            }
        } while (opcion != 7);
    }
}
