package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*Lee el número de temperaturas (si <= 0, usar 10). Calcula la media con dos decimales.*/

        System.out.println("Digite el numero de temperaturas de las que quieres sacar la media: ");
        int numeroTemperaturas = entrada.nextInt();
        if(numeroTemperaturas <= 0){
            numeroTemperaturas = 10;
        }

        float sumaTemperaturas = 0;

        for (int i = 0; i<numeroTemperaturas;i++){
            System.out.println("Digite la temperatura nº " + (i+1));
            float temperaturaTemporal = entrada.nextFloat();
            sumaTemperaturas = sumaTemperaturas + temperaturaTemporal;
        }

        float temperaturaMedia = sumaTemperaturas / numeroTemperaturas;
        System.out.printf("La temperatura media es : %.2f%n" , temperaturaMedia);

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

        /*Muestra las tablas de multiplicar de 0 a 10.*/

        int multiplicacion = 0;

        for(int i = 0; i<11; i++){
            for(int j = 0; j<11; j++){
                System.out.println(multiplicacion + " x " + j +" = "+ multiplicacion*j);

            }
            multiplicacion++;
        }

        /*Pide un rango [a, b] y muestra las tablas de a a b.*/

        System.out.println("Digite el valor del rango bajo de las tablas :");
        int rangoBajo = entrada.nextInt();
        System.out.println("Digite el valor del rango alto de las tablas: ");
        int rangoAlto = entrada.nextInt();

        for (int i =rangoBajo; i<=rangoAlto;i++){
            for (int j=0;j<11;j++){
                System.out.println(i + " x " + j + " = " + j*i);
            }
        }

    }



}