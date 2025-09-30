package model;

import java.util.Date;

public class TareaOcio extends Tarea {
    private String ubicacion;
    private double presupuesto;

    public TareaOcio() {

    }

    public TareaOcio(String titulo, String descripcion, Date fecha, Prioridad prioridad, String ubicacion, double presupuesto) {
        super(titulo, descripcion, fecha, prioridad);
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "TareaOcio{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", prioridad=" + prioridad +
                ", completada=" + completada +
                ", ubicacion='" + ubicacion + '\'' +
                ", presupuesto=" + presupuesto +
                '}';
    }

}
