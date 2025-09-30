import model.Asalariado;
import model.Autonomo;
import model.Empresa;
import model.Jefe;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Empresa empresa = new Empresa();
        Jefe j2 = new Jefe("Luis","Aguado","43242f",4,5.4);
        Asalariado a3 = new Asalariado("Alba","De vera","4423f",500,12,true);
        a3.mostrarDatos();
        j2.despedir(a3);
        a3.mostrarDatos();
        int opcion ;

        do {
            System.out.println("--------- Bienvenido a la gestión de empresa ----------");
            System.out.println("1.Agregar un Trabajador: ");
            System.out.println("2.Listar trabajadores: ");
            System.out.println("3.Buscar Trabajador por dni: ");
            System.out.println("4.Salir: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Eliga una opción: ");
                    System.out.println("1.Agregar Jefe");
                    System.out.println("2.Agregar Asalariado");
                    System.out.println("3.Agregar Autónomo");
                    int opcionEmpleado = entrada.nextInt();
                    entrada.nextLine();

                    System.out.println("Digite el nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.println("Digite el apellido: ");
                    String apellido = entrada.nextLine();
                    System.out.println("Digite el DNI: ");
                    String dni = entrada.nextLine();
                    dni = empresa.asignarDni(dni);

                    switch (opcionEmpleado){
                        case 1:
                            System.out.println("Digite el número de acciones");
                            int acciones = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Digite el beneficio: ");
                            double beneficio = entrada.nextDouble();
                            entrada.nextLine();
                            Jefe j1 = new Jefe(nombre,apellido,dni,acciones,beneficio);
                            empresa.registrarJefe(j1);
                            break;

                        case 2:
                            System.out.println("Digite el sueldo: ");
                            double sueldo = entrada.nextDouble();
                            entrada.nextLine();
                            System.out.println("Digite el número de pagas: ");
                            int numeroPagas = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Esta contratado (s/n)");
                            char contratadoSiONo = entrada.next().toLowerCase().charAt(0);
                            boolean contratado;

                            if(contratadoSiONo == 's'){
                                contratado = true;
                            } else if (contratadoSiONo == 'n') {
                                contratado = false;
                            } else {
                                System.out.println("no as digitado ni s ni n");
                                break;
                            }
                            Asalariado a1 = new Asalariado(nombre,apellido,dni,sueldo,numeroPagas,contratado);
                            empresa.registrarAsalariado(a1);
                            break;

                        case 3:
                            System.out.println("Digite el sueldo: ");
                            double sueldo2 = entrada.nextDouble();
                            entrada.nextLine();
                            System.out.println("Esta contratado (s/n)");
                            char contratadoSiONo2 = entrada.next().toLowerCase().charAt(0);
                            boolean contratado2;

                            if(contratadoSiONo2 == 's'){
                                contratado2 = true;
                            } else if (contratadoSiONo2 == 'n') {
                                contratado2 = false;
                            } else {
                                System.out.println("no as digitado ni s ni n");
                                break;
                            }

                            Autonomo a2 = new Autonomo(nombre,apellido,dni,sueldo2,contratado2);
                            empresa.registrarAutonomo(a2);
                            break;



                    }
                    break;
                case 2:
                    System.out.println("Elige que trabajadores mostrar: ");
                    System.out.println("1.Mostrar Asalariados");
                    System.out.println("2.Mostar Autónomos ");
                    System.out.println("3.Mostrar Todos");
                    int opcionMostrar = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcionMostrar){
                        case 1:
                            empresa.mostrarAsalariados();
                            break;

                        case 2:
                            empresa.mostrarAutonomos();
                            break;

                        case 3:
                            empresa.mostrarLista();
                            break;

                        default:
                            System.out.println("Opción incorrecta");
                    }
                    break;

                case 3:
                    System.out.println("Digite el dni del empleado que quiere buscar:");
                    String dniBuscar = entrada.nextLine();
                    empresa.buscarPorDni(dniBuscar);
                    break;

                case 4:
                    System.out.println("Saliendo.....");
                    break;

                default:
                    System.out.println("Opción incorrecta");
            }

        }while (opcion != 4);

    }
}
