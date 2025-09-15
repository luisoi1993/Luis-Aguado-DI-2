package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Realizar un menú con 4 posibilidades, donde cada vez
        que se pulse una opción aparezca el mensaje "Pulsada la opción 1".
        Tras mostrar el mensaje se volverá a mostrar el menú con su
        correspondiente ejecución. La 4 posibilidad parará la ejecución
        con el mensaje "saliendo ...". En el caso de introducir un número
        que no esté entre 1 y 4 aparecerá el mensaje "número no contemplado"*/
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elige una opcion: " +
                    "\n1: opción 1: " +
                    "\n2: opción 2:" +
                    "\n3: opción 3:" +
                    "\n4. Salir");
            opcion = entrada.nextInt();
            if(opcion > 0 && opcion < 4){
                System.out.println("Puldada la opción "+ opcion);
            } else if (opcion == 4) {
                System.out.println("Saliendo ...");
            }
            else {
                System.out.println("Número no contemplado: ");
            }
        }while (opcion != 4);
    }
}