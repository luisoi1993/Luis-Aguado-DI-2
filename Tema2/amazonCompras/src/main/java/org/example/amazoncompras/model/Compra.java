package org.example.amazoncompras.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
    private String producto;
    private String categoria;
    private Double precio;

    @Override
    public String toString() {
        return producto + " " + precio;
    }
}
