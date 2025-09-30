package model;

import java.util.ArrayList;

public class Lista implements ElementoPlanificador {
    private int id;
    private ArrayList<String> elementos;
    private boolean completada;

    public Lista(int id) {
        this.id = id;
        this.elementos = new ArrayList<>();
        this.completada = false;
    }

    public void agregarElemento(String item) {
        elementos.add(item);
    }

    public void mostrarLista() {
        System.out.println("Lista ID " + id);
        for (String item : elementos) {
            System.out.println("- " + item);
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitulo() {
        return "Lista con " + elementos.size() + " elementos";
    }

    @Override
    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "id=" + id +
                ", elementos=" + elementos +
                ", completada=" + completada +
                '}';
    }
}
