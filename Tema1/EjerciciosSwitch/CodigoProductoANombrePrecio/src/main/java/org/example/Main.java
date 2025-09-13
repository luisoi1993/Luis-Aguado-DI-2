package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Lee un código de producto y muestra nombre y precio con switch.*/

        System.out.println("Digite el codigo del producto: ");
        String codigo = entrada.nextLine();
        codigo = codigo.toUpperCase();

        switch (codigo) {
            case "P001":
                System.out.println("Producto: Lápiz, Precio: 0.50eur");
                break;

            case "P002":
                System.out.println("Producto: Boli, precio 1eur");
                break;

            case "P003":
                System.out.println("Producto: Typex, precio 1.50eur");
                break;

            default:
                System.out.println("El codigo no existe: ");
        }

    }
}