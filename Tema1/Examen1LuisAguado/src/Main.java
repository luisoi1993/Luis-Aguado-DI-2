import model.PlataformaJuegos;
import model.VideojuegoAccion;
import model.VideojuegoEstrategia;
import model.VideojuegoRpg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        PlataformaJuegos plataformaJuegos = new PlataformaJuegos();
        VideojuegoAccion va1 = new VideojuegoAccion("Ocarina","Bethesda",2000,50.0,"TODOS LOS PUBLICOS",2,true);
        plataformaJuegos.anadirVideojuego(va1);
        VideojuegoAccion va2 = new VideojuegoAccion("Oi","Pinteres",2005,50.0,"MAS 18",5,true);
        plataformaJuegos.anadirVideojuego(va2);

        VideojuegoEstrategia ve1 = new VideojuegoEstrategia("Empire","lico",2020,40.0,"TODOS LOS PUBLICOS",1,100);
        plataformaJuegos.anadirVideojuego(ve1);
        VideojuegoEstrategia ve2 = new VideojuegoEstrategia("Empire2","lico",2020,40.0,"TODOS LOS PUBLICOS",1,100);
        plataformaJuegos.anadirVideojuego(ve2);

        VideojuegoRpg vr1 = new VideojuegoRpg("DYD","hasbro",2020,30.0,"MAS 18",true,100);
        plataformaJuegos.anadirVideojuego(vr1);
        VideojuegoRpg vr2 = new VideojuegoRpg("DYD2","hasbro",2020,30.0,"MAS 18",true,100);
        plataformaJuegos.anadirVideojuego(vr2);

        int opcion ;
        do {
            System.out.println("--------------- Bienvenido al menú ----------------");
            System.out.println("1. ver todos los juegos: ");
            System.out.println("2.Ver por categoria ");
            System.out.println("3.Ver por edad");
            System.out.println("4.ver un juego en concreto");
            System.out.println("5.Calcular el precio total de todo los videojuegos");
            System.out.println("0.Salir del programa");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    plataformaJuegos.mostrarTodosLosJuegos();
                    break;

                case 2:
                    System.out.println("Eliga el tipo de juego:");
                    System.out.println("1.rpg");
                    System.out.println("2.Estrategia");
                    System.out.println("3.Accion");
                    int opcionVideojuego = entrada.nextInt();
                    entrada.nextLine();
                    switch (opcionVideojuego){
                        case 1:
                            plataformaJuegos.mostrarRpg();
                            break;
                        case 2:
                            plataformaJuegos.mostrarEstrategia();
                            break;

                        case 3:
                            plataformaJuegos.mostrarAccion();
                            break;

                        default:
                            System.out.println("Opcion incorrecta");
                    }
                    break;

                case 3:
                    System.out.println("Eliga una opcion");
                    System.out.println("1 juegos para todos los publicos");
                    System.out.println("2.Juegos para mayores de 18");
                    int edadTipo = entrada.nextInt();
                    entrada.nextLine();

                    if(edadTipo == 1){
                        plataformaJuegos.clasificacionEdadMenores();
                    } else if (edadTipo == 2) {
                        plataformaJuegos.clasificacionEdadMayores();
                    } else {
                        System.out.println("Opcion no valida");
                    }
                    break;

                case 4:
                    System.out.println("Digite el titulo del juego");
                    String tituloJuego = entrada.nextLine();
                    plataformaJuegos.buscarPorNombre(tituloJuego);
                    break;

                case 5:
                    plataformaJuegos.calcularSumaPrecioTodos();
                    break;

                case 0:
                    System.out.println("Saliendo.....");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        }while(opcion != 0);

    }
}
