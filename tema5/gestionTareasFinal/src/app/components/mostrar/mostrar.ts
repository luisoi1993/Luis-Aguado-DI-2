import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-mostrar',
  standalone: false,
  templateUrl: './mostrar.html',
  styleUrl: './mostrar.css',
})
export class Mostrar {
prioridad: 'baja' | 'media' | 'alta' = 'media';
  /*
  tareas: Tarea[] = [
    new Tarea('Comprar comida', 'Ir al supermercado', 'media'),
    new Tarea('Estudiar Angular', 'Repasar pipes y ngFor', 'alta'),
    new Tarea('Pasear al perro', 'Salir 30 minutos', 'baja'),
  ];
  */

  constructor(private tareasService: Tareas) {
    //mostrar la lista de tareas del servicio
    this.tareas = this.tareasService.getTareas();
    //obtener la prioridad de todas las tareas para mostrar la imagen en las cards

    /*
    this.tareas.forEach(tarea => {
      this.prioridad = this.tareasService.getTareaPrioridad(tarea);
      console.log(`La prioridad de la tarea "${tarea.titulo}" es ${this.prioridad}`);
    }
      */
    

  }
  tareas: Tarea[] = [];
}
