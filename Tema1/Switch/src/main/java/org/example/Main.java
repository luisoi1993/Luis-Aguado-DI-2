package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Ingresa un carácter y determina si es vocal o consonante usando switch.*/


        System.out.println("Digite un caracter: ");
        char vocalConsonante = entrada.next().toLowerCase().charAt(0);

        switch (vocalConsonante){
            case 'a' , 'e', 'i' , 'o', 'u' :
                System.out.println("Vocal");
                break;
            default:
                System.out.println(Character.isLetter(vocalConsonante)?"Consonante":"No es una letra");
        }

        /*Recibe un entero y determina si es par o impar usando switch.*/

        System.out.println("Digite un numero: ");
        int parImpar = entrada.nextInt();

        switch (Math.abs(parImpar) % 2){
            case 0:
                System.out.println("El numero es par");
                break;

            default:
                System.out.println("El numero es impar: ");
        }

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

        /*Lee un código de producto y muestra nombre y precio con switch.*/

        System.out.println("Digite el codigo del producto: ");
        String codigo = entrada.nextLine();
        codigo = codigo.toUpperCase();

        switch (codigo) {
            case "P001":
                System.out.println("Producto: Lápiz, Precio: 0.50eur");
                break;

            case "P002":
                System.out.println("Producto: Boli, precio 1eur");
                break;

            case "P003":
                System.out.println("Producto: Typex, precio 1.50eur");
                break;

            default:
                System.out.println("El codigo no existe: ");
        }

    }
}