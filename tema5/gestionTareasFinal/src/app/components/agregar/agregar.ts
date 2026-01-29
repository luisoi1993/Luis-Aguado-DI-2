import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import Swal from 'sweetalert2'
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-agregar',
  standalone: false,
  templateUrl: './agregar.html',
  styleUrl: './agregar.css',
})
export class Agregar {

  constructor(private tareasService: Tareas) {
    //logica
  }

  
 tareas: Tarea[] = [];

  // tarea en construcción
  nuevaTarea = {
    titulo: '',
    descripcion: '',
    tipo: 'media' as 'baja' | 'media' | 'alta'
  };

  // items temporales
  itemTemporal = '';
  items: string[] = [];

  agregarItem() {
    if (this.itemTemporal.trim().length > 0) {
      this.items.push(this.itemTemporal.trim());
      this.itemTemporal = '';
    }
  }

  agregarTarea() {
    if (!this.nuevaTarea.titulo || !this.nuevaTarea.descripcion) {
      Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
      return;
    }

    const tarea = new Tarea(
      this.nuevaTarea.titulo,
      this.nuevaTarea.descripcion,
      this.nuevaTarea.tipo
    );

    this.items.forEach(item => tarea.agregarItem(item));

    this.tareas.push(tarea);

    Swal.fire('Éxito', 'Tarea agregada correctamente', 'success');

    // reset
    this.nuevaTarea = { titulo: '', descripcion: '', tipo: 'media' };
    this.items = [];

    //llamar al metodo agrgarTarea del servicio
    this.tareasService.agregarTarea(tarea);
  }

}