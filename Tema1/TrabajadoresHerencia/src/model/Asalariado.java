package model;

public class Asalariado extends Trabajador {
    private double sueldo;
    private int numeroPagas;
    private Boolean contratado;

    public Asalariado(String nombre, String apellido, String dni, double sueldo, int numeroPagas, Boolean contratado) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
        this.numeroPagas = numeroPagas;
        this.contratado = contratado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getNumeroPagas() {
        return numeroPagas;
    }

    public void setNumeroPagas(int numeroPagas) {
        this.numeroPagas = numeroPagas;
    }

    public Boolean getContratado() {
        return contratado;
    }

    public void setContratado(Boolean contratado) {
        this.contratado = contratado;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("El sueldo es "+ sueldo);
        System.out.println("EL numero de pagas es " + numeroPagas);
        System.out.println("Esta contratado: " + contratado);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
