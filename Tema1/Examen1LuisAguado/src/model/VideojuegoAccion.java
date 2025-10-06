package model;

public class VideojuegoAccion extends Videojuego{
    private int nivelViolencia;
    private boolean modoMultijugador;

    public VideojuegoAccion(String titulo, String desarollador, int anioLanzamiento, Double precio, String clasificacionEdad, int nivelViolencia, boolean modoMultijugador) {
        super(titulo, desarollador, anioLanzamiento, precio, clasificacionEdad);
        if (nivelViolencia < 6 && nivelViolencia > 0){
            this.nivelViolencia = nivelViolencia;
        }
        this.modoMultijugador = modoMultijugador;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioTotal = getPrecio();
        double precioNivelViolencia = 0;
        double precioMultijugador = 0;
        double precioFinal;
        if (nivelViolencia > 3){
             precioNivelViolencia = (double) (getPrecio() * 5) / 100;
        }

        if (modoMultijugador){
            precioMultijugador = (double) (getPrecio() * 10) / 100;
        }
        precioFinal = precioTotal + precioNivelViolencia + precioMultijugador;

        return precioFinal;
    }

    public int getNivelViolencia() {
        return nivelViolencia;
    }

    public void setNivelViolencia(int nivelViolencia) {
        this.nivelViolencia = nivelViolencia;
    }

    public boolean isModoMultijugador() {
        return modoMultijugador;
    }

    public void setModoMultijugador(boolean modoMultijugador) {
        this.modoMultijugador = modoMultijugador;
    }

    @Override
    public String toString() {
        return "VideojuegoAccion{" +
                "nivelViolencia=" + nivelViolencia +
                ", modoMultijugador=" + modoMultijugador +
                "} " + super.toString();
    }
}
