import model.Libro;

import java.util.*;

/*Crea una clase Entrada con main que:

Pida por Scanner los datos de un libro y lo cree (l1).

Cree un libro con título y autor fijos (l2).

Cree un libro con datos vacíos (l3).

Muestre los datos de todos los libros.

Modifique el precio de todos los libros a 9.99.

Crea una lista de libros y añade varios.

Busca un libro en la lista por ISBN y lo elimina.

Muestra todos los libros restantes.

Ordena la lista de libros primero por año de publicación (ascendente) y,
 si empatan, por título alfabético.

Muestra el resultado.

Crea un libro desde CSV con el método from y añádelo a la lista.*/

public class Entrada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite el valor de titulo: ");
        String titulo = entrada.nextLine();
        System.out.println("Digite el valor del autor: ");
        String autor = entrada.nextLine();
        System.out.println("Digite el valor del isbn: ");
        String isbn = entrada.nextLine();
        System.out.println("Digite el número de paginas: ");
        int paginas = entrada.nextInt();
        System.out.println("Digite el precio del libro: ");
        double precio = entrada.nextDouble();
        System.out.println("Digite el año de publicación: ");
        int anio = entrada.nextInt();

        Libro l1 = new Libro(titulo,autor,isbn,paginas,precio,anio);
        Libro l2 = new Libro("Harry potter","J.K.Rowling");
        Libro l3 = new Libro("La comunidad del anillo","Tolkien","1",111,23,1111);

        l1.mostrarDatos();
        l2.mostrarDatos();

        l1.setPrecio(9.99);
        l2.setPrecio(9.99);

        l1.mostrarDatos();

        List<Libro> lista = new ArrayList<>();
        lista.add(l1);
        lista.add(l2);
        lista.add(l3);

        String isbnBuscado = "1";
        Libro encontrado = lista.stream().filter(l -> Objects.equals(l.getIsbn(), isbnBuscado)).findFirst().orElse(null);

        System.out.println("Busqueda: " + encontrado);

        if(encontrado != null){
            lista.remove(encontrado);
            System.out.println("Libro eliminado: " + encontrado);
        } else {
            System.out.println("No se encontró un libro con ISBN " + isbnBuscado);
        }

        for (Libro l : lista){
            System.out.println(l);
        }

        lista.sort(
                Comparator.comparingInt(Libro::getAnioPublicacion)
                        .thenComparing(Libro::getTitulo)
        );

        lista.forEach(System.out::println);

        System.out.println("\nCreando persona desde CSV:");
        Libro l4 = Libro.from("Las dos torres, Tolkien, 123214, 1111, 10.00, 2014");
        lista.add(l4);
        l4.mostrarDatos();

    }
}
