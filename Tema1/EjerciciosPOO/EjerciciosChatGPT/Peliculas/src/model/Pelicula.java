package model;
/*Crea una clase llamada Pelicula con:

Propiedades:

título (String)

director (String)

año (int)

duración en minutos (int)

género (enum con valores: ACCION, DRAMA, COMEDIA, CIENCIA_FICCION, TERROR)

calificación (double, de 0.0 a 10.0)

Constructores:

Con todos los datos.

Con título y director (el resto a valores por defecto).

Sin datos (todo "desconocido" o 0).

Métodos:

mostrarDatos() → imprime todos los atributos de la película.

esClasico() → devuelve true si la película tiene más de 25 años.

toString(), equals() y hashCode() → dos películas son iguales si tienen el mismo título y director.

from(String csv) → crea una película desde un string CSV en formato:
"Titulo, Director, Año, Duracion, Genero, Calificacion"*/

import java.util.Objects;

public class Pelicula {
    private String titulo , director;
    private int anio,duracionMin;
    private Genero genero;
    private Double calificacion;



    public Pelicula(String titulo, String director, int anio, int duracionMin, Genero genero, Double calificacion) {
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.duracionMin = duracionMin;
        this.genero = genero;
        this.calificacion = validarCalificacion(calificacion);
    }

    public Pelicula(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
        this.anio = 0;
        this.duracionMin = 0;
        this.genero = Genero.ACCION;
        this.calificacion = 0.0;
    }

    public Pelicula(){
        this.titulo = "Desconocido";
        this.director = "Desconocido";
        this.anio = 0;
        this.duracionMin = 0;
        this.genero = Genero.ACCION;
        this.calificacion = 0.0;
    }

    public void mostrarDatos(){
        System.out.printf("Titulo: %s - Director: %s - Año: %d - Duración: %d - Genero: %s - Calificación: %.2f%n",titulo,director,anio,duracionMin,genero,calificacion);
        System.out.println();
    }

    public boolean esClasico(){
        int anioActual = 2025;

        return anioActual - this.anio > 25;
    }

    private double validarCalificacion(double calificacion){
        if (calificacion < 0.0 || calificacion > 10.0){
            throw new IllegalArgumentException("La calificación tiene que estar entre 0.0 y 10.0");
        }
        return calificacion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", anio=" + anio +
                ", duracionMin=" + duracionMin +
                ", genero=" + genero +
                ", calificacion=" + calificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(titulo, pelicula.titulo) && Objects.equals(director, pelicula.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, director);
    }

    public static Pelicula from(String csv){
        String[] p = csv.split(",");
        if(p.length != 6) throw new IllegalArgumentException("csv inválido");
        String titulo = p[0].trim();
        String director = p[1].trim();
        int anio = Integer.parseInt(p[2].trim());
        int duracionMin = Integer.parseInt(p[3].trim());
        Genero genero = Genero.valueOf(p[4].trim().toUpperCase());
        double calificacion = Double.parseDouble(p[5].trim());
        return new Pelicula(titulo,director,anio,duracionMin,genero,calificacion);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {

        this.calificacion = validarCalificacion(calificacion);
    }
}
