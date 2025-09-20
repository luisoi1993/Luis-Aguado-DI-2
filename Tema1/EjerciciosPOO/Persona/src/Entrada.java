import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        /*Crea una clase Entrada con main que:
        Pida por Scanner nombre, apellido, dni, edad, peso y altura
        Cree la persona asociada (p1)
        Cree una persona con un nombre y un apellido dados a mano
        Cree una persona sin datos
        Muestre los datos de todas
        Modifique la edad de todas a 20
        Entrada: "Eva", "Martín", "22222222B", 30, 55.0, 165
         Salida:
        - p1: Eva Martín (DNI: 22222222B) - Edad: 30 - Peso: 55.0 - Altura: 165
        - p2: Juan Pérez (DNI: 111111111X) - Edad: 0 - Peso: 0.0 - Altura: 0
        - p3: datos por defecto datos por defecto (DNI: 1111111111X) - Edad: 0 - Peso: 0.0 - Altura: 0
        - Tras actualizar edades: 20 en todas*/
        Scanner entrada = new Scanner(System.in);

            /*
            System.out.println("Digite el nombre: ");
            String nombre = entrada.nextLine();
            System.out.println("Digite el apellido: ");
            String apellido = entrada.nextLine();
            System.out.println("Digite el DNI: ");
            String dni = entrada.nextLine();
            System.out.println("Digite la edad: ");
            int edad = entrada.nextInt();
            System.out.println("Digite el peso: ");
            double peso = entrada.nextDouble();
            System.out.println("Digite la altura: ");
            int altura = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Digite el genero (M) o (F): ");
            char genero = entrada.nextLine().toUpperCase().charAt(0);
            Genero generoFinal;
            if (genero == 'M'){
                generoFinal = Genero.M;
            } else if (genero == 'F') {
                generoFinal = Genero.F;
            } else {
                generoFinal = null;
                System.out.println("Digitaste mal el genero: ");
            }


            Persona p1 = new Persona(nombre,apellido,dni,edad,peso,altura,generoFinal);
            Persona p2 = new Persona("Luis","Aguado","1",35,80,180,Genero.M);
            Persona p3 = new Persona();
            p1.mostrarDatos();
            p2.mostrarDatos();
            p3.mostrarDatos();

            p1.setEdad(20);
            p2.setEdad(20);
            p3.setEdad(20);

            System.out.println("Datos despues de cambiar la edad a 20: ");
            p1.mostrarDatos();
            p2.mostrarDatos();
            p3.mostrarDatos();
            p1.imc();

            System.out.println("¿EL dni de p1 es igual al de p2 : " + p1.equals(p2));
            System.out.println("El hascode de p1 es: " + p1.hashCode());
            System.out.println("El hascode de p2 es: " + p2.hashCode());
            */

            /*Crea una lista de Persona, añade varias instancias, busca por DNI y
            elimina una persona; luego muestra todas.*/
            List<Persona> lista = new ArrayList<>();
            lista.add(new Persona("Felipe","Diego","555",31,80,180,Genero.M));
            lista.add(new Persona("Luis","Aguado","504",31,70.5,180 ,Genero.M));
            lista.add(new Persona("Alejandra","Vasquez","302",31,70,150,Genero.F));
            lista.add(new Persona("Vicente","Aguado","669",21,80,180,Genero.M));


            // Buscar
            String dniBuscado = "302";
            Persona encontrada =  lista.stream().filter(p -> p.getDni().equals(dniBuscado)).findFirst().orElse(null);

            System.out.println("Buscada: " + encontrada);

            // Eliminar
            //lista.removeIf(p -> p.getDni().equals("669"));

            // Mostrar todas
            for(Persona p : lista){
                System.out.println(p);
            }

            /*Ordena una colección de Persona por edad ascendente y, si hay empate, por apellido alfabético.
            Entrada: [(Ana,25),(Luis,25),(Bea,22)]
            Salida: [(Bea,22),(Ana,25),(Luis,25)]*/

            // Ordenar primero por edad , y si empatan por apellido
            lista.sort(
                    Comparator.comparingInt(Persona::getEdad)
                            .thenComparing(Persona::getApellido)
            );

            //Mostrar resultado
            lista.forEach(System.out::println);

        System.out.println("\nCreando persona desde CSV:");
        Persona p4 = Persona.from("Carlos, Gómez, 11223344C, 28, 75.5, 172");
        lista.add(p4);
        p4.mostrarDatos();

        }
    }
