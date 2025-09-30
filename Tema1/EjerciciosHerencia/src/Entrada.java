import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
            System.out.println("2.Eliminar un archivo multimedia de la lista: ");
            System.out.println("3.Listar lor archivos: ");
            System.out.println("4.Buscar todos los libros de un autor: ");
            System.out.println("5.Buscar todas las Películas en las que aparece un actor: ");
            System.out.println("6.Buscar todas las Películas del mismo Director: ");
            System.out.println("7.Salir");
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
                            break;

                        case 2:
                            System.out.println("Digite el nombre del director: ");
                            String nombreDirector = entrada.nextLine();
                            System.out.println("Digite el dni del director: ");
                            String dniDirector = entrada.nextLine();
                            Director d10 = new Director(nombreDirector,dniDirector);
                            System.out.println("Digite el número de actores");
                            int numeroActores = entrada.nextInt();
                            entrada.nextLine();
                            List<Actor> actores = new ArrayList<>();
                            for (int i = 0; i<numeroActores;i++){
                                System.out.println("Digite el nombre del actor");
                                String nombreActor = entrada.nextLine();
                                System.out.println("Dni del actor: ");
                                String dniActor = entrada.nextLine();
                                Actor a10 = new Actor(nombreActor,dniActor);
                                actores.add(a10);
                            }
                            Video v10 = new Video(identificador,titulo,autor,tamanio,formato,d10,actores);
                            listaMultimedia.add(v10);
                            System.out.println("Video añadido correctamente: ");
                            System.out.println(v10.toString());
                            break;

                        case 3 :
                            System.out.println("Digite la duración: ");
                            int duracion = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Digite el soporte: ");
                            String soporte = entrada.nextLine();
                            Audio a5 = new Audio(identificador,titulo,autor,tamanio,formato,duracion,soporte);
                            listaMultimedia.add(a5);
                            System.out.println("Audio añadido correctamente: ");
                            System.out.println(a5.toString());
                            break;

                        default:
                            System.out.println("Elección no valida: ");


                    }
                    break;

                case 2:
                    System.out.println("Digite el identificador del archivo multimedia que quiere eliminar: ");
                    int identificadorEliminar = entrada.nextInt();
                    entrada.nextLine();
                    boolean encontrado = listaMultimedia.removeIf(p -> p.getIdentificador() == identificadorEliminar);
                    if (encontrado) {
                        System.out.println("Elemento eliminado correctamente: ");
                    } else {
                        System.out.println("No hay archivos multimedia con ese identificador: ");
                    }
                    break;

                case 3:
                    System.out.println("Digite de que tipo de archivo multimedia quiere sacar la lista: ");
                    System.out.println("1.Libros");
                    System.out.println("2.Audios");
                    System.out.println("3.Videos");
                    System.out.println("4.Todos");
                    int tipoListar = entrada.nextInt();
                    entrada.nextLine();

                    switch (tipoListar){
                        case 1:
                            System.out.println("Listando todos los libros: ");
                            for (Multimedia m : listaMultimedia){
                                if (m instanceof Libro){
                                    m.mostrarDatos();
                                    System.out.println();
                                }
                            }

                            break;

                        case 2:
                            System.out.println("Listando todos los audios: ");
                            for (Multimedia m : listaMultimedia){
                                if (m instanceof Audio) {
                                    m.mostrarDatos();
                                    System.out.println();
                                }
                            }

                            break;

                        case 3:
                            System.out.println("Listando todos los videos: ");
                            for (Multimedia m : listaMultimedia) {
                                if(m instanceof Video) {
                                    m.mostrarDatos();
                                    System.out.println();
                                }
                            }
                            break;

                        case 4:
                            System.out.println("Listando todos los archivos multimedia: ");
                            for (Multimedia m : listaMultimedia){
                                m.mostrarDatos();
                                System.out.println();
                            }
                            break;
                        default:
                            System.out.println("Opción no valida ");
                    }
                        break;
                case 4:
                    entrada.nextLine();
                    System.out.println("Digite el nombre del autor: ");
                    String autorBuscar = entrada.nextLine();

                    for (Multimedia m : listaMultimedia){
                        if (m instanceof Libro){
                            if(Objects.equals(m.getAutor(), autorBuscar)) {
                                m.mostrarDatos();
                                System.out.println();
                            }
                        }
                    }
                    break;

                case 5:
                    entrada.nextLine();
                    System.out.println("Digite el nombre del actor a buscar: ");
                    String actorBuscar = entrada.nextLine();

                    boolean encontradoActor = false;

                    for (Multimedia m : listaMultimedia){
                        if (m instanceof Video){
                          Video v = (Video) m;

                          for (Actor a : v.getActores()){
                              if (Objects.equals(a.getNombre(), actorBuscar)){
                                  v.mostrarDatos();
                                  encontradoActor = true;
                              }
                          }
                        }
                    }

                    if(!encontradoActor){
                        System.out.println("No se encontraron videos con ese actor: ");
                    }
                    break;

                case 6:
                    entrada.nextLine();
                    System.out.println("Digite el nombre del Director a buscar: ");
                    String directorBuscar = entrada.nextLine();

                    for (Multimedia m : listaMultimedia){
                        if (m instanceof Video){
                            Video v = (Video) m;
                            Director d = v.getDirector();
                            if(Objects.equals(d.getNombre(), directorBuscar)){
                                v.mostrarDatos();
                            }
                        }
                    }
                    break;

                case 7:
                    System.out.println("Saliendo.....");
                    break;

                default:
                    System.out.println("Opción no valida: ");
            }
        }while (eleccion!=7);


    }
}
