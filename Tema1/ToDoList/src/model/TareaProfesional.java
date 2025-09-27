package model;

import java.util.Date;

public class TareaProfesional extends Tarea{

    /*
    *  private String titulo, descripcion;
    private boolean prioritario, completada;
    private Persona[] encargados;
    private ArrayList<Encargo> listaTareas;
    * */

    @Override
    public void enviarRecorsatorio() {
        //se imprime por consola  a cada uno de los responsables
        //borja, recuerda terminar las tareas asociadas a esta tarea
        //borja, recuerda terminar las tareas asociadas a esta tarea
        for (Persona persona : getEncargados()){
            if (persona !=null){
                System.out.println(persona);
            }
        }
    }

    private int presupuesto;
    private Date fechaLimite;

    public TareaProfesional(){

    }

    public TareaProfesional(String titulo, String descripcion, int numeroPersonas, int presupuesto, Date fechaLimite) {
        super(titulo, descripcion, numeroPersonas);
        this.presupuesto = presupuesto;
        this.fechaLimite = fechaLimite;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    @Override
    public String toString() {
        return super.toString()+"TareaProfesional{" +
                "presupuesto=" + presupuesto +
                ", fechaLimite=" + fechaLimite +
                '}';
    }
}
