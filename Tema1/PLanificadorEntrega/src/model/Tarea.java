package model;

import java.util.Date;

public class Tarea {
    private static int contador = 1;
    private int id;
    private String titulo;
    private Date fecha;
    private Prioridad prioridad;
    private boolean completada = false;

    public Tarea(){
        this.id = contador++;
    }

    public Tarea( String titulo, Date fecha, Prioridad prioridad, boolean completada) {
        this.id = contador++;
        this.titulo = titulo;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.completada = completada;
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

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", prioridad=" + prioridad +
                ", completada=" + completada +
                '}';
    }
}
