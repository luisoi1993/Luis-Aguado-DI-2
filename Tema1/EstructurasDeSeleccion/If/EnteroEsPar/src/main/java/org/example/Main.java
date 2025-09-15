package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Pedir por teclado un entero y guardarlo en una
        variable llamada a. Comprobar si “a” es par. De serlo,
        se almacena en la cadena “s” el texto “Es par”. Al
        final del bloque mostrar el mensaje por pantalla*/
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite un numero entero: ");
        int a = entrada.nextInt();
        String s = "";

        if(a % 2 == 0){
            s = "Es par";
        }
        System.out.println(s);
    }
}