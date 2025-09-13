package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Pide un rango [a, b] y muestra las tablas de a a b.*/

        System.out.println("Digite el valor del rango bajo de las tablas :");
        int rangoBajo = entrada.nextInt();
        System.out.println("Digite el valor del rango alto de las tablas: ");
        int rangoAlto = entrada.nextInt();

        for (int i =rangoBajo; i<=rangoAlto;i++){
            for (int j=0;j<11;j++){
                System.out.println(i + " x " + j + " = " + j*i);
            }
        }
    }
}