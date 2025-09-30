package model;

abstract public class Multimedia {
    private int identificador;
    private String titulo;
    private String autor ;
    private Double tamanio;
    private String formato;

    public Multimedia(int identificador, String titulo, String autor, Double tamanio, String formato) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.autor = autor;
        this.tamanio = tamanio;
        this.formato = formato;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void mostrarDatos() {
        System.out.println("EL identificador es " + identificador);
        System.out.println("El titulo es " + titulo);
        System.out.println("El autor es " + autor);
        System.out.println("El tamaño es " + tamanio);
        System.out.println("El formato es " + formato);
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "identificador=" + identificador +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", tamanio=" + tamanio +
                ", formato='" + formato + '\'' +
                '}';
    }
}
