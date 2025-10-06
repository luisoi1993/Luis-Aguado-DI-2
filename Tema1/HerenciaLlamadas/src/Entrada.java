import model.*;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Centralita centralita = new Centralita();
        LlamadaProvincial l1 = new LlamadaProvincial(9999,3333,1,4);
        centralita.registrarLlamada(l1);
        LlamadaNacional l2 = new LlamadaNacional(12321,4121,44, 4, Franja.UNO);
        centralita.registrarLlamada(l2);
        centralita.calcularCoste();
        centralita.mostrarDatosTodas();
        int opcion;

        do {
            System.out.println("Bienvenido a la centralita: ");
            System.out.println("1. Registrar LLamada: ");
            System.out.println("2. Mostrar Costes: ");
            System.out.println("3. Mostrar llamadas realizadas: ");
            System.out.println("0. Salir");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("1.Llamada provincial");
                    System.out.println("2.Llamada Local");
                    System.out.println("3.Llamada Nacional");
                    int opcionLlamada = entrada.nextInt();

                    System.out.println("Digite el numero de Origen: ");
                    int numeroOrigen = entrada.nextInt();
                    System.out.println("Digite el numero de destino");
                    int numeroDestino = entrada.nextInt();
                    entrada.nextLine();
                    double coste;
                    System.out.println("Digite la duracion en segundos: ");
                    int duracion = entrada.nextInt();

                    switch (opcionLlamada){
                        case 1:
                            coste = 0;
                            LlamadaLocal ll = new LlamadaLocal(numeroOrigen,numeroDestino,duracion,coste);
                            centralita.registrarLlamada(ll);
                            break;

                        case 2:
                            coste = 15;
                            LlamadaProvincial lp = new LlamadaProvincial(numeroOrigen,numeroDestino,duracion,coste);
                            centralita.registrarLlamada(lp);
                            break;

                        case 3:
                            System.out.println("Digite la Franja de la llamada: (1,2,3)");
                            int franja = entrada.nextInt();
                            entrada.nextLine();
                            Franja franjaFinal;

                            switch (franja){
                                case 1:
                                    franjaFinal = Franja.UNO;
                                    coste = 20;
                                    break;

                                case 2:
                                    franjaFinal = Franja.DOS;
                                    coste = 25;
                                    break;

                                case 3:
                                    franjaFinal = Franja.TRES;
                                    coste = 30;
                                    break;

                                default:
                                    System.out.println("Si te equivovas se eligira la franja mas cara, la 3");
                                    franjaFinal = Franja.TRES;
                                    coste = 30;

                            }
                            LlamadaNacional ln = new LlamadaNacional(numeroOrigen,numeroDestino,duracion,coste,franjaFinal);
                            centralita.registrarLlamada(ln);
                            break;
                    }
                    break;
                case 2:
                    centralita.calcularCoste();
                    break;

                case 3:
                    centralita.mostrarDatosTodas();
                    break;

                case 0:
                    System.out.println("Salir...");
                    break;

                default:
                    System.out.println("Opcion no valida: ");
            }
        }while (opcion != 0);

    }
}
