package model;

public class TareaPersonal extends Tarea {
    private String ubicacion;

    @Override
    public void enviarRecordatorio() {
        System.out.println("Enviar un recordatorio para reservar sitio en " + ubicacion);
    }

    // Constructor principal usando enum Prioridad
    public TareaPersonal(String titulo, String descripcion, Prioridad prioridad,
                         Persona encargadoPrincipal, String ubicacion) {
        super(titulo, descripcion, prioridad, encargadoPrincipal);
        this.ubicacion = ubicacion;
    }

    // Constructor alternativo (si no hay encargadoPrincipal definido)
    public TareaPersonal(String titulo, String descripcion, int numeroPersonas, String ubicacion) {
        super(titulo, descripcion, numeroPersonas);
        this.ubicacion = ubicacion;
    }

    public TareaPersonal(String titulo, String descripcion, Prioridad prioridad,
                         int numeroPersonas, String ubicacion) {
        super(titulo, descripcion, numeroPersonas);
        this.setPrioridad(prioridad);
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void mostrarDatos() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " TareaPersonal{" +
                "ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
