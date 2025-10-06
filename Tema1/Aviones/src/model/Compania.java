package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Compania {
    Scanner entrada = new Scanner(System.in);
    List<Vehiculo> vehiculos = new ArrayList<>();
    List<Vuelo> vuelos = new ArrayList<>();

    public void agregarAvion(Avion avion){
        vehiculos.add(avion);
    }

    public void agregarTractor(Tractor tractor){
        vehiculos.add(tractor);
    }

    public void agregarVuelo(){
        System.out.println("Digite los datos para agregar el vuelo: ");
        System.out.println("Digite el origen");
        String origen = entrada.nextLine();
        System.out.println("Digite el destino");
        String destino = entrada.nextLine();
        System.out.println("Digite el número de pasajeros: ");
        int numeroPasajeros = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite el numero de kilometros del vuelo: ");
        int kilometros = entrada.nextInt();
        entrada.nextLine();
        Avion a1 = null;
        Tractor t1 = null;
        boolean avionDisponible = false;
        boolean tractorDisponible = false;
        for (Vehiculo vehiculo: vehiculos){
            if(vehiculo instanceof Avion){
                if (vehiculo.isDisponible()){
                    a1 =(Avion) vehiculo;
                    avionDisponible = true;

                }
            }
            if (vehiculo instanceof Tractor){
                if(vehiculo.isDisponible()){
                    t1 = (Tractor) vehiculo;
                    tractorDisponible = true;

                }
            }

            if(avionDisponible == true && tractorDisponible == true){
                break;
            }

        }

        if(avionDisponible == true && tractorDisponible == true){
            Vuelo v1 = new Vuelo(origen,destino,numeroPasajeros,kilometros,a1,t1);
            vuelos.add(v1);
            t1.setDisponible(false);
            a1.setDisponible(false);
            System.out.println("Vuelo agregado correctamente");
        }
        else {
            System.out.println("No hay aviones o tractores disponibles");
        }
    }

    public void mostrarVehiculos(){
        for (Vehiculo vehiculo: vehiculos){
            vehiculo.mostrarDatos();
        }
    }

    public void listarVuelos(){
        for(Vuelo vuelo: vuelos){
            vuelo.mostrarDatos();
        }
    }

    public void listarVuelosPorAvion(String matricula){
        for (Vuelo vuelo: vuelos){
            if (Objects.equals(vuelo.getAvion().getMatricula(), matricula)){
                vuelo.mostrarDatos();
            }
        }
    }

    public void cancelarVuelo(int id){

    }

}
