package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
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