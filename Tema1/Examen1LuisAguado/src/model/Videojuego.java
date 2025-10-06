package model;

public class Videojuego {
    private String titulo, desarollador;
    private int anioLanzamiento;
    private Double precio;
    private String clasificacionEdad;

    public Videojuego(String titulo, String desarollador, int anioLanzamiento, Double precio, String clasificacionEdad) {
        this.titulo = titulo;
        this.desarollador = desarollador;
        this.anioLanzamiento = anioLanzamiento;
        this.precio = precio;
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarollador() {
        return desarollador;
    }

    public void setDesarollador(String desarollador) {
        this.desarollador = desarollador;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public double calcularPrecioFinal() {
        return 0;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", desarollador='" + desarollador + '\'' +
                ", anioLanzamiento=" + anioLanzamiento +
                ", precio=" + precio +
                ", clasificacionEdad='" + clasificacionEdad + '\'' +
                '}';
    }
}
