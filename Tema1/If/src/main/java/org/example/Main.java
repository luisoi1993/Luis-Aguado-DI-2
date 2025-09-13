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

        if (numero1 > numero2) {
            System.out.println("El numero " + numero1 + "es mayor que el numero " + numero2);
        } else if (numero2 > numero1) {
            System.out.println("El numero " + numero2 + "es mayor que el numero " + numero1);

        } else {
            System.out.println("Lo numeros son iguales");
        }

        /*Lee un entero y comprueba si es múltiplo de 20 y si está entre -100 y
        100. Muestra uno de los cuatro mensajes posibles.*/

        System.out.println("Digite un numero: ");
        int numero3 = entrada.nextInt();

        if (numero3 % 20 == 0 && numero3 > -101 && numero3 < 101) {
            System.out.println("Es multiplo de 20 y está entre -100 y 100");
        } else if (numero3 % 20 != 0 && numero3 > -101 && numero3 < 101) {
            System.out.println("No Es multiplo de 20 y está entre -100 y 100");
        } else if (numero3 % 20 == 0) {
            System.out.println(" Es multiplo de 20 y no está entre -100 y 100");
        } else {
            System.out.println(" No Es multiplo de 20 y no está entre -100 y 100");
        }

        /*Determina si un número natural de 4 dígitos es capicúa.
        Si no tiene 4 dígitos, indícalo.*/
        System.out.println("Digite un numero de 4 cifras: ");
        int capicua = entrada.nextInt();
        if (capicua < 1000 || capicua > 9999) {
            System.out.println("El numero no tiene 4 cifras: ");
            return;
        }
        int u = capicua % 10, d = (capicua / 10) % 10, c = (capicua / 100) % 10, m = (capicua / 1000) % 10;
        if (u == m && d == c) System.out.println("Es capicua");
        else System.out.println("No es capicua");

         /*Lee un entero. Si es par, incrementa en 1; si es impar,
        decrementa en 1. Muestra el nuevo valor.*/
        System.out.println("Digite un numero para increnmentar o decrementar: ");
        int parOImpar = entrada.nextInt();
        if (parOImpar % 2 == 0) {
            parOImpar++;
        } else {
            parOImpar--;
        }
        System.out.println(parOImpar);

        /*Lee un entero y aplica: +2 si es par, +3 si es múltiplo de 3,
         +5 si es múltiplo de 5; si no cumple ninguna, +1.*/
        System.out.println("Digite un numero: (Incremento condiciones multiples)");
        int incremento = entrada.nextInt();
        int incremento2 = incremento;
        StringBuilder operacion = new StringBuilder(incremento + " "); // para ir guardando el proceso

        if (incremento % 2 == 0) {
            incremento = incremento + 2;
            operacion.append("+2 ");
        }

        if (incremento2 % 3 == 0) {
            incremento = incremento + 3;
            operacion.append("+3 ");
        }

        if (incremento2 % 5 == 0) {
            incremento = incremento + 5;
            operacion.append("+5 ");
        }

        if (incremento == incremento2) {
            incremento++;
            operacion.append("+1 ");
        }

        // Mostrar resultado completo
        operacion.append("= " + incremento);
        System.out.println(operacion.toString());

        /*Pide día, mes y año e indica si la fecha es correcta
        considerando meses de 28, 30 y 31 días. Sin años bisiestos.*/
        /*
        System.out.println("Digite el numero del dia: ");
        int dia = entrada.nextInt();
        System.out.println("Digite el numero de mes: ");
        int mes = entrada.nextInt();
        System.out.println("Digite el numero del año: ");
        int anio = entrada.nextInt();
        String fecha = dia + "/" + mes + "/" + anio;

        if (mes < 13 && mes > 0) {
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                if (dia > 0 && dia < 32) {
                    System.out.println("La fecha es correcta " + fecha);
                } else {
                    System.out.println("La fecha es incorrecta " + fecha);
                }
            }
            if (mes == 2) {
                if (dia > 0 && dia < 29) {
                    System.out.println("La fecha es correcta " + fecha);
                } else {
                    System.out.println("La fecha es incorrecta " + fecha);
                }
            }
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                if (dia > 0 && dia < 31) {
                    System.out.println("La fecha es correcta " + fecha);
                } else {
                    System.out.println("La fecha es incorrecta " + fecha);
                }
            }
        } else {
            System.out.println("La fecha es incorrecta " + fecha);
        } */

        /*Pide día, mes y año e indica si la fecha es correcta
        considerando meses de 28, 30 y 31 días. Sin años bisiestos.*/
        System.out.println("Digite el numero del dia: ");
        int dia = entrada.nextInt();
        System.out.println("Digite el numero de mes: ");
        int mes = entrada.nextInt();
        System.out.println("Digite el numero del año: ");
        int anio = entrada.nextInt();
        String fecha = dia + "/" + mes + "/" + anio;

        if(mes < 13 && mes > 0){
            if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
                if (dia > 0 && dia < 32){
                    System.out.println("La fecha es correcta " + fecha);

                    if(dia == 31){
                        dia = 1;
                        if(mes == 12){
                            mes = 1;
                            anio++;
                        }
                        else {
                            mes++;
                        }
                        fecha = dia + "/" + mes + "/" + anio;
                        System.out.println("La nueva fecha es: " + fecha);
                    }
                }
                else {
                    System.out.println("La fecha es incorrecta " + fecha);
                }
            }
            if (mes == 2){
                if (dia > 0 && dia < 29){
                    System.out.println("La fecha es correcta " + fecha);
                    if (dia == 28){
                        dia = 1;
                        mes++;
                    }
                    else {
                        dia++;
                    }
                    fecha = dia + "/" + mes + "/" + anio;
                    System.out.println("La nueva fecha es: " + fecha);
                }
                else {
                    System.out.println("La fecha es incorrecta " + fecha);
                }
            }
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
                if (dia > 0 && dia < 31){
                    System.out.println("La fecha es correcta " + fecha);

                    if (dia == 30){
                        dia = 1;
                        mes++;
                    }
                    else{
                        dia++;
                    }
                    fecha = dia + "/" + mes + "/" + anio;
                    System.out.println("La nueva fecha es: " + fecha);
                }
                else {
                    System.out.println("La fecha es incorrecta " + fecha);
                }
            }
        }
        else {
            System.out.println("La fecha es incorrecta " + fecha);
        }



    }

}