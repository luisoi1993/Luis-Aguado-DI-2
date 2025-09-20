package model;
/*Crea una clase llamada Libro con:

Propiedades: titulo (String), autor (String), isbn (String), paginas (int),
 precio (double), anioPublicacion (int).

Métodos: mostrarDatos, getters y setters.

Constructores:

Con todos los datos.

Solo con título y autor (los demás con valores por defecto).

Sin datos (todos valores genéricos).

Un método estático from(String csv) que cree un libro a partir de una cadena CSV
("El Quijote, Cervantes, 9788491050299, 1200, 19.95, 1605").*/

import java.util.Objects;

public class Libro {
    private String titulo, autor, isbn;
    private int paginas;
    private double precio;
    private int anioPublicacion;

    public Libro() {

    }

    public Libro(String titulo, String autor, String isbn, int paginas, double precio, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
        this.precio = precio;
        this.anioPublicacion = anioPublicacion;
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public static Libro from(String csv) {
        String[] p = csv.split(",");
        if (p.length != 6) throw new IllegalArgumentException("csv inválido");
        String titulo = p[0].trim();
        String autor = p[1].trim();
        String isbn = p[2].trim();
        int paginas = Integer.parseInt(p[3].trim());
        double precio = Double.parseDouble(p[4].trim());
        int anioPublicacion = Integer.parseInt(p[5].trim());
        return new Libro(titulo, autor, isbn, paginas, precio, anioPublicacion);
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void mostrarDatos() {
        System.out.printf("Titulo: %s Autor: %s ISBN: %s Paginas: %d Precio: %.2f Año de publicacion: %d%n", titulo, autor, isbn, paginas, precio, anioPublicacion);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", paginas=" + paginas +
                ", precio=" + precio +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }
}
