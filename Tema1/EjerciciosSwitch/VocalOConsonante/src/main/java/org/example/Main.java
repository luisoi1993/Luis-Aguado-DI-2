package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /*Ingresa un carácter y determina si es vocal o consonante usando switch.*/
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite un caracter: ");
        char vocalConsonante = entrada.next().toLowerCase().charAt(0);

        switch (vocalConsonante){
            case 'a' , 'e', 'i' , 'o', 'u' :
                System.out.println("Vocal");
                break;
            default:
                System.out.println(Character.isLetter(vocalConsonante)?"Consonante":"No es una letra");
        }
    }
}