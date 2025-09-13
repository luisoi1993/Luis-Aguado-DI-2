package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Pide un operador (+, -, *, /) y dos números; realiza
         la operación con switch.*/

        System.out.println("Digite la operación a realizar: (+, - , * , / )");
        char operador = entrada.next().charAt(0);
        System.out.println("Digite el primer número para la operación: ");
        float num1 = entrada.nextFloat();
        System.out.println("Digite el segundo número para la operación: ");
        float num2 = entrada.nextFloat();
        float operacion;

        switch (operador) {
            case '+':
                operacion = num1 + num2;
                System.out.println("El resultado de la suma es: " + operacion);
                break;
            case '-':
                operacion = num1 - num2;
                System.out.println("El resultado de la resta es: " + operacion);
                break;
            case '*':
                operacion = num1 * num2;
                System.out.println("El resultado de la mutiplicación es: "+ operacion);
                break;
            case '/' :
                if (num2 != 0){
                    operacion = num1 / num2;
                    System.out.println("El resultado de la división es: " + operacion);
                    break;
                }
                else {
                    System.out.println("No se puede dividir por 0: ");
                    break;
                }

            default:
                System.out.println("Escribiste algo mal: ");
        }
    }
}