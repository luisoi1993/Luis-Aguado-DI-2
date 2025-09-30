package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Tarea {
    protected static int contador = 1;


    protected int id;
    protected String titulo;
    protected String descripcion;
    protected Date fecha;
    protected Prioridad prioridad;
    protected boolean completada = false;
    protected List<Tarea> subtareas = new ArrayList<>();


    public Tarea(){
        this.id = contador++;
    }

    public Tarea( String titulo, String descripcion, Date fecha, Prioridad prioridad) {
        this.id = contador++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.prioridad = prioridad;

    }

    public int getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }



    public List<Tarea> getSubtareas() {
        return subtareas;
    }

    public void agregarSubtarea(Tarea subtarea){
        subtareas.add(subtarea);
    }

    public void actualizarCompletada() {
        if (!subtareas.isEmpty()) {
            this.completada = subtareas.stream().allMatch(Tarea::isCompletada);
        }
    }

    public void marcarCompletada() {
        if (subtareas.isEmpty()) {
            this.completada = true;
        } else {
            System.out.println("No se puede completar manualmente, depende de subtareas.");
        }
    }

    public void mostrarTareaConSubtareas(String prefijo) {
        System.out.println(prefijo + this);

        for (Tarea sub : subtareas) {
            sub.mostrarTareaConSubtareas(prefijo + "    ");
        }
    }

    public boolean esCompletable() {
        return subtareas.isEmpty();
    }

    public void completar() {
        if (esCompletable()) {
            this.completada = true;
        } else {
            boolean todasSubtareasCompletas = true;
            for (Tarea sub : subtareas) {
                if (!sub.isCompletada()) {
                    todasSubtareasCompletas = false;
                    break;
                }
            }
            if (todasSubtareasCompletas) {
                this.completada = true;
            }
        }
    }



    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", prioridad=" + prioridad +
                ", completada=" + completada +
                ", subtareas=" + subtareas.size() +
                '}';
    }
}
