package model;

public class LlamadaNacional extends Llamada{
    private Franja franja;

    public LlamadaNacional(int nOrigen, int nDestino, int duracion, double coste, Franja franja) {
        super(nOrigen, nDestino, duracion, coste);
        this.franja = franja;
    }

    public Franja getFranja() {
        return franja;
    }

    public void setFranja(Franja franja) {
        this.franja = franja;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("La franja es: " + franja);
    }
}
