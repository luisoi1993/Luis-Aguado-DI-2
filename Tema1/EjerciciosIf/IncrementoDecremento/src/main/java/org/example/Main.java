package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Lee un entero. Si es par, incrementa en 1; si es impar,
        decrementa en 1. Muestra el nuevo valor.*/
        System.out.println("Digite un numero para increnmentar o decrementar: ");
        int parOImpar = entrada.nextInt();
        if( parOImpar % 2 == 0){
            parOImpar++;
        }else {
            parOImpar--;
        }
        System.out.println(parOImpar);
    }
}