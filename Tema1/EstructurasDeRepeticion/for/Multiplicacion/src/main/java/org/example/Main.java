package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       /*Pedir un número por teclado. En el caso que el número introducir
       sea mayor que 10 o menor que 0 el programa parará la ejecución
       con el mensaje "dato erróneo". En caso contrario mostrará la
       tabla de multiplicar del número introducido con la siguiente
       estructura: "5 por 1 = 5" "5 por 2 = 10" ...*/
        Scanner entrada = new Scanner(System.in);

        System.out.println("De que número quieres que se haga la tabla de multiplicar: ");
        int numeroMultlipicar = entrada.nextInt();

        if(numeroMultlipicar > 10 || numeroMultlipicar < 0){
            System.out.println("Dato erróneo.");
        }
        else{
            for (int i = 1; i < 11; i++){
                System.out.println(numeroMultlipicar + " por " + i + " = " + numeroMultlipicar*i);
            }
        }
    }
}