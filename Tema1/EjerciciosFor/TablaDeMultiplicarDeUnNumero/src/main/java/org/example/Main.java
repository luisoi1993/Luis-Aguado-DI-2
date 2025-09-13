package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Lee un número 0-10 y muestra su tabla del 0 al 10.*/
        System.out.println("Digite un número de 0 a 10");
        int numeroMultiplicacion = entrada.nextInt();

        if(numeroMultiplicacion > -1 && numeroMultiplicacion < 11){
            for (int i = 1; i<= 10; i++){
                System.out.println(numeroMultiplicacion +" x " + i + " = " + i*numeroMultiplicacion);
            }
        }
        else{
            System.out.println("No dijitaste un número entre 0 y 10");
        }
    }
}