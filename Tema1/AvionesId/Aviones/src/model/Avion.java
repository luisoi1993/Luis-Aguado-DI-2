package model;

public class Avion extends Vehiculo{
    private int capacidadCombustible,capacidadPasajeros;

    public Avion(String matricula, String modelo, int capacidadCombustible, int capacidadPasajeros) {
        super(matricula, modelo);
        this.capacidadCombustible = capacidadCombustible;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(int capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("La capacidad de combustible es: " + capacidadCombustible);
        System.out.println("La capicidad de pasajeros es: " + capacidadPasajeros);
    }

    @Override
    public String toString() {
        return "Avion{" +
                "capacidadCombustible=" + capacidadCombustible +
                ", capacidadPasajeros=" + capacidadPasajeros +
                "} " + super.toString();
    }
}
