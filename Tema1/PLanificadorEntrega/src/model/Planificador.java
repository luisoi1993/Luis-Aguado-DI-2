package model;

import java.util.ArrayList;
import java.util.List;

public class Planificador {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public Tarea buscarPorId(int id) {
        return tareas.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (Tarea t : tareas) {
                t.mostrarTareaConSubtareas("");
            }
        }
    }


    public void listarCompletas() {
        tareas.stream().filter(Tarea::isCompletada).forEach(System.out::println);
    }

    public void listarIncompletas() {
        tareas.stream().filter(t -> !t.isCompletada()).forEach(System.out::println);
    }

    public void completarTarea(int id) {
        Tarea t = buscarPorId(id);
        if (t == null) {
            System.out.println("No existe tarea con ese ID");
            return;
        }

        if (t.esCompletable()) {
            t.completar();
            System.out.println("Tarea " + t.getId() + " completada.");
        } else {
            t.completar();
            if (t.isCompletada()) {
                System.out.println("Tarea padre completada (todas las subtareas ya estaban completas).");
            } else {
                System.out.println("No puedes completar esta tarea hasta que todas las subtareas estén completas.");
            }
        }
    }

}
