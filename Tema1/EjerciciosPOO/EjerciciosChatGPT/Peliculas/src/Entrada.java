/*Pide por Scanner los datos de una película y crea una instancia p1.

Crea otra película fija p2.

Crea una película vacía p3.

Muestra los datos de todas.

Modifica la calificación de todas a 8.5.

Guarda varias películas en una lista.

Busca una película por título y director, y muéstrala.

Elimina una película de la lista por título.

Ordena la lista por año (ascendente) y, si hay empate, por título.

Crea una película desde CSV y añádela a la lista.

Muestra la lista final por pantalla.*/

import model.Genero;
import model.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite el nombre de el titulo: ");
        String titulo = entrada.nextLine();
        System.out.println("Digite el nombre del director: ");
        String director = entrada.nextLine();
        System.out.println("Digite el año de publicación: ");
        int anio = entrada.nextInt();
        System.out.println("Digite la duracion en numero de minutos: ");
        int duracion = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite el valor de el genero: ");
        String generoString = entrada.nextLine().trim().toUpperCase();
        boolean booleanGenero = true;
        Genero g1 = Genero.TERROR;

        do {
            switch (generoString){
                case "ACCION" :
                    g1 = Genero.ACCION;
                    booleanGenero = false;
                    break;
                case "DRAMA" :
                    g1 = Genero.DRAMA;
                    booleanGenero = false;
                    break;
                case "COMEDIA" :
                    g1 = Genero.COMEDIA;
                    booleanGenero = false;
                    break;
                case "CIENCIA_FICCION" :
                    g1 = Genero.CIENCIA_FICCION;
                    booleanGenero = false;
                    break;
                case "TERROR" :
                    g1 = Genero.TERROR;
                    booleanGenero = false;
                    break;
                default:
                    System.out.println("EL valor del genero esta equivocado , vuelve a digitarlo: ");
                    generoString = entrada.nextLine().trim().toUpperCase();

            }
        }while (booleanGenero);

        System.out.println("Digite el valor de la calificación");
        Double calificacion = entrada.nextDouble();

        Pelicula p1 = new Pelicula(titulo,director,anio,duracion,g1,calificacion);

        p1.mostrarDatos();
        Pelicula p2 = new Pelicula("La comunidad del anillo","Peter Jackson"
        ,2000,120,Genero.CIENCIA_FICCION,10.0);
        Pelicula p3 = new Pelicula();

        p1.mostrarDatos();
        p2.mostrarDatos();
        p3.mostrarDatos();

        p1.setCalificacion(8.5);
        p2.setCalificacion(8.5);
        p3.setCalificacion(8.5);

        List<Pelicula> lista = new ArrayList<>();

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        String tituloBuscado = "La comunidad del anillo";
        String directorBuscado = "Peter Jackson";

        Pelicula encontrada = null;
        for (Pelicula p : lista) {
            if(p.getTitulo().equalsIgnoreCase(tituloBuscado) &&
            p.getDirector().equalsIgnoreCase(directorBuscado)) {
                encontrada = p;
                break;
            }
        }

        if (encontrada != null) {
            System.out.println("Pelicula encontrada:");
            encontrada.mostrarDatos();
        } else {
            System.out.println("No se encontró la película.");
        }

        lista.removeIf(p -> p.getTitulo().equalsIgnoreCase("La comunidad del anillo"));

        lista.sort(
                Comparator.comparingInt(Pelicula::getAnio)
                        .thenComparing(Pelicula::getTitulo)
        );

        Pelicula p4 = Pelicula.from("Matrix, Hermanos wachosky, 2000, 120, CIENCIA_FICCION, 9.0 ");
        lista.add(p4);

        for (Pelicula i : lista) {
            i.mostrarDatos();
        }

    }
}
