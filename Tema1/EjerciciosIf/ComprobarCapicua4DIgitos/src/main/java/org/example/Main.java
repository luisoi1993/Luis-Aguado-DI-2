package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Determina si un número natural de 4 dígitos es capicúa.
        Si no tiene 4 dígitos, indícalo.*/
        System.out.println("Digite un numero de 4 cifras: ");
        int capicua = entrada.nextInt();
        if (capicua < 1000 || capicua > 9999){
            System.out.println("El numero no tiene 4 cifras: ");
            return;
        }
        int u = capicua % 10 , d = (capicua / 10) % 10 , c = (capicua / 100) % 10, m = (capicua / 1000) % 10;
        if (u == m && d == c) System.out.println("Es capicua");
        else System.out.println("No es capicua");

         
    }
}