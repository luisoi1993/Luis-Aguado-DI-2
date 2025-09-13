package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        /*Lee un entero y aplica: +2 si es par, +3 si es múltiplo de 3,
         +5 si es múltiplo de 5; si no cumple ninguna, +1.*/
        System.out.println("Digite un numero: (Incremento condiciones multiples)");
        int incremento = entrada.nextInt();
        int incremento2 = incremento;
        StringBuilder operacion = new StringBuilder(incremento + " "); // para ir guardando el proceso

        if(incremento % 2 == 0){
            incremento = incremento +2;
            operacion.append("+2 ");
        }

        if (incremento2 % 3 == 0){
            incremento = incremento +3;
            operacion.append("+3 ");
        }

        if(incremento2 % 5 == 0){
            incremento = incremento +5;
            operacion.append("+5 ");
        }

        if(incremento == incremento2){
            incremento++;
            operacion.append("+1 ");
        }

        // Mostrar resultado completo
        operacion.append("= " + incremento);
        System.out.println(operacion.toString());
    }
}