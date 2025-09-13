package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        /*Lee un entero y comprueba si es múltiplo de 20 y si está entre -100 y
        100. Muestra uno de los cuatro mensajes posibles.*/

        System.out.println("Digite un numero: ");
        int numero3 = entrada.nextInt();

        if(numero3 % 20 == 0 && numero3 > -101 && numero3 < 101) {
            System.out.println("Es multiplo de 20 y está entre -100 y 100");
        } else if (numero3 % 20 != 0 && numero3 > -101 && numero3 < 101) {
            System.out.println( "No Es multiplo de 20 y está entre -100 y 100");
        } else if (numero3 % 20 ==0 ) {
            System.out.println(" Es multiplo de 20 y no está entre -100 y 100");
        }else {
            System.out.println(" No Es multiplo de 20 y no está entre -100 y 100");
        }
    }
}