package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Muestra las tablas de multiplicar de 0 a 10.*/

        int multiplicacion = 0;

        for(int i = 0; i<11; i++){
            for(int j = 0; j<11; j++){
                System.out.println(multiplicacion + " x " + j +" = "+ multiplicacion*j);

            }
            multiplicacion++;
        }
    }
}