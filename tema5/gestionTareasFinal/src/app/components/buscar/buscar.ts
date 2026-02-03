import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-buscar',
  standalone: false,
  templateUrl: './buscar.html',
  styleUrl: './buscar.css',
})
export class Buscar {
 
  constructor(private tareasService: Tareas) {}

  prioridadSeleccionada: 'baja' | 'media' | 'alta' | '' = '';

  // 👇 MISMO MÉTODO QUE USAS EN MOSTRAR
  get tareas(): Tarea[] {
    return this.tareasService.getTareas();
  }

  get tareasFiltradas(): Tarea[] {
    if (!this.prioridadSeleccionada) return this.tareas;

    return this.tareas.filter(
      t => t.tipo === this.prioridadSeleccionada
    );
  }
  
}
