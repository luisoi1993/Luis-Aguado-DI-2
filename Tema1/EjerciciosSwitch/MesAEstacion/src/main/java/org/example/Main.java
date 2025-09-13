package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Pide un número 1-12 y muestra la estación correspondiente con switch.*/

        System.out.println("Digite el numero del mes 1-12: ");
        int mes = entrada.nextInt();

        switch (mes){
            case 12:
            case 1:
            case 2:
                System.out.println("Es diciembre: ");
                break;

            case 3:
            case 4:
            case 5:
                System.out.println("Es primavera: ");
                break;

            case 6:
            case 7:
            case 8:
                System.out.println("Es verano: ");
                break;

            case 9:
            case 10:
            case 11:
                System.out.println("Es otoño: ");
                break;

            default:
                System.out.println("El numero de mes es incorrecto: ");
        }

    }
}