package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Realiza un programa que lee enteros pares hasta introducir
        un impar. El programa cuenta el número de positivos de los
        números leído y lo mostrará cuando se introduzca un impar*/
        Scanner entrada = new Scanner(System.in);
        int positivos = 0;
        int numero;
        do{
            System.out.println("Digite un número: ");
            numero = entrada.nextInt();
            if (numero > 0 ){
                positivos++;
            }
        }while (numero % 2 == 0);

        System.out.println("El número de positivos es: " + positivos);
    }
}