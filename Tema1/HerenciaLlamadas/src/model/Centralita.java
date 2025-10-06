package model;

import java.util.ArrayList;
import java.util.List;

import static model.Franja.DOS;

public class Centralita {
    List<Llamada> listaLlamadas = new ArrayList<>();

    public void registrarLlamada(Llamada llamada){
        listaLlamadas.add(llamada);
    }

    public void mostrarDatosTodas(){
        for (Llamada llamada : listaLlamadas){
            llamada.mostrarDatos();
        }
    }

    public void calcularCoste(){
        double precio;
        for (Llamada llamada: listaLlamadas){
            if(llamada instanceof LlamadaNacional){
                switch (((LlamadaNacional) llamada).getFranja()){
                    case UNO : {
                        precio = 20 * llamada.getDuracion();
                        llamada.mostrarDatos();
                        System.out.println("El coste de la llamada es " + precio +" cent");
                        break;
                    }

                    case DOS : {
                        precio = 25 * llamada.getDuracion();
                        llamada.mostrarDatos();
                        System.out.println("El coste de la llamada es " + precio +" cent");
                        break;
                    }

                    case  TRES: {
                        precio = 30 * llamada.getDuracion();
                        llamada.mostrarDatos();
                        System.out.println("El coste de la llamada es " + precio +" cent");
                        break;
                    }
                }
            } else if (llamada instanceof LlamadaProvincial) {
                precio = 15 * llamada.getDuracion();
                llamada.mostrarDatos();
                System.out.println("El coste de la llamada es " + precio +" cent");

            }else {
                llamada.mostrarDatos();
                System.out.println("El coste de la llamada es  0 cent" );
            }
        }
    }
}
