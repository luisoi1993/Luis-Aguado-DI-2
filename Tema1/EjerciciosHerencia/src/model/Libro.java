package model;

public class Libro extends Multimedia{
    private String isbn;
    private int numeroPaginas;

    public Libro(int identificador, String titulo, String autor, Double tamanio, String formato, String isbn, int numeroPaginas) {
        super(identificador, titulo, autor, tamanio, formato);
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("El isbn es " + isbn);
        System.out.println("El numero de paginas es " + numeroPaginas);
    }
}
