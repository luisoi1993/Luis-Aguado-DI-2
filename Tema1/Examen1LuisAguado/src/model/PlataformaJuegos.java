package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlataformaJuegos {
    List<Videojuego> videojuegos = new ArrayList<>();

    public void anadirVideojuego(Videojuego videojuego){
        videojuegos.add(videojuego);
    }

    public void eliminarVideojuego(Videojuego videojuego){
        videojuegos.remove(videojuego);
    }

    // esta mal no se como eliminar el menor

    public void mostrarJuegosMayorAMenor(){
        double precioMenor;
        double precioMayor = 1000000000;
        Videojuego v1 = null;
        for (int i=0; i<videojuegos.size();i++){
            for (Videojuego videojuego: videojuegos){
              precioMenor =  videojuego.calcularPrecioFinal();
              if (precioMenor < precioMayor){
                   v1 = videojuego;

              }
                System.out.println(v1.toString());
            }

        }

    }

    public void clasificacionEdadMayores(){
        for (Videojuego videojuego: videojuegos){
            if (Objects.equals(videojuego.getClasificacionEdad(), "MAS 18")){
                System.out.println(videojuego.toString());
            }
        }
    }

    public void clasificacionEdadMenores(){
        for (Videojuego videojuego: videojuegos){
            if (Objects.equals(videojuego.getClasificacionEdad(), "TODOS LOS PUBLICOS")){
                System.out.println(videojuego.toString());
            }
        }
    }

    public void calcularSumaPrecioTodos(){
        double sumaTotal = 0;
        double precioIndividual;

        for (Videojuego videojuego: videojuegos){
            precioIndividual = videojuego.calcularPrecioFinal();
            sumaTotal = sumaTotal + precioIndividual;
        }
        System.out.println("La suma total de todos los juegos es " +sumaTotal);
    }

    public void mostrarTodosLosJuegos(){
        for (Videojuego videojuego: videojuegos){
            System.out.println(videojuego.toString());
        }
    }

    public void mostrarRpg(){
        for (Videojuego videojuego: videojuegos){
            if(videojuego instanceof VideojuegoRpg){
                System.out.println(videojuego.toString());
            }

        }
    }

    public void mostrarEstrategia(){
        for (Videojuego videojuego: videojuegos){
            if(videojuego instanceof VideojuegoEstrategia){
                System.out.println(videojuego.toString());
            }

        }
    }

    public void mostrarAccion(){
        for (Videojuego videojuego: videojuegos){
            if(videojuego instanceof VideojuegoAccion){
                System.out.println(videojuego.toString());
            }

        }
    }

    public void buscarPorNombre(String nombre){
        for (Videojuego videojuego: videojuegos){
            if(Objects.equals(nombre, videojuego.getTitulo())){
                System.out.println(videojuego.toString());
            }
        }
    }


}
