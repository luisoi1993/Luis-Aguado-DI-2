package model;

import java.util.Date;

public class TareaOcio extends Tarea{
    private String ubicacion;
    private double presupuesto;

    public TareaOcio(){

    }

    public TareaOcio(String titulo, Date fecha, Prioridad prioridad, boolean completada, String ubicacion, double presupuesto) {
        super(titulo, fecha, prioridad, completada);
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
    }
}
