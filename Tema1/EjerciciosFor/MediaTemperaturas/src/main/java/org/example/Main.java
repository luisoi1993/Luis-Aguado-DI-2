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
    }
}