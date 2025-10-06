package model;

abstract public class Videojuego {
    private String titulo, desarollador;
    private int anioLanzamiento;
    private double precio;
    private String clasificacionEdad;

    public Videojuego{

    }

    public Videojuego(String titulo, String desarollador, int anioLanzamiento, double precio, String clasificacionEdad) {
        this.titulo = titulo;
        this.desarollador = desarollador;
        this.anioLanzamiento = anioLanzamiento;
        this.precio = precio;
        this.clasificacionEdad = clasificacionEdad;
    }

    public double calcularPrecioFinal();

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
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
