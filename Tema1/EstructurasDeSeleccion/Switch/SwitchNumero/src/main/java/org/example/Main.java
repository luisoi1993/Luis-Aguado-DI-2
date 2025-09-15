package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*1. Pedir por teclado un valor que será guardado en una variable llamada "a.
         Comprobar los siguientes casos:
    1. Si el número introducido es 1 imprimir el mensaje "Número 1"
    2. Si el número introducido es 2 imprimir el mensaje "Número 2"
    3. Si el número introducido es 3 imprimir el mensaje "Número 3"
    4. Si el número introducido es 4 imprimir el mensaje "Número 4"
    5. Si el número introducido es diferente el mensaje "Número desconocido"*/
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite un número entero: ");
        int a = entrada.nextInt();

        switch (a){
            case 1 :
                System.out.println("Número 1");
                break;

            case 2:
                System.out.println("Número 2");
                break;

            case 3:
                System.out.println("Número 3");
                break;

            case 4:
                System.out.println("Número 4");
                break;

            default:
                System.out.println("Número desconocido");
        }

    }
}