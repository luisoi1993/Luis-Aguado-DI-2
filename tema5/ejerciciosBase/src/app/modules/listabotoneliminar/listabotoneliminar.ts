import { Component } from '@angular/core';

@Component({
  selector: 'app-listabotoneliminar',
  standalone: false,
  templateUrl: './listabotoneliminar.html',
  styleUrl: './listabotoneliminar.css',
})
export class Listabotoneliminar {

  tareas: string[] = [
    'Estudiar Angular',
    'Hacer ejercicios',
    'Repasar ngFor'
  ];

  eliminarTarea(index: number) {
    this.tareas.splice(index, 1);
  }

}
