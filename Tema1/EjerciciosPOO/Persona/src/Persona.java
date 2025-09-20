import java.util.Objects;

public class Persona {
    /*Crea una clase llamada Persona con:
    Propiedades: nombre (String), apellido (String), dni (String), edad (int), peso (double), altura (int)
    Métodos: mostrarDatos, getters y setters
    Constructores:
    Con todos los datos
    Sin peso ni altura
    Con nombre y apellidos; resto a 0 y dni = 111111111X
    Sin datos; inicializa a "datos por defecto", 1111111111X y 0
    Entrada: nombre="Ana", apellido="López", dni="12345678A", edad=25, peso=62.5, altura=170
    Salida: "Ana López (DNI: 12345678A) - Edad: 25 - Peso: 62.5 - Altura: 170"*/

    private String nombre, apellido , dni;
    private int edad , altura;
    private double peso;
    private Genero genero;





    public Persona(String nombre, String apellido, String dni, int edad, double peso, int altura, Genero genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
    }

    public Persona(String nombre, String apellido, String dni, int edad, double peso, int altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }


    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        edad = 0;
        altura = 0;
        peso = 0;
        dni ="11111111x";
    }

    public Persona() {
        nombre = "datos por defecto";
        apellido = "datos por defecto";
        edad = 0;
        altura = 0;
        peso = 0;
        dni = "1111111x";
    }

    public static Persona from(String csv){
        String[] p = csv.split(",");
        if(p.length != 6) throw new IllegalArgumentException("csv inválido");
        String nombre = p[0].trim();
        String apellido = p[1].trim();
        String dni = p[2].trim();
        if(!dni.matches("\\d{8}[A-Z]")) throw new IllegalArgumentException("DNI inválido");
        int edad = Integer.parseInt(p[3].trim());
        double peso = Double.parseDouble(p[4].trim());
        int altura = Integer.parseInt(p[5].trim());
        return new Persona(nombre,apellido,dni,edad,peso,altura);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /*En Entrada, para p1:
    Muestra su IMC
    Según el IMC, muestra estado físico usando la tabla:
    Peso inferior al normal: < 18.5
    Normal: 18.5 – 24.9
    Peso superior al normal: 25.0 – 29.9
    Obesidad: ≥ 30.0
    Entrada: imc=27.3
    Salida: "Peso superior al normal"*/

    public void imc(){
        double alturaComa = (double) altura / 100;
        System.out.println(alturaComa);
        double imc = peso / (alturaComa * alturaComa);
        System.out.printf("imc=%f%n",imc);
        if (getGenero() == genero.M){
            System.out.println("EL genero es masculino");
            if (imc < 18.5){
                System.out.println("Peso inferior al normal < 18.5");
            } else if (imc < 25) {
                System.out.println("Normal: 18.5 - 24.9");
            } else if (imc < 30) {
                System.out.println("Peso superior al normal: 25.0 - 29.9");
            } else {
                System.out.println("Obesidad");
            }
        } else {
            System.out.println("El genero es Femenino");
            if (imc < 18.5){
                System.out.println("Peso inferior al normal < 18.5");
            } else if (imc < 25) {
                System.out.println("Normal: 18.5 - 24.9");
            } else if (imc < 30) {
                System.out.println("Peso superior al normal: 25.0 - 29.9");
            } else {
                System.out.println("Obesidad");
            }
        }

    }

    public void mostrarDatos(){
        System.out.printf("%s %s (DNI: %s) - Edad: %d - Peso: %.1f - Altura: %d - Genero: %s\n",nombre,apellido,dni,edad,peso,altura,genero);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                ", peso=" + peso +
                ", genero=" + genero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }
}
