package org.example.examen2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Dato {
    private int id_pedido;
    private String nombreCliente;
    private int telefono;
    private int id_pizza;
    private boolean entregado;

    public Pedido(String nombreCliente, int telefono, int id_pizza, boolean entregado) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.id_pizza = id_pizza;
        this.entregado = entregado;
    }


    @Override
    public String toString(){
        return id_pedido+" - "+nombreCliente+ " - "+id_pizza;
    }
}
