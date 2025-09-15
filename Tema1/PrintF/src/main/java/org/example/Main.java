package org.example;


public class Main {
    public static void main(String[] args) {
        // ========================
        // 🎯 1. CADENAS DE TEXTO
        // ========================
        String nombre = "Luis";
        System.out.printf("Hola %s%n", nombre);
        // %s = sustituye por una cadena de texto
        // %n = salto de línea (igual que \n, pero más "estándar")

        // ========================
        // 🎯 2. ENTEROS
        // ========================
        int edad = 25;
        System.out.printf("Tengo %d años%n", edad);
        // %d = números enteros

        // Ancho mínimo de 5 espacios
        System.out.printf("|%5d|%n", edad);   // |   25|
        System.out.printf("|%-5d|%n", edad);  // |25   | (alineado a la izquierda)

        // ========================
        // 🎯 3. NÚMEROS DECIMALES
        // ========================
        double pi = 3.14159265359;

        // Mostrar con 2 decimales
        System.out.printf("PI con 2 decimales: %.2f%n", pi);

        // Mostrar con 4 decimales
        System.out.printf("PI con 4 decimales: %.4f%n", pi);

        // Ancho + decimales (total 10 espacios, 3 decimales)
        System.out.printf("PI formateado: %10.3f%n", pi);
        // Ejemplo salida: "     3.142"

        // ========================
        // 🎯 4. CARACTERES
        // ========================
        char letra = 'A';
        System.out.printf("La primera letra es %c%n", letra);
        // %c = imprime un carácter

        // ========================
        // 🎯 5. BOOLEANOS
        // ========================
        boolean activo = true;
        System.out.printf("¿Activo? %b%n", activo);
        // %b = imprime true o false

        // ========================
        // 🎯 6. VARIOS VALORES
        // ========================
        System.out.printf("Me llamo %s, tengo %d años y PI vale %.2f%n", nombre, edad, pi);

        // ========================
        // 🎯 7. PORCENTAJE LITERAL
        // ========================
        double porcentaje = 85.5;
        System.out.printf("El resultado es %.1f%%%n", porcentaje);
        // Para imprimir un "%" se usa "%%"

        // ========================
        // 🎯 8. NÚMEROS EN DISTINTOS FORMATOS
        // ========================
        int numero = 255;

        // Hexadecimal
        System.out.printf("Hexadecimal: %x%n", numero);  // ff
        System.out.printf("Hexadecimal (MAY): %X%n", numero); // FF

        // Octal
        System.out.printf("Octal: %o%n", numero);  // 377

        // ========================
        // 🎯 9. FORMATO CON CEROS A LA IZQUIERDA
        // ========================
        System.out.printf("Número con ceros: %05d%n", 42);
        // 00042 (total 5 posiciones)

        // ========================
        // 🎯 10. NOTACIÓN CIENTÍFICA
        // ========================
        double grande = 12345.6789;
        System.out.printf("Notación científica: %e%n", grande);
        // 1.234568e+04

        System.out.printf("Notación científica (MAY): %E%n", grande);
        // 1.234568E+04

        // ========================
        // 🎯 11. TEXTO Y FORMATO ALINEADO
        // ========================
        System.out.printf("|%-10s|%-10s|%-10s|%n", "Nombre", "Edad", "Ciudad");
        System.out.printf("|%-10s|%-10d|%-10s|%n", "Luis", 25, "Madrid");
        System.out.printf("|%-10s|%-10d|%-10s|%n", "Ana", 30, "Sevilla");
        // %-10s = texto con ancho 10, alineado a la izquierda
        // %-10d = número con ancho 10, alineado a la izquierda

        // ========================
        // 🎯 12. AGRUPANDO NÚMEROS GRANDES
        // ========================
        int miles = 1234567;
        System.out.printf("Número con separador: %,d%n", miles);
        // Dependiendo del idioma puede salir: 1,234,567 (en-US) o 1.234.567 (es-ES)

    }
}
