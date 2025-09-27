package model;

import java.util.ArrayList;

public class TareaPersonal extends Tarea{

    @Override
    public void enviarRecorsatorio() {
        System.out.println("Enviar un recordatorio para reservar sitio en la " +ubicacion);
    }

    private String ubicacion;

    public TareaPersonal(){

    }

    public TareaPersonal(String titulo, String descripcion, boolean prioritario, int numeroPersonas, String ubicacion) {
        super(titulo, descripcion, prioritario, numeroPersonas);
        this.ubicacion = ubicacion;
    }

    public TareaPersonal(String titulo, String descripcion, int numeroPersonas, String ubicacion) {
        super(titulo, descripcion, numeroPersonas);
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
