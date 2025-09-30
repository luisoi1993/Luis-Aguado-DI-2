package model;

import java.util.ArrayList;

// crear el método que permite agregar un encargo
// los encargos deben tener ID unico -> PONER AVISOS
// crear el método que permite eliminar un encargo
// para ello se pide el id del encargo y se quita de la lista -> PONER AVISOS

/*
Listar todos los encargos de una tarea
 */

/*
Buscar un encargo por id y mostrar sus datos
 */

/*
Completar un encargo -> pasar su variable completada a true
 */

/*
Mostrar un encargo que estan completados
 */

/*
Completar una tarea -> Una tarea quedará completa si todos sus encargos
estan completos
 */

/*
Crear los metodos de:
asignar a un encargo un responsable
Para poder asignar un responsable al encargo, previamente debe estar como integrante del
equipo
 */

/*
Cambiar responsable de tarea
 */

/*
Mostrar tareas por responsable -> DNI
 */



abstract public class Tarea implements ElementoPlanificador {
    private static int contadorId = 1;
    private int id;
    private String titulo, descripcion;
    private Prioridad prioridad;
    private Persona[] encargados;
    private ArrayList<Encargo> listaTareas;
    private Persona encargadoPrincipal;
    private ArrayList<Tarea> subtareas = new ArrayList<>();
    private boolean completada; // ✅ añadido

    public Tarea(String titulo, String descripcion, Prioridad prioridad, Persona encargadoPrincipal) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
        this.prioridad = prioridad;
        this.encargadoPrincipal = encargadoPrincipal;
        this.subtareas = new ArrayList<>();
        this.listaTareas = new ArrayList<>(); // ✅ corregido
    }

    public Tarea(String titulo, String descripcion, int numeroPersonas) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.encargados = new Persona[numeroPersonas];
        this.listaTareas = new ArrayList<>();
        this.completada = false; // ✅ inicializado
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public boolean isCompletada() {
        return completada;
    }

    // Método abstracto que implementarán las subclases
    public abstract void enviarRecordatorio();

    // ================= RESPONSABLES =================
    public void asignarResponsable(Persona persona) {
        for (int i = 0; i < encargados.length; i++) {
            if (encargados[i] == null && !estaDNI(persona.getDni())) {
                encargados[i] = persona;
                System.out.println("Persona agregada correctamente");
                return;
            }
        }
        System.out.println("No hay hueco disponible, tarea completa o DNI repetido");
    }

    public void eliminarResponsable(String dni) {
        for (int i = 0; i < encargados.length; i++) {
            if (encargados[i] != null && encargados[i].getDni().equalsIgnoreCase(dni)) {
                encargados[i] = null;
                System.out.println("Persona eliminada correctamente");
                return;
            }
        }
        System.out.printf("La persona con DNI %s no está en esta tarea%n", dni);
    }

    public void mostrarResponsables() {
        int numeroHuecos = 0;
        for (Persona persona : encargados) {
            if (persona == null) {
                numeroHuecos++;
            } else {
                System.out.println(persona);
            }
        }

        if (numeroHuecos == encargados.length) {
            System.out.println("No hay responsables asignados");
        } else if (numeroHuecos > 0) {
            System.out.printf("Hay %d huecos disponibles%n", numeroHuecos);
        } else {
            System.out.println("Todos los responsables están ubicados");
        }
    }

    private boolean estaDNI(String dni) {
        for (Persona persona : encargados) {
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }


    private Encargo estaEncargo(int id) {
        for (Encargo encargo : listaTareas) {
            if (encargo.getId() == id) return encargo;
        }
        return null;
    }

    public void agregarEncargo(Encargo encargo) {
        if (estaEncargo(encargo.getId()) != null) {
            System.out.println("Error en el proceso, el ID ya existe");
        } else {
            listaTareas.add(encargo);
            System.out.println("Encargo agregado correctamente");
        }
    }

    public void borrarEncargo(int id) {
        if (estaEncargo(id) != null) {
            listaTareas.remove(estaEncargo(id));
            System.out.println("Encargo borrado correctamente");
        } else {
            System.out.println("No está en la lista el id especificado");
        }
    }

    public boolean borrarEncargo1(int id) {
        return listaTareas.remove(estaEncargo(id));
    }

    public void listarEncargos() {
        for (Encargo item : listaTareas) {
            item.mostrarDatos();
        }
    }

    public void listarEncargosCompletados() {
        for (Encargo encargo : listaTareas) {
            if (encargo.isCompletada()) {
                encargo.mostrarDatos();
            }
        }
    }

    public void buscarEncargoId(int id) {
        if (estaEncargo(id) != null)
            estaEncargo(id).mostrarDatos();
        else
            System.out.println("El id no se encuentra en la lista");
    }

    public void completarEncargo(int id) {
        if (estaEncargo(id) != null && !estaEncargo(id).isCompletada()) {
            estaEncargo(id).setCompletada(true);
            System.out.println("Encargo completado correctamente");
        } else {
            System.out.println("El encargo no se puede completar, " +
                    "no está en la lista o ya está completado");
        }
    }


    public void asignarEncargadoPrincipal(Persona persona) {
        if (encargadoPrincipal == null) {
            encargadoPrincipal = persona;
            System.out.println("Encargado principal asignado correctamente.");
        } else {
            System.out.println("Ya existe un encargado principal. Use cambiarEncargadoPrincipal para modificarlo.");
        }
    }

    public void cambiarEncargadoPrincipal(Persona persona) {
        if (encargadoPrincipal != null) {
            System.out.printf("Encargado principal cambiado de %s a %s%n", encargadoPrincipal.getNombre(), persona.getNombre());
            encargadoPrincipal = persona;
        } else {
            System.out.println("No había encargado principal. Asignando ahora...");
            encargadoPrincipal = persona;
        }
    }

    public void mostrarEncargadoPrincipal() {
        if (encargadoPrincipal != null) {
            System.out.println("Encargado principal: " + encargadoPrincipal);
        } else {
            System.out.println("No hay encargado principal asignado.");
        }
    }

    public void agregarSubtarea(Tarea subtarea) {
        subtareas.add(subtarea);
        System.out.println("Subtarea agregada correctamente");
    }

    public void listarSubtareas() {
        if (subtareas.isEmpty()) {
            System.out.println("No hay subtareas asignadas");
        } else {
            for (Tarea t : subtareas) {
                System.out.println(" - " + t);
            }
        }
    }

    public void completarTarea() {
        for (Encargo encargo : listaTareas) {
            if (!encargo.isCompletada()) {
                System.out.println("No se puede completar la tarea, aún hay encargos pendientes");
                return;
            }
        }

        for (Tarea subtarea : subtareas) {
            if (!subtarea.isCompletada()) {
                System.out.println("No se puede completar la tarea, aún hay subtareas pendientes");
                return;
            }
        }

        completada = true;
        System.out.println("Tarea completada con éxito");
    }


    public Persona[] getEncargados() {
        return encargados;
    }

    public void setEncargados(Persona[] encargados) {
        this.encargados = encargados;
    }

    public ArrayList<Encargo> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Encargo> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Persona getEncargadoPrincipal() {
        return encargadoPrincipal;
    }

    public void setEncargadoPrincipal(Persona encargadoPrincipal) {
        this.encargadoPrincipal = encargadoPrincipal;
    }


    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad=" + prioridad +
                ", completada=" + completada +
                ", encargadoPrincipal=" + (encargadoPrincipal != null ? encargadoPrincipal.getNombre() : "Ninguno") +
                '}';
    }
}
