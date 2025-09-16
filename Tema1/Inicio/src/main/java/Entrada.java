import java.util.Scanner;

public class Entrada {

    // Variable

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Primer programa de repaso");
        // Variable -> Guardarel valor que sera utilizado
        final String DNI = "23424a";
        System.out.println("Introdue tu nombre");
        String nombre = lector.next();

        String correo ; // null
        System.out.println("Introduce la edad");
        int edad = lector.nextInt();

        System.out.printf("MI nombre es %s y tengo %d  años %n" , nombre , edad);



        // Array -> lista no dinamica -> final
        // Arraylist / Hastable -> lista dinamica -> final
    }
}
