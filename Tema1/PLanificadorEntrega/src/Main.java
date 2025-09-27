import model.Prioridad;
import model.Tarea;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Tarea t1 = new Tarea("oi",new Date(1000,9,1), Prioridad.Alta,false);
        System.out.println(t1);
    }
}
