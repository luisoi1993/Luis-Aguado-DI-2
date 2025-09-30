package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Empresa {
    Scanner entrada = new Scanner(System.in);
    List<Trabajador> listaTrabajadores = new ArrayList<Trabajador>();

    public void registrarJefe(Jefe jefe){
        boolean hayJefe = false;
        for (Trabajador trabajador: listaTrabajadores){
            if (trabajador instanceof Jefe){
                hayJefe = true;
            }
        }
        if (hayJefe == true){
            System.out.println("No se puede agregar otro jefe a la empresa:");
        }else {
            listaTrabajadores.add(jefe);
        }

    }

    public void registrarAsalariado(Asalariado asalariado){
        listaTrabajadores.add(asalariado);
    }

    public void registrarAutonomo(Autonomo autonomo){
        listaTrabajadores.add(autonomo);
    }

    public void mostrarLista(){
        for(Trabajador trabajador: listaTrabajadores){
            trabajador.mostrarDatos();
        }
    }

    public void mostrarAsalariados(){
        for (Trabajador trabajador : listaTrabajadores){
            if(trabajador instanceof Asalariado){
                trabajador.mostrarDatos();
            }
        }
    }

    public void mostrarAutonomos(){
        for (Trabajador trabajador : listaTrabajadores){
            if(trabajador instanceof Autonomo){
                trabajador.mostrarDatos();
            }
        }
    }

    public String asignarDni(String dni){
        boolean dniIgual = false;

        for (Trabajador trabajador : listaTrabajadores){
            if (Objects.equals(trabajador.getDni(), dni)){
                dniIgual = true;
            }
            if (dniIgual == true){
                System.out.println("Ya existe un dni exactamente igual:");
                System.out.println("Digite un nuevo DNI: ");
                dni = entrada.nextLine();

            }

        }
       if (dniIgual == true){
           asignarDni(dni);
       }

        return dni;
    }

    public void buscarPorDni(String dni){
        boolean trabajadorDni = false;
        for (Trabajador trabajador : listaTrabajadores){
            if (Objects.equals(trabajador.getDni(), dni)){
                trabajador.mostrarDatos();
                trabajadorDni = true;
            }
        }
        if (!trabajadorDni){
            System.out.println("No hay ningun trabajador con ese dni");
        }
    }
}
