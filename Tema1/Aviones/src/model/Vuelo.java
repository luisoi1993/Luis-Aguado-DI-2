package model;

public class Vuelo {
    private String origen, destino;
    private int pasajeros, numeroKm;
    private Avion avion;
    private Tractor tractor;

    public Vuelo(String origen, String destino, int pasajeros, int numeroKm, Avion avion, Tractor tractor) {
        this.origen = origen;
        this.destino = destino;
        this.pasajeros = pasajeros;
        this.numeroKm = numeroKm;
        this.avion = avion;
        this.tractor = tractor;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getNumeroKm() {
        return numeroKm;
    }

    public void setNumeroKm(int numeroKm) {
        this.numeroKm = numeroKm;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Tractor getTractor() {
        return tractor;
    }

    public void setTractor(Tractor tractor) {
        this.tractor = tractor;
    }
    public void mostrarDatos(){
        System.out.println("El origen es : " + origen);
        System.out.println("El destino es " + destino);
        System.out.println("El numero de pasajeros es " + pasajeros);
        System.out.println("El numero de kilometros " + numeroKm);
        System.out.println("El avion asignado es " );
        avion.mostrarDatos();
        System.out.println("El tractor asignado es ");
        tractor.mostrarDatos();
    }
    @Override
    public String toString() {
        return "Vuelo{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", pasajeros=" + pasajeros +
                ", numeroKm=" + numeroKm +
                ", avion=" + avion +
                ", tractor=" + tractor +
                '}';
    }
}
