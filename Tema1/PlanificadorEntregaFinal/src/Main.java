import model.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Planificador planificador = new Planificador();

        System.out.println("===========================================");
        System.out.println("=== PRUEBAS DEL PLANIFICADOR ===");
        System.out.println("===========================================\n");

        // -------------------------
        // 1) Crear personas
        // -------------------------
        Persona p1 = new Persona("111A", "Ana", "López", 30);
        Persona p2 = new Persona("222B", "Luis", "Martín", 28);
        Persona p3 = new Persona("333C", "Marta", "Pérez", 25);
        Persona p4 = new Persona("444D", "Carla", "Gómez", 35);
        Persona p5 = new Persona("555E", "Juan", "Ruiz", 40);

        System.out.println("Personas creadas: ");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

        // -------------------------
        // 2) Crear tareas (principales) y añadir al planificador
        // -------------------------
        TareaPersonal tp1 = new TareaPersonal("Ir al médico", "Revisión general", Prioridad.MEDIA, 2, "Clínica Central");
        TareaProfesional tprof1 = new TareaProfesional("Proyecto App", "Desarrollar app móvil", Prioridad.ALTA, 3, 2000, sdf.parse("30/12/2025"));

        planificador.agregarElemento(tp1);
        planificador.agregarElemento(tprof1);

        System.out.println("\n== Listado tras añadir 2 tareas principales ==");
        planificador.listarElementos();

        // -------------------------
        // 3) Asignar responsables (pruebas de huecos y DNI duplicado)
        // -------------------------
        System.out.println("\n== Asignar responsables a tarea personal (capacidad 2) ==");
        tp1.asignarResponsable(p1);
        tp1.asignarResponsable(p2);
        System.out.println("Intentar asignar persona con DNI repetido (Ana) -> debe avisar:");
        tp1.asignarResponsable(p1);
        System.out.println("Intentar asignar una 3ª persona (Marta) en capacidad 2 -> debe avisar:");
        tp1.asignarResponsable(p3);

        System.out.println("\nResponsables actuales de tp1:");
        tp1.mostrarResponsables();


        System.out.println("\n== Eliminar responsable (Luis) ==");
        tp1.eliminarResponsable("222B");
        tp1.mostrarResponsables();

        // -------------------------
        // 4) Encargados principales (asignar y cambiar)
        // -------------------------
        System.out.println("\n== Encargado principal en tarea profesional ==");
        tprof1.asignarEncargadoPrincipal(p4);
        tprof1.mostrarEncargadoPrincipal();

        System.out.println("Intentar asignar otro encargado principal sin cambiar -> debe avisar");
        tprof1.asignarEncargadoPrincipal(p5);

        System.out.println("Cambiar encargado principal a Juan:");
        tprof1.cambiarEncargadoPrincipal(p5);
        tprof1.mostrarEncargadoPrincipal();

        // -------------------------
        // 5) Añadir encargos (incluyendo duplicado por ID)
        // -------------------------
        System.out.println("\n== Añadir encargos a tarea profesional ==");
        Encargo e1 = new Encargo(1, "Diseñar interfaz");
        Encargo e2 = new Encargo(2, "Implementar backend");
        Encargo e3 = new Encargo(3, "Preparar tests");

        tprof1.agregarEncargo(e1);
        tprof1.agregarEncargo(e2);
        System.out.println("Intentar añadir encargo con ID duplicado (1) -> debe avisar:");
        tprof1.agregarEncargo(new Encargo(1, "Duplicado"));
        tprof1.agregarEncargo(e3);

        System.out.println("\nEncargos en tprof1:");
        tprof1.listarEncargos();

        // -------------------------
        // 6) Subtareas: crear y asignar a tprof1
        // -------------------------
        System.out.println("\n== Crear subtareas y asignarlas a tprof1 ==");
        TareaPersonal subA = new TareaPersonal("SubA - Documentación", "Revisar documentación", Prioridad.BAJA, 1, "Oficina");
        TareaPersonal subB = new TareaPersonal("SubB - Entorno", "Configurar entorno", Prioridad.BAJA, 1, "Sala dev");

        tprof1.agregarSubtarea(subA);
        tprof1.agregarSubtarea(subB);

        System.out.println("Subtareas de tprof1:");
        tprof1.listarSubtareas();


        System.out.println("\n== Añadir encargos a SubA y SubB ==");
        subA.agregarEncargo(new Encargo(10, "Redactar requisitos"));
        subA.agregarEncargo(new Encargo(11, "Revisión requisitos"));
        subB.agregarEncargo(new Encargo(20, "Instalar dependencias"));

        System.out.println("Encargos SubA:");
        subA.listarEncargos();
        System.out.println("Encargos SubB:");
        subB.listarEncargos();

        // -------------------------
        // 7) Intentar completar tprof1 (debe fallar: hay encargos y subtareas pendientes)
        // -------------------------
        System.out.println("\n== Intentar completar tprof1 (debe FALLAR por encargos y subtareas pendientes) ==");
        tprof1.completarTarea();

        // -------------------------
        // 8) Completar encargos: usar método de la tarea y también el de Planificador
        // -------------------------
        System.out.println("\n== Completar algunos encargos en tprof1 y subtareas ==");
        System.out.println("Completar encargo 2 de tprof1 vía Planificador:");
        planificador.completarEncargoEnTarea(tprof1.getId(), 2);

        System.out.println("Completar encargo 1 de tprof1 directamente:");
        tprof1.completarEncargo(1);

        System.out.println("Encargos tprof1 tras completar 1 y 2:");
        tprof1.listarEncargos();

        System.out.println("\nCompletar encargos de SubA y SubB (para poder completar subtareas):");
        subA.completarEncargo(10);
        subA.completarEncargo(11);
        subA.completarTarea();
        subB.completarEncargo(20);
        subB.completarTarea();

        System.out.println("Estado SubA completada? " + subA.isCompletada());
        System.out.println("Estado SubB completada? " + subB.isCompletada());

        // -------------------------
        // 9) Intentar completar tprof1 otra vez (aún queda encargo 3 pendiente)
        // -------------------------
        System.out.println("\n== Intentar completar tprof1 nuevamente (aún falta encargo 3) ==");
        tprof1.completarTarea();

        System.out.println("\nCompletar encargo 3 de tprof1:");
        tprof1.completarEncargo(3);

        System.out.println("Intentar completar tprof1 final (ahora todos encargos + subtareas están completos):");
        tprof1.completarTarea();
        System.out.println("Estado tprof1 completada? " + tprof1.isCompletada());

        // -------------------------
        // 10) Buscar encargo por id y listar completados
        // -------------------------
        System.out.println("\n== Buscar encargo por id en tprof1 y listar completados ==");
        tprof1.buscarEncargoId(2);
        System.out.println("Encargos completados en tprof1:");
        tprof1.listarEncargosCompletados();

        // -------------------------
        // 11) Borrar un encargo (prueba borrarEncargo y borrarEncargo1)
        // -------------------------
        System.out.println("\n== Borrar encargo 3 de tprof1 (borrarEncargo) ==");
        tprof1.borrarEncargo(3);
        System.out.println("Encargos actuales en tprof1:");
        tprof1.listarEncargos();

        System.out.println("\n== Añadir de nuevo encargo id=3 y probar borrarEncargo1 (que devuelve boolean) ==");
        tprof1.agregarEncargo(new Encargo(3, "Preparar tests (re-add)"));
        boolean eliminado = tprof1.borrarEncargo1(3);
        System.out.println("borrarEncargo1 devolvió: " + eliminado);
        System.out.println("Encargos actuales en tprof1:");
        tprof1.listarEncargos();

        // -------------------------
        // 12) Trabajar con Lista (elemento no tarea)
        // -------------------------
        System.out.println("\n== Crear Lista y probar funciones ==");
        Lista listaCompra = new Lista(500);
        listaCompra.agregarElemento("Pan");
        listaCompra.agregarElemento("Leche");
        planificador.agregarElemento(listaCompra);

        System.out.println("Mostrar lista (por su método):");
        listaCompra.mostrarLista();

        System.out.println("\nListar elementos del planificador (ahora incluye lista):");
        planificador.listarElementos();

        System.out.println("Marcar lista como completada (setCompletada) y comprobar listadas:");
        listaCompra.setCompletada(true);

        System.out.println("\n== Listar completadas (debería salir la lista y tprof1 si está completada) ==");
        planificador.listarCompletas();

        System.out.println("\n== Listar incompletas ==");
        planificador.listarIncompletas();

        // -------------------------
        // 13) Mostrar detalle de una tarea vía Planificador
        // -------------------------
        System.out.println("\n== Mostrar detalle de tprof1 vía Planificador (encargos, responsables) ==");
        planificador.mostrarDetalleTarea(tprof1.getId());

        // -------------------------
        // 14) Probar eliminar responsable que no existe
        // -------------------------
        System.out.println("\n== Intentar eliminar responsable con DNI inexistente en tp1 ==");
        tp1.eliminarResponsable("999Z");

        // -------------------------
        // 15) Probar agregar una subtarea como tarea independiente y probar completar logic
        // -------------------------
        System.out.println("\n== Añadir una subtarea como Tarea principal al planificador (para probar completar vía planificador) ==");
        TareaPersonal tSolo = new TareaPersonal("Tarea independiente", "Tarea fuera de jerarquía", Prioridad.MEDIA, 1, "Local");
        tSolo.agregarEncargo(new Encargo(77, "Tarea extra - encargo 77"));
        planificador.agregarElemento(tSolo);

        System.out.println("Listado actual:");
        planificador.listarElementos();

        System.out.println("\nCompletar encargo 77 directamente y luego completar la tarea:");
        tSolo.completarEncargo(77);
        tSolo.completarTarea();
        System.out.println("tSolo completada? " + tSolo.isCompletada());

        // -------------------------
        // 16) Estado final antes del menú
        // -------------------------
        System.out.println("\n===========================================");
        System.out.println("ESTADO FINAL (antes de iniciar el menú):");
        planificador.listarElementos();
        System.out.println("===========================================\n");

        // -------------------------
        // 17) Iniciar menú interactivo para seguir probando manualmente
        // -------------------------
        System.out.println("A continuación se inicia el menú interactivo. Prueba opciones manualmente.");
        planificador.menu();
    }
}
