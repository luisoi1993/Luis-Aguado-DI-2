package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        /*### 1) Comparar dos enteros

    **Enunciado**

    Lee dos enteros y muestra si el primero es mayor que el segundo.

    **Ejemplo E/S***/

        System.out.println("Digite el primer numero");
        int numero1 = entrada.nextInt();
        System.out.println("Digte el segundo numero");
        int numero2 = entrada.nextInt();

        if(numero1 > numero2) {
            System.out.println("El numero " + numero1 + " es mayor que el numero " + numero2);
        } else if (numero2 > numero1) {
            System.out.println("El numero " + numero2 + " es mayor que el numero " + numero1);

        } else {
            System.out.println("Lo numeros son iguales");
        }
    }
}