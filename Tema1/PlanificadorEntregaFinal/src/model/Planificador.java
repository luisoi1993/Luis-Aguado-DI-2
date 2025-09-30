package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Planificador {
    private ArrayList<ElementoPlanificador> elementos;
    private Scanner entrada = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Planificador() {
        elementos = new ArrayList<>();
    }

    public void menu() throws ParseException {
        int opcion;
        do {
            System.out.println("===== MENU PLANIFICADOR =====");
            System.out.println("1. Registrar tarea");
            System.out.println("2. Registrar lista");
            System.out.println("3. Modificar tarea");
            System.out.println("4. Listar elementos");
            System.out.println("5. Completar tarea/lista");
            System.out.println("6. Listar completas");
            System.out.println("7. Listar incompletas");
            System.out.println("8. Asignar persona a tarea");
            System.out.println("9. Asignar encargo a tarea");
            System.out.println("10. Asignar encargado principal a tarea");
            System.out.println("11. Cambiar encargado principal de tarea");
            System.out.println("12. Mostrar encargado principal de tarea");
            System.out.println("13. Asignar responsable a tarea");
            System.out.println("14. Agregar encargo a tarea");
            System.out.println("0. Salir");
            opcion = entrada.nextInt(); entrada.nextLine();

            switch (opcion) {
                case 1:
                    registrarTarea();
                    break;
                case 2:
                    registrarLista();
                    break;
                case 3:
                    modificarTarea();
                    break;
                case 4:
                    listarElementos();
                    break;
                case 5:
                    completarElemento();
                    break;
                case 6:
                    listarCompletas();
                    break;
                case 7:
                    listarIncompletas();
                    break;
                case 8:
                    asignarPersona();
                    break;
                case 9:
                    asignarEncargo();
                    break;
                case 10:
                    asignarEncargadoPrincipal();
                    break;
                case 11:
                    cambiarEncargadoPrincipal();
                    break;
                case 12:
                    mostrarEncargadoPrincipal();
                    break;

                case 13:
                    System.out.print("ID de la tarea: ");
                    int idTareaDetalle = entrada.nextInt();
                    this.mostrarDetalleTarea(idTareaDetalle);
                    break;

                case 14:
                    System.out.print("ID de la tarea: ");
                    int idTareaEncargo = entrada.nextInt();
                    System.out.print("ID del encargo: ");
                    int idEncargo = entrada.nextInt();
                    this.completarEncargoEnTarea(idTareaEncargo, idEncargo);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
    }


    private void registrarTarea() throws ParseException {
        System.out.println("¿La tarea es principal o subtarea? (1=Principal / 2=Subtarea)");
        int tipoTarea = entrada.nextInt(); entrada.nextLine();

        System.out.println("¿Qué tipo de tarea quieres registrar? (1=Personal / 2=Profesional)");
        int tipo = entrada.nextInt(); entrada.nextLine();

        System.out.println("Título:");
        String titulo = entrada.nextLine();
        System.out.println("Descripción:");
        String descripcion = entrada.nextLine();
        System.out.println("Seleccione prioridad (1=BAJA, 2=MEDIA, 3=ALTA):");
        int opcionPrioridad = entrada.nextInt(); entrada.nextLine();
        Prioridad prioridad;
        switch (opcionPrioridad) {
            case 1 -> prioridad = Prioridad.BAJA;
            case 2 -> prioridad = Prioridad.MEDIA;
            case 3 -> prioridad = Prioridad.ALTA;
            default -> {
                System.out.println("Opción no válida, se asigna BAJA por defecto");
                prioridad = Prioridad.BAJA;
            }
        }

        System.out.println("¿Número de personas encargadas?");
        int nPersonas = entrada.nextInt(); entrada.nextLine();

        Tarea nuevaTarea;
        if (tipo == 1) { // TareaPersonal
            System.out.println("Ubicación:");
            String ubicacion = entrada.nextLine();
            nuevaTarea = new TareaPersonal(titulo, descripcion, prioridad, nPersonas, ubicacion);
        } else { // TareaProfesional
            System.out.println("Presupuesto:");
            int presupuesto = entrada.nextInt(); entrada.nextLine();
            System.out.println("Fecha límite (dd/MM/yyyy):");
            Date fecha = sdf.parse(entrada.nextLine());
            nuevaTarea = new TareaProfesional(titulo, descripcion, prioridad, nPersonas, presupuesto, fecha);
        }

        if (tipoTarea == 1) {
            elementos.add(nuevaTarea);
        } else {
            listarElementos();
            System.out.println("ID de la tarea principal a la que pertenece esta subtarea:");
            int idPadre = entrada.nextInt(); entrada.nextLine();
            ElementoPlanificador ep = buscarElementoPorId(idPadre);
            if (ep instanceof Tarea tareaPadre) {
                tareaPadre.agregarSubtarea(nuevaTarea);
            } else {
                System.out.println("No se encontró una tarea principal con ese ID. Se descartó la subtarea.");
            }
        }

        System.out.println("Tarea registrada correctamente.");
    }



    private void registrarLista() {
        System.out.println("ID de la lista:");
        int id = entrada.nextInt(); entrada.nextLine();
        Lista lista = new Lista(id);
        System.out.println("Introduce elementos (escribe FIN para terminar):");
        String item;
        while (!(item = entrada.nextLine()).equalsIgnoreCase("FIN")) {
            lista.agregarElemento(item);
        }
        elementos.add(lista);
        System.out.println("Lista agregada correctamente.");
    }

    private void modificarTarea() {
        listarElementos();
        System.out.println("Introduce ID de la tarea a modificar:");
        int id = entrada.nextInt(); entrada.nextLine();

        for (ElementoPlanificador ep : elementos) {
            if (ep instanceof Tarea tarea && tarea.getId() == id) {
                System.out.println("Nuevo título:");
                tarea.setTitulo(entrada.nextLine());
                System.out.println("Nueva descripción:");
                tarea.setDescripcion(entrada.nextLine());
                return;
            }
        }
        System.out.println("No se encontró tarea con ese ID");
    }

    public void listarElementos() {
        if (elementos.isEmpty()) {
            System.out.println("No hay elementos registrados.");
            return;
        }
        for (ElementoPlanificador ep : elementos) {
            System.out.println("ID=" + ep.getId() + " -> " + ep);
        }
    }


    private void completarElemento() {
        listarElementos();
        System.out.println("Introduce ID del elemento a completar:");
        int id = entrada.nextInt(); entrada.nextLine();
        for (ElementoPlanificador ep : elementos) {
            if (ep.getId() == id) {
                if (ep instanceof Tarea tarea) {
                    tarea.completarTarea();
                } else if (ep instanceof Lista lista) {
                    lista.setCompletada(true);
                    System.out.println("Lista completada");
                }
                return;
            }
        }
        System.out.println("No encontrado");
    }

    public void listarCompletas() {
        for (ElementoPlanificador ep : elementos) {
            if (ep.isCompletada()) {
                System.out.println(ep);
            }
        }
    }

    public void listarIncompletas() {
        for (ElementoPlanificador ep : elementos) {
            if (!ep.isCompletada()) {
                System.out.println(ep);
            }
        }
    }

    private void asignarPersona() {
        listarElementos();
        System.out.println("ID de la tarea a asignar persona:");
        int id = entrada.nextInt(); entrada.nextLine();
        for (ElementoPlanificador ep : elementos) {
            if (ep instanceof Tarea tarea && tarea.getId() == id) {
                System.out.println("DNI:");
                String dni = entrada.nextLine();
                System.out.println("Nombre:");
                String nombre = entrada.nextLine();
                System.out.println("Apellido:");
                String apellido = entrada.nextLine();
                System.out.println("Edad:");
                int edad = entrada.nextInt(); entrada.nextLine();
                Persona p = new Persona(dni, nombre, apellido, edad);
                tarea.asignarResponsable(p);
                return;
            }
        }
        System.out.println("Tarea no encontrada");
    }

    private void asignarEncargo() {
        listarElementos();
        System.out.println("ID de la tarea a asignar encargo:");
        int id = entrada.nextInt(); entrada.nextLine();
        for (ElementoPlanificador ep : elementos) {
            if (ep instanceof Tarea tarea && tarea.getId() == id) {
                System.out.println("ID Encargo:");
                int idEncargo = entrada.nextInt(); entrada.nextLine();
                System.out.println("Descripción encargo:");
                String desc = entrada.nextLine();
                Encargo e = new Encargo(idEncargo, desc);
                tarea.agregarEncargo(e);
                return;
            }
        }
        System.out.println("Tarea no encontrada");
    }


    private void asignarEncargadoPrincipal() {
        listarElementos();
        System.out.println("ID de la tarea para asignar encargado principal:");
        int id = entrada.nextInt(); entrada.nextLine();
        for (ElementoPlanificador ep : elementos) {
            if (ep instanceof Tarea tarea && tarea.getId() == id) {
                if (tarea.getEncargadoPrincipal() != null) {
                    System.out.println("Ya tiene encargado principal. Use la opción de cambiar.");
                    return;
                }
                System.out.println("DNI:");
                String dni = entrada.nextLine();
                System.out.println("Nombre:");
                String nombre = entrada.nextLine();
                System.out.println("Apellido:");
                String apellido = entrada.nextLine();
                System.out.println("Edad:");
                int edad = entrada.nextInt(); entrada.nextLine();
                Persona p = new Persona(dni, nombre, apellido, edad);
                tarea.asignarEncargadoPrincipal(p);
                return;
            }
        }
        System.out.println("Tarea no encontrada");
    }

    private void cambiarEncargadoPrincipal() {
        listarElementos();
        System.out.println("ID de la tarea para cambiar encargado principal:");
        int id = entrada.nextInt(); entrada.nextLine();
        for (ElementoPlanificador ep : elementos) {
            if (ep instanceof Tarea tarea && tarea.getId() == id) {
                System.out.println("DNI:");
                String dni = entrada.nextLine();
                System.out.println("Nombre:");
                String nombre = entrada.nextLine();
                System.out.println("Apellido:");
                String apellido = entrada.nextLine();
                System.out.println("Edad:");
                int edad = entrada.nextInt(); entrada.nextLine();
                Persona p = new Persona(dni, nombre, apellido, edad);
                tarea.cambiarEncargadoPrincipal(p);
                return;
            }
        }
        System.out.println("Tarea no encontrada");
    }

    private void mostrarEncargadoPrincipal() {
        listarElementos();
        System.out.println("ID de la tarea para mostrar encargado principal:");
        int id = entrada.nextInt(); entrada.nextLine();
        for (ElementoPlanificador ep : elementos) {
            if (ep instanceof Tarea tarea && tarea.getId() == id) {
                tarea.mostrarEncargadoPrincipal();
                return;
            }
        }
        System.out.println("Tarea no encontrada");
    }

    public void agregarElemento(ElementoPlanificador ep) {
        elementos.add(ep);
    }

    public void mostrarDetalleTarea(int id) {
        ElementoPlanificador ep = buscarElementoPorId(id);
        if (ep == null) {
            System.out.println("No existe una tarea con ese ID.");
            return;
        }
        if (!(ep instanceof Tarea)) {
            System.out.println("El ID no corresponde a una tarea.");
            return;
        }

        Tarea tarea = (Tarea) ep;
        System.out.println("===== Detalle de la tarea =====");
        System.out.println(tarea);

        System.out.println(">> Responsables asignados:");
        tarea.mostrarResponsables();

        System.out.println(">> Encargos asignados:");
        tarea.listarEncargos();
    }

    public void completarEncargoEnTarea(int idTarea, int idEncargo) {
        ElementoPlanificador ep = buscarElementoPorId(idTarea);
        if (ep == null) {
            System.out.println("No existe una tarea con ese ID.");
            return;
        }
        if (!(ep instanceof Tarea)) {
            System.out.println("El ID no corresponde a una tarea.");
            return;
        }

        Tarea tarea = (Tarea) ep;
        tarea.completarEncargo(idEncargo);
    }


    public ElementoPlanificador buscarElementoPorId(int id) {
        for (ElementoPlanificador ep : elementos) {
            if (ep.getId() == id) {
                return ep;
            }
        }
        return null;
    }

    public List<ElementoPlanificador> getElementos() {
        return elementos;
    }
}
