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

 constructor(private tareasService: Tareas) {}

  // lista local (opcional visual)
  tareas: Tarea[] = [];

  // 🔹 objeto ligado al formulario
  nuevaTarea = {
    titulo: '',
    responsable: undefined as string | undefined,
    descripcion: '',
    tipo: 'media' as 'baja' | 'media' | 'alta',
    fecha: '' // string del input date
  };

  // 🔹 items temporales
  itemTemporal = '';
  items: string[] = [];

  // ===============================
  // AGREGAR ITEM
  // ===============================
  agregarItem(): void {
    if (this.itemTemporal.trim()) {
      this.items.push(this.itemTemporal.trim());
      this.itemTemporal = '';
    }
  }

  // ===============================
  // CREAR TAREA
  // ===============================
  agregarTarea(): void {

    // validación básica
    if (!this.nuevaTarea.titulo || !this.nuevaTarea.descripcion) {
      Swal.fire('Error', 'Título y descripción obligatorios', 'error');
      return;
    }

    // convertir fecha string → Date
    const fechaFinal = this.nuevaTarea.fecha
      ? new Date(this.nuevaTarea.fecha)
      : new Date();

    // crear instancia
    const tarea = new Tarea(
      this.nuevaTarea.titulo,
      this.nuevaTarea.responsable,
      this.nuevaTarea.descripcion,
      this.nuevaTarea.tipo,
      fechaFinal
    );

    // añadir items
    this.items.forEach(item => tarea.agregarItem(item));

    // guardar local
    this.tareas.push(tarea);

    // guardar en servicio
    this.tareasService.agregarTarea(tarea);

    // alerta éxito
    Swal.fire('Éxito', 'Tarea agregada correctamente', 'success');

    // reset formulario
    this.resetFormulario();
  }

  // ===============================
  // RESET FORM
  // ===============================
  private resetFormulario(): void {
    this.nuevaTarea = {
      titulo: '',
      responsable: undefined,
      descripcion: '',
      tipo: 'media',
      fecha: ''
    };

    this.items = [];
    this.itemTemporal = '';
  }
}