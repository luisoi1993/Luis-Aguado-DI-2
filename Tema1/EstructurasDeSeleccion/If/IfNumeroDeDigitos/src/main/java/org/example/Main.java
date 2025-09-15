package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*3. Pedir por teclado un entero y guardarlo en una variable llamada a.
         Comprobar los siguientes casos:
         1. Si es menor que 10 imprimir:
            1. Si es menor que 0 imprimir el mensaje "negativo"
            2. Si es menor que 10 imprimir el mensaje "un dígito"
        2. Si es menor que 99 imprimir el mensaje "dos dígitos"
        3. Si es mayor que 99 imprimir el mensaje "tres dígitos"*/
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite un número entero: ");
        int a = entrada.nextInt();

        if(a < 10){
            if (a < 0){
                System.out.println("negativo");
            }
            else {
                System.out.println("un dígito");
            }
        } else if (a <= 99) {
            System.out.println("dos dígitos");
        } else {
            System.out.println("tres dígitos");
        }

    }
}