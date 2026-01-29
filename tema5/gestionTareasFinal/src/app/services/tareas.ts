import { Injectable } from '@angular/core';
import { Tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root',
})
export class Tareas {
  
  tareas: Tarea[] = [];

  //agregr una tarea
  agregarTarea(tarea: Tarea){
    //no se pueden crar tareas con un responsable que ya este en una tarea
    this.tareas.push(tarea);
  }
  //obtener todas las tareas
  getTareas(): Tarea[]{
    return this.tareas;
  }
//obtener la prioridad de la tarea
  getTareaPrioridad(tarea: Tarea): 'baja' | 'media' | 'alta' {
    return tarea.tipo;
  }

  //obtener todas las tareas por prioridad
}
