import model.Avion;
import model.Compania;
import model.Tractor;

public class Entrada {

    public static void main(String[] args) {
        Compania compania = new Compania();
        Avion a1 = new Avion("1321","oi",111,111);
        compania.agregarAvion(a1);
        Tractor t1 = new Tractor("12312f","oi",100);
        compania.agregarTractor(t1);
        System.out.println(a1);

        compania.agregarVuelo();
        compania.mostrarVehiculos();
        compania.agregarVuelo();
    }
}
