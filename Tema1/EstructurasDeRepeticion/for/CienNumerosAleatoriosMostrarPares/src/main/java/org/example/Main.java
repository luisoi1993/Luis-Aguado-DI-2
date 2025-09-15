package org.example;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Generar 100 números aleatorios entre 1 y 1000 (Math.random()*1001),
        ambos incluisve, mostrar cada número generado y contabilizar cuántos
        de ellos son pares.*/
        int cuentaPares = 0;
        Random random = new Random();

        for (int i=1;i<101;i++){
            int aleatorio = random.nextInt(1000) + 1;
            System.out.println("El número aleatorio numero " + i + " es : " + aleatorio);
            if (aleatorio % 2 == 0){
                cuentaPares++;
            }
        }
        System.out.println("EL total de números pares es: " + cuentaPares);
    }
}