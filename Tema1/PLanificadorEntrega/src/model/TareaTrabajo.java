package model;

import java.util.Date;

public class TareaTrabajo extends Tarea {

    private Proyecto proyecto;

    public TareaTrabajo(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public TareaTrabajo(String titulo, String descripcion ,Date fecha, Prioridad prioridad, Proyecto proyecto) {
        super(titulo, descripcion, fecha, prioridad);
        this.proyecto = proyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "TareaTrabajo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", prioridad=" + prioridad +
                ", completada=" + completada +
                ", proyecto=" + proyecto +
                '}';
    }
}