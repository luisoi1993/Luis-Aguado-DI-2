package model;

public class Audio extends Multimedia{
    private int duracion;
    private String soporte;

    public Audio(int identificador, String titulo, String autor, Double tamanio, String formato, int duracion, String soporte) {
        super(identificador, titulo, autor, tamanio, formato);
        this.duracion = duracion;
        this.soporte = soporte;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }
}
