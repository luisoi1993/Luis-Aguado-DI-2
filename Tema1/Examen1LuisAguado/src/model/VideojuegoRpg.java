package model;

public class VideojuegoRpg extends Videojuego{
    private boolean mundoAbierto;
    private int horasHistoriaPrincipal;

    public VideojuegoRpg(String titulo, String desarollador, int anioLanzamiento, Double precio, String clasificacionEdad, boolean mundoAbierto, int horasHistoriaPrincipal) {
        super(titulo, desarollador, anioLanzamiento, precio, clasificacionEdad);
        this.mundoAbierto = mundoAbierto;
        this.horasHistoriaPrincipal = horasHistoriaPrincipal;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioTotal = getPrecio();
        double precioPorcentaje = 0;
        double precioFinal = 0;

        if (mundoAbierto){
            precioPorcentaje = precioTotal * 15 / 100;
            precioFinal = precioFinal + precioPorcentaje;
        }

        for (int i = 0; i < horasHistoriaPrincipal;i = i + 10){
            precioPorcentaje = precioTotal * 2 / 100;
            precioFinal = precioFinal + precioPorcentaje;
        }
        precioFinal = precioFinal + precioTotal;
        return precioFinal;
    }

    public boolean isMundoAbierto() {
        return mundoAbierto;
    }

    public void setMundoAbierto(boolean mundoAbierto) {
        this.mundoAbierto = mundoAbierto;
    }

    public int getHorasHistoriaPrincipal() {
        return horasHistoriaPrincipal;
    }

    public void setHorasHistoriaPrincipal(int horasHistoriaPrincipal) {
        this.horasHistoriaPrincipal = horasHistoriaPrincipal;
    }

    @Override
    public String toString() {
        return "VideojuegoRpg{" +
                "mundoAbierto=" + mundoAbierto +
                ", horasHistoriaPrincipal=" + horasHistoriaPrincipal +
                "} " + super.toString();
    }
}
