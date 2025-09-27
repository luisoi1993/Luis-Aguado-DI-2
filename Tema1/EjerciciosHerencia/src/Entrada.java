import model.Actor;
import model.Director;
import model.Libro;
import model.Multimedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Director d1 = new Director("Peter Jackson","3525235");
        Actor a1 = new Actor("Orlando Bloom","344434f");
        Actor a2 = new Actor("Aragon","34424523d");
        List<Multimedia> listaMultimedia = new ArrayList<>();

        int eleccion = 0;
        do{
            System.out.println("1.Agregar archivo Multimedia");
             eleccion = entrada.nextInt();


            switch (eleccion){
                case 1:
                    System.out.println("Elige el tipo de archivo multimedia para crear");
                    System.out.println("1.Libro");
                    System.out.println("2.Video");
                    System.out.println("3.Audio");
                    int numeroArchivo = entrada.nextInt();

                    System.out.println("Digite el identificador");
                    int identificador = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Digite el nombre del titulo: ");
                    String titulo = entrada.nextLine();
                    System.out.println("Digite el nombre de autor: ");
                    String autor = entrada.nextLine();
                    System.out.println("Digite el tamaño en Gb");
                    Double tamanio = entrada.nextDouble();
                    entrada.nextLine();
                    System.out.println("Digite el tipo de formato:");
                    String formato = entrada.nextLine();


                    switch (numeroArchivo){
                        case 1:
                            System.out.println("Digite el isbn: ");
                            String isbn = entrada.nextLine();
                            System.out.println("Digite el número de paginas: ");
                            int numeroPaginas = entrada.nextInt();
                            entrada.nextLine();
                            Libro l1 = new Libro(identificador,titulo,autor,tamanio,formato,isbn,numeroPaginas);
                            listaMultimedia.add(l1);
                            System.out.println("Libro añadido correctamente: ");

                    } case 2:



            }
        }while (eleccion!=4);

        for(Multimedia m : listaMultimedia){
            System.out.println(m);
        }
    }
}
