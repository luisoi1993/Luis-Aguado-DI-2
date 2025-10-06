package model;

public enum Franja {
    UNO (1),
    DOS (2),
    TRES (3);

    private final int valor;

    Franja(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
