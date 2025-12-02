package org.example.examen2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dato {
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private String descripcion;

    @Override
    public String toString() {

        return nombre + "- "  + " - " + precio + " euros" + categoria + " - " + descripcion;
    }
}
