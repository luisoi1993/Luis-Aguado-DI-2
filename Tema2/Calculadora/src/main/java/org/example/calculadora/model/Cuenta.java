package org.example.calculadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {
    private String expresion;
    private double resultado;

    @Override
    public String toString() {
        return expresion + " = " + resultado;
    }
}
