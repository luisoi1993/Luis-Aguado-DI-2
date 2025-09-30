package model;

import java.util.Date;

public class TareaProfesional extends Tarea {
    private int presupuesto;
    private Date fechaLimite;

    @Override
    public void enviarRecordatorio() {
        // Se imprime por consola a cada uno de los responsables un recordatorio
        for (Persona persona : getEncargados()) {
            if (persona != null) {
                System.out.printf("%s, recuerda completar %d tareas pendientes\n",
                        persona.getNombre(), getListaTareas().size());
            }
        }
    }

    // Constructor usando numeroPersonas (sin encargado principal definido)
    public TareaProfesional(String titulo, String descripcion, int numeroPersonas,
                            int presupuesto, Date fechaLimite) {
        super(titulo, descripcion, numeroPersonas);
        this.presupuesto = presupuesto;
        this.fechaLimite = fechaLimite;
    }

    // Constructor principal usando Prioridad + Persona encargadoPrincipal
    public TareaProfesional(String titulo, String descripcion, Prioridad prioridad,
                            Persona encargadoPrincipal, int presupuesto, Date fechaLimite) {
        super(titulo, descripcion, prioridad, encargadoPrincipal);
        this.presupuesto = presupuesto;
        this.fechaLimite = fechaLimite;
    }

    public TareaProfesional(String titulo, String descripcion, Prioridad prioridad,
                            int numeroPersonas, int presupuesto, Date fechaLimite) {
        super(titulo, descripcion, numeroPersonas);
        this.setPrioridad(prioridad);
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
        return super.toString() + " TareaProfesional{" +
                "presupuesto=" + presupuesto +
                ", fechaLimite=" + fechaLimite +
                '}';
    }
}
