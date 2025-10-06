package model;

public abstract class Llamada {
    private int nOrigen, nDestino , duracion;
    private double coste;

    public Llamada(int nOrigen, int nDestino, int duracion, double coste) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
        this.coste = coste;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getnOrigen() {
        return nOrigen;
    }

    public void setnOrigen(int nOrigen) {
        this.nOrigen = nOrigen;
    }

    public int getnDestino() {
        return nDestino;
    }

    public void setnDestino(int nDestino) {
        this.nDestino = nDestino;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public void mostrarDatos(){
        System.out.println("EL numero de origen es: " + nOrigen);
        System.out.println("El numero de destino es: " + nDestino);
        System.out.println("La duración es: " + duracion);
        System.out.println("El coste es " + coste);
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "nOrigen=" + nOrigen +
                ", nDestino=" + nDestino +
                ", duracion=" + duracion +
                ", coste=" + coste +
                '}';
    }
}
