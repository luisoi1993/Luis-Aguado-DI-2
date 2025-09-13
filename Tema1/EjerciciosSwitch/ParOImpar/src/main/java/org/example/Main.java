package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Recibe un entero y determina si es par o impar usando switch.*/

        System.out.println("Digite un numero: ");
        int parImpar = entrada.nextInt();

        switch (Math.abs(parImpar) % 2){
            case 0:
                System.out.println("El numero es par");
                break;

            default:
                System.out.println("El numero es impar: ");
        }
    }
}