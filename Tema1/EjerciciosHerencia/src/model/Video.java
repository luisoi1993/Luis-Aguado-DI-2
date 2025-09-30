package model;

import java.util.List;

public class Video extends Multimedia{
    private Director director;
    private List<Actor> actores;

    public Video(int identificador, String titulo, String autor, Double tamanio, String formato, Director director, List<Actor> actores) {
        super(identificador, titulo, autor, tamanio, formato);
        this.director = director;
        this.actores = actores;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("El Director es" );
        director.mostrarDatos();
        for (Actor a : actores){
            a.mostrarDatos();
        }
    }

    @Override
    public String toString() {
        return "Video{" +
                "director=" + director +
                ", actores=" + actores +
                '}';
    }
}
