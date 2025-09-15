package org.example;


public class Main {
   private static final float pi = 3.1416f;
    public static void main(String[] args) {
        saludar();
        saludarPersona("Luis");
        mostrarPI();
        suma(1.2f,1.3f);

    }

    /*Crea un nuevo programa que muestre ¡Hola mundo!, para la salida por consola se
    haga en un método sin datos de entrada ni salida de nombre “saludar”.*/
    public  static void saludar(){
        System.out.println("¡Hola mundo!");
    }
    /*Crea un método que se llame saludarPerso el cual admita un parámetro
    de tipo string y muestre por consola el mensaje "Hola NombreIntroducido".*/
    public static void saludarPersona(String nombre){
        System.out.println("Hola " + nombre);
    }
    /*Crea un programa en el se defina una constante global con el valor del
     número pi (3,1416) y se muestre por consola. Se definirá un método
     de nombre “mostrarPI” sin datos de entrada ni salida. (mostrarPI)*/
    public static void mostrarPI() {
        System.out.println(pi);
    }
    /*Crea un método que admita como parámetros dos números y muestre
    por consola su suma.*/
    public static void suma(float n1,float n2){
        System.out.println(n1+n2);
    }
}