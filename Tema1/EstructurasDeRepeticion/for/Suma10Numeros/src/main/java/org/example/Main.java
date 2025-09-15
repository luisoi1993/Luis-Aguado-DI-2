package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Realizar un programa que lea por teclado 10 números y los sume.
        Al final del proceso mostrará la suma total*/
        Scanner entrada = new Scanner(System.in);
        int suma = 0;
        for(int i = 1; i < 11; i++){
            System.out.println("Digite el número para sumar nº " + i);
            int numeroSuma = entrada.nextInt();
            suma = suma + numeroSuma;
        }
        System.out.println("La suma total de los 10 numeros es: "+ suma);
    }
}