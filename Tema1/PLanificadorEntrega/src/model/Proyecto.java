package model;

public class Proyecto {
    private String descripcion;

    public Proyecto(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "descripcion='" + descripcion + '\'' + '}';
    }
}
