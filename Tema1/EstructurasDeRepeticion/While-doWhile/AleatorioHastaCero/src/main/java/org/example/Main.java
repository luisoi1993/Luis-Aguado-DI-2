package org.example;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       /*Generar números aleatorios entre 0 y 1000 hasta obtener un
       cero (momento en el cual el programa terminará), y contabilizar
       cuántos de ellos son pares. Al final del programa se mostrará
       cuantos pares se han obtenido*/
        Random random = new Random();
        int numero, pares = 0;

        do {
            numero = random.nextInt(1001);
            System.out.println(numero);
            if(numero % 2 == 0){
                pares++;
            }
        }while (numero != 0);
        System.out.println("El número de pares es: " + pares);
    }
}