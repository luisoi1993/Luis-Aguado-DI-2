import model.Avion;
import model.Compania;
import model.Tractor;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Compania compania = new Compania();
        /*

        Tractor t1 = new Tractor("12312f","oi",100);
        compania.agregarTractor(t1);
        System.out.println(a1);

        compania.agregarVuelo();
        compania.mostrarVehiculos();
        compania.agregarVuelo();
        compania.mostrarVuelos();
        */
        Avion a1 = new Avion("1321","oi",111,111);
        compania.agregarAvion(a1);
        Avion a2 = new Avion("1412","Boing1",100,200);
        compania.agregarAvion(a2);
        Avion a3 = new Avion("1232131","Boing2",200,200);
        compania.agregarAvion(a3);
        Avion a4 = new Avion("41413413","Boing3",500,500);
        compania.agregarAvion(a4);
        Avion a5 = new Avion("421414g","Boing2",333,444);
        compania.agregarAvion(a5);
        Avion a6 = new Avion("4414gg","Boing",400,400);
        compania.agregarAvion(a6);

        Tractor t1 = new Tractor("12312f","oi",100);
        compania.agregarTractor(t1);
        Tractor t2 = new Tractor("sharp","Tractor",200);
        compania.agregarTractor(t2);
        Tractor t3 = new Tractor("oi","camion3",333);
        compania.agregarTractor(t3);
        Tractor t4 = new Tractor("45678h","camion3",242514);
        compania.agregarTractor(t4);
        Tractor t5 = new Tractor("214124g","tractor5",7777);
        compania.agregarTractor(t5);
        Tractor t6 = new Tractor("sfasfdf","camion4",42344);
        int opcion;

        do {
            System.out.println("Bienvenido a la compañia: ");
            System.out.println("1.Agregar vuelo: ");
            System.out.println("2.Listar vehiculos: ");
            System.out.println("3.Listar vuelos: ");
            System.out.println("4. Listar vuelos por avion: ");
            System.out.println("5.Cancelar vuelo: ");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1:
                    compania.agregarVuelo();
                    break;

                case 2:
                    compania.mostrarVehiculos();
                    break;

                case 3:
                    compania.mostrarVuelos();
                    break;

                case 4:
                    System.out.println("Digite la matricula del avion");
                    String matriculaAvion = entrada.nextLine();
                    compania.listarVuelosPorAvion(matriculaAvion);
                    break;

                case 0:
                    System.out.println("Saliendo ....");
                    break;

                default:
                    System.out.println("Opción no valida: ");
            }
        }while(opcion !=0);


    }
}
