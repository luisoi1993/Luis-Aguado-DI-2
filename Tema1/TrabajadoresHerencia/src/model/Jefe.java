package model;

public class Jefe extends Trabajador {
    private int acciones;
    private double beneficio;

    public Jefe(String nombre, String apellido, String dni, int acciones, double beneficio) {
        super(nombre, apellido, dni);
        this.acciones = acciones;
        this.beneficio = beneficio;
    }

    public int getAcciones() {
        return acciones;
    }

    public void setAcciones(int acciones) {
        this.acciones = acciones;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    public void despedir(Trabajador trabajador){
        if (trabajador instanceof Asalariado ){
            ((Asalariado) trabajador).setContratado(false);
        }
        if (trabajador instanceof Autonomo){
            ((Autonomo) trabajador).setContratado(false);
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("El numero de acciones :" + acciones);
        System.out.println("El beneficio es " + beneficio);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
