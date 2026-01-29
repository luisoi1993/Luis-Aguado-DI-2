import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';

@Component({
  selector: 'app-buscar',
  standalone: false,
  templateUrl: './buscar.html',
  styleUrl: './buscar.css',
})
export class Buscar {

    // 🔹 Simulación local (luego se sustituirá por servicio/pipe)
  tareas: Tarea[] = [
    new Tarea('Comprar comida', 'Ir al supermercado', 'media'),
    new Tarea('Estudiar Angular', 'Repasar pipes', 'alta'),
    new Tarea('Pasear al perro', '30 minutos', 'baja'),
  ];

  prioridadSeleccionada: 'baja' | 'media' | 'alta' | '' = '';

  get tareasFiltradas(): Tarea[] {
    if (!this.prioridadSeleccionada) {
      return this.tareas;
    }
    return this.tareas.filter(
      tarea => tarea.tipo === this.prioridadSeleccionada
    );
  }
}
