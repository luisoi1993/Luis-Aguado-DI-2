package model;

public class VideojuegoEstrategia extends Videojuego{
    private int complejidad, duracionPartida;

    public VideojuegoEstrategia(String titulo, String desarollador, int anioLanzamiento, Double precio, String clasificacionEdad, int complejidad, int duracionPartida) {
        super(titulo, desarollador, anioLanzamiento, precio, clasificacionEdad);
        if (complejidad < 6 && complejidad > 0){
            this.complejidad = complejidad;
        }
        this.duracionPartida = duracionPartida;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioTotal = getPrecio();
        double precioPorcentaje = 0;
        double precioFinal = 0;
        int porcentajes = complejidad;

        for (int i= 0;i < porcentajes;i++){
            precioPorcentaje = precioTotal * 3 / 100;
            precioFinal = precioFinal + precioPorcentaje;
        }
        precioFinal = precioFinal + precioTotal;
        return precioFinal;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getDuracionPartida() {
        return duracionPartida;
    }

    public void setDuracionPartida(int duracionPartida) {
        this.duracionPartida = duracionPartida;
    }

    @Override
    public String toString() {
        return "VideojuegoEstrategia{" +
                "complejidad=" + complejidad +
                ", duracionPartida=" + duracionPartida +
                "} " + super.toString();
    }
}
