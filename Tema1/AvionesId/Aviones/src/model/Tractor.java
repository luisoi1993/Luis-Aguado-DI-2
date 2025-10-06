package model;

public class Tractor extends Vehiculo{
    int capcidadMaletas;

    public Tractor(String matricula, String modelo, int capcidadMaletas) {
        super(matricula, modelo);
        this.capcidadMaletas = capcidadMaletas;
    }

    public int getCapcidadMaletas() {
        return capcidadMaletas;
    }

    public void setCapcidadMaletas(int capcidadMaletas) {
        this.capcidadMaletas = capcidadMaletas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("La capacidad de maletas es" + capcidadMaletas);
    }

    @Override
    public String toString() {
        return "Tractor{" +
                "capcidadMaletas=" + capcidadMaletas +
                "} " + super.toString();
    }
}
